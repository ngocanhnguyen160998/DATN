package com.dto;

import java.util.Date;

public class OrderDetailDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private String province;
    private String district;
    private String commune;
    private String specialNotes;
    private Date modefinedDate;
    private Long totalPrice;
    private String paymentMethod;
    private String userName;
    private String productName;
    private Long unitPrice;
    private Integer amount;
    private Long status;

    public OrderDetailDTO() {
    }

    public OrderDetailDTO(Long id, String firstName, String lastName, String email, String phone, String address, String province, String district, String commune, String specialNotes, Date modefinedDate, Long totalPrice, String paymentMethod, String userName, String productName, Long unitPrice, Integer amount, Long status) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.province = province;
        this.district = district;
        this.commune = commune;
        this.specialNotes = specialNotes;
        this.modefinedDate = modefinedDate;
        this.totalPrice = totalPrice;
        this.paymentMethod = paymentMethod;
        this.userName = userName;
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.amount = amount;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }

    public String getSpecialNotes() {
        return specialNotes;
    }

    public void setSpecialNotes(String specialNotes) {
        this.specialNotes = specialNotes;
    }

    public Date getModefinedDate() {
        return modefinedDate;
    }

    public void setModefinedDate(Date modefinedDate) {
        this.modefinedDate = modefinedDate;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Long unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
