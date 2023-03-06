package com.example.sabanetproject.controllers;

import com.example.sabanetproject.models.LoginUser;
import com.example.sabanetproject.models.Repair;
import com.example.sabanetproject.models.Report;
import com.example.sabanetproject.models.User;
import com.example.sabanetproject.services.RepairService;
import com.example.sabanetproject.services.ReportService;
import com.example.sabanetproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;


@Controller
public class ApiController {

    @Autowired
    private RepairService repairService;
    @Autowired
    private ReportService reportService;
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index(Model model, @ModelAttribute("newUser") User newUser, @ModelAttribute("newLogin") LoginUser newLogin) {
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "index";
    }

    //Post Mapping for registering the user
    @PostMapping("/register")
    public String register(Model model, HttpSession session, @Valid @ModelAttribute("newUser") User newUser, BindingResult result) {
        userService.register(newUser, result);
        if (result.hasErrors()) {
            model.addAttribute("newLogin", new LoginUser());
            return "index";
        } else {
            session.setAttribute("loggedInUserId", newUser.getId());
            return "redirect:/dashboard";
        }
    }

    //Post Mapping for login-ing the user
    @PostMapping("/login")
    public String login(Model model, HttpSession session, @Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result) {
        User user = this.userService.login(newLogin, result);
        if (result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index";
        } else {
            session.setAttribute("loggedInUserId", user.getId());
            return "redirect:/dashboard";
        }
    }

    //GetMapping to logout the current user using session
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    //Main Page that shows up when a user registers,login
    //A list of every Course appears
    @GetMapping("/dashboard")
    public String dashboard(Model model, HttpSession session) {
        Long loggedInUserId = (Long) session.getAttribute("loggedInUserId");
        if (loggedInUserId == null) {
            return "redirect:/";
        } else {
            User user = userService.findById(loggedInUserId);
            model.addAttribute("user", userService.findById(loggedInUserId));
            if (loggedInUserId == 1) {
                return "redirect:/acceptance/dashboard";
            }
            if (loggedInUserId == 2) {
                return "redirect:/technician/dashboard";
            } else {
                model.addAttribute("repairs",user.getCustomerRepairs());
                model.addAttribute("reports",user.getCustomerReports());
                return "dashboard";
            }
        }
    }

    @GetMapping("/acceptance/dashboard")
    public String acceptanceDashboard(Model model,HttpSession session){
        Long loggedInUserId = (Long) session.getAttribute("loggedInUserId");
        if (loggedInUserId == null && loggedInUserId !=1) {
            return "redirect:/";
        }
        User user = userService.findById(loggedInUserId);
        model.addAttribute("user",user);
        model.addAttribute("repairs",repairService.findAll());
        model.addAttribute("reports",reportService.findAll());

        return "acceptanceDashboard";
    }

    @GetMapping("/technician/dashboard")
    public String technicianDashboard(Model model,HttpSession session){
        Long loggedInUserId = (Long) session.getAttribute("loggedInUserId");
        if (loggedInUserId == null && loggedInUserId!= 2) {
            return "redirect:/";
        }
        User user = userService.findById(loggedInUserId);
        model.addAttribute("user",user);
        model.addAttribute("reports",reportService.findAll());

        return "technicianDashboard";
    }

    @GetMapping("/user/repair")
    public String newRepair(Model model,HttpSession session){
        Long loggedInUserId = (Long) session.getAttribute("loggedInUserId");
        if (loggedInUserId == null) {
            return "redirect:/";
        }
        User user = userService.findById(loggedInUserId);
        model.addAttribute("user",user);
        Repair repair = new Repair();
        model.addAttribute("repair",repair);
        return "newRepair";
    }

    @PostMapping("/user/repair")
    public String createRepair(@Valid @ModelAttribute("repair")Repair repair,BindingResult result,Model model,HttpSession session){
        Long loggedInUserId = (Long) session.getAttribute("loggedInUserId");
        if (loggedInUserId == null) {
            return "redirect:/";
        }
        User user = userService.findById(loggedInUserId);
        model.addAttribute("user",user);
        repair.setCustomer(user);
        repair.setCustomerName(user.getName());
        if (result.hasErrors()){
            model.addAttribute("users",userService.findAll());
            model.addAttribute("repair", new Repair());
            return "newRepair";
        }
        else {
            repairService.createRepair(repair);
            return "redirect:/dashboard";
        }
    }

    @GetMapping("/acceptance/newReport/{id}")
    public String newReport(Model model, HttpSession session, @ModelAttribute("report")Report report,@PathVariable("id") Long id){
        Long loggedInUserId = (Long) session.getAttribute("loggedInUserId");
        if (loggedInUserId == null && loggedInUserId!= 1) {
            return "redirect:/";
        }
        User user = userService.findById(loggedInUserId);
        model.addAttribute("user",user);
        model.addAttribute("repair",repairService.findById(id));
        model.addAttribute("report",new Report());
        return "newReport";
    }

    @PostMapping("/acceptance/newReport/{id}")
    public String createReport(@Valid @ModelAttribute("report") Report report,BindingResult result,Model model,HttpSession session,@PathVariable("id") Long id){
        Long loggedInUserId = (Long) session.getAttribute("loggedInUserId");
        if (loggedInUserId == null && loggedInUserId!= 1) {
            return "redirect:/";
        }
        User user = userService.findById(loggedInUserId);
        model.addAttribute("user",user);
        if(result.hasErrors()){
            model.addAttribute("report",new Report());
            return "newReport";
        }
        Repair repair =repairService.findById(id);
        report.setRepair(repairService.findById(id));
        report.setAcceptance(user);
        report.setCustomer(repair.getCustomer());
        report.setTechnician(userService.findById(2L));
        reportService.createReport(report);
        return "redirect:/acceptance/dashboard";
    }

    @GetMapping("/report/details/{id}")
    public String reportDetails(@PathVariable("id") Long id,Model model,HttpSession session){
        Long loggedInUserId = (Long) session.getAttribute("loggedInUserId");
        if (loggedInUserId == null) {
            return "redirect:/";
        }
        User user = userService.findById(loggedInUserId);
        model.addAttribute("user",user);
        Report report = reportService.findById(id);
        model.addAttribute("report",report);
        return "reportDetails";
    }

    @GetMapping("/report/{id}/{repairId}")
    public String editReport(@PathVariable("id") Long id,Model model,HttpSession session){
        Long loggedInUserId = (Long) session.getAttribute("loggedInUserId");
        if (loggedInUserId == null && loggedInUserId!= 2) {
            return "redirect:/";
        }
        User user = userService.findById(loggedInUserId);
        model.addAttribute("user",user);
        Report report = reportService.findById(id);
        model.addAttribute("report",report);
        return "updateReport";
    }

    @PutMapping("/report/{id}/{repairId}")
    public String updateReport(@PathVariable("id") Long id,Model model,HttpSession session,@Valid @ModelAttribute("report") Report report,BindingResult result,@PathVariable("repairId") Long repairId){
        Long loggedInUserId = (Long) session.getAttribute("loggedInUserId");
        if (loggedInUserId == null && loggedInUserId!= 2) {
            return "redirect:/";
        }
        User user = userService.findById(loggedInUserId);
        model.addAttribute("user",user);
        model.addAttribute("report",report);
        if(result.hasErrors()){
            return "updateReport";
        }
        else {
            Repair repair = repairService.findById(repairId);
            report.setRepair(repair);
            report.setAcceptance(userService.findById(1L));
            report.setCustomer(repair.getCustomer());
            report.setTechnician(userService.findById(2L));
            reportService.updateReport(report);
            return "redirect:/technician/dashboard";
        }
    }

}
