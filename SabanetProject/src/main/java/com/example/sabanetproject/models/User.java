package com.example.sabanetproject.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name must be provided.")
    @Size(min=3,max=30,message = "Name must be at least 3 characters.")
    private String name;
    @Email
    @NotBlank(message = "Email must be provided.")
    @Size(min=5,message = "Email must be at least 5 characters.")
    private String email;
    @NotBlank(message = "Password must be provided.")
    @Size(min=8,max=128,message = "Password must be at least 8 characters.")
    private String password;
    @Transient
    @NotBlank(message = "Confirm must be provided.")
    @Size(min=8,max=128,message = "Confirm must be at least 8 characters.")
    private String confirm;
    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;

    @OneToMany(mappedBy = "customer",fetch = FetchType.LAZY)
    private List<Repair> customerRepairs;

    @OneToMany(mappedBy = "technician", fetch = FetchType.LAZY)
    private List<Report> technicianReports;

    @OneToMany(mappedBy = "acceptance", fetch = FetchType.LAZY)
    private List<Report> acceptanceReports;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<Report> customerReports;

//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "users_repairs",
//               joinColumns = @JoinColumn(name = "user_id"),
//               inverseJoinColumns = @JoinColumn(name = "repair_id"))
//    private List<Repair> repairs;

    public User(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Repair> getCustomerRepairs() {
        return customerRepairs;
    }

    public void setCustomerRepairs(List<Repair> customerRepairs) {
        this.customerRepairs = customerRepairs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public Date getCreatedAt() {
        return createdAt;
    }


    public Date getUpdatedAt() {
        return updatedAt;
    }

    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

    public List<Report> getTechnicianReports() {
        return technicianReports;
    }

    public void setTechnicianReports(List<Report> technicianReports) {
        this.technicianReports = technicianReports;
    }

    public List<Report> getAcceptanceReports() {
        return acceptanceReports;
    }

    public void setAcceptanceReports(List<Report> acceptanceReports) {
        this.acceptanceReports = acceptanceReports;
    }

    public List<Report> getCustomerReports() {
        return customerReports;
    }

    public void setCustomerReports(List<Report> customerReports) {
        this.customerReports = customerReports;
    }
}
