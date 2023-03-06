package com.example.sabanetproject.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "repairs")
public class Repair {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String deviceSerial;
    private String brand;
    private String deviceTemplate;
    private String problemDescription;
    private String purchaseDate;
    private String warrantyExpiryDate;
    private String additionalNotes;
    private String password;
    private String customerName;
    private String fullAddress;
    private String telephoneNumber;
    private String email;
    private String fiscalCode;
    private String vatNumber;
    private String pec;
    private String sdiCode;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private User customer;

    @OneToMany(mappedBy = "repair",fetch = FetchType.LAZY)
    private List<Report> reports;

//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "users_repairs",
//            joinColumns = @JoinColumn(name = "repair_id"),
//            inverseJoinColumns = @JoinColumn(name = "user_id"))
//    private List<User> users;

    public Repair(){

    }

    public Repair(String deviceSerial, String brand, String deviceTemplate, String problemDescription, String purchaseDate, String warrantyExpiryDate, String additionalNotes, String password, String customerName, String fullAddress, String telephoneNumber, String email, String fiscalCode, String vatNumber, String pec, String sdiCode) {
        this.deviceSerial = deviceSerial;
        this.brand = brand;
        this.deviceTemplate = deviceTemplate;
        this.problemDescription = problemDescription;
        this.purchaseDate = purchaseDate;
        this.warrantyExpiryDate = warrantyExpiryDate;
        this.additionalNotes = additionalNotes;
        this.password = password;
        this.customerName = customerName;
        this.fullAddress = fullAddress;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.fiscalCode = fiscalCode;
        this.vatNumber = vatNumber;
        this.pec = pec;
        this.sdiCode = sdiCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeviceSerial() {
        return deviceSerial;
    }

    public void setDeviceSerial(String deviceSerial) {
        this.deviceSerial = deviceSerial;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDeviceTemplate() {
        return deviceTemplate;
    }

    public void setDeviceTemplate(String deviceTemplate) {
        this.deviceTemplate = deviceTemplate;
    }

    public String getProblemDescription() {
        return problemDescription;
    }

    public void setProblemDescription(String problemDescription) {
        this.problemDescription = problemDescription;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getWarrantyExpiryDate() {
        return warrantyExpiryDate;
    }

    public void setWarrantyExpiryDate(String warrantyExpiryDate) {
        this.warrantyExpiryDate = warrantyExpiryDate;
    }

    public String getAdditionalNotes() {
        return additionalNotes;
    }

    public void setAdditionalNotes(String additionalNotes) {
        this.additionalNotes = additionalNotes;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFiscalCode() {
        return fiscalCode;
    }

    public void setFiscalCode(String fiscalCode) {
        this.fiscalCode = fiscalCode;
    }

    public String getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

    public String getPec() {
        return pec;
    }

    public void setPec(String pec) {
        this.pec = pec;
    }

    public String getSdiCode() {
        return sdiCode;
    }

    public void setSdiCode(String sdiCode) {
        this.sdiCode = sdiCode;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public List<Report> getReports() {
        return reports;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }
}