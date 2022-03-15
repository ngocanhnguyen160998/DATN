package com.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(unique = true, nullable = false)
    private String email;

    @Column
    private String address;

    @Column(unique = true)
    private String phone_number;

    @Column
    private String sex;

    @Column
    private LocalDate birthday;

    @Column
    private Integer enable;

    @Column
    private String verification_Code;

    @Column
    private String provinceId;

    @Column
    private String districtId;

    @Column
    private String wardId;

    @OneToMany(mappedBy = "user_comment")
    @JsonIgnore
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "userOrder")
    @JsonIgnore
    private List<Order> orders = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "group_id")
    private UserGroup userGroup = new UserGroup();

    @ManyToMany
    @JsonIgnore
    @JoinTable(name = "permission"
            , joinColumns = @JoinColumn(name = "user_id", nullable = false)
            , inverseJoinColumns = @JoinColumn(name = "role_id", nullable = false))
    private List<Role> rolesUser = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public String getVerification_Code() {
        return verification_Code;
    }

    public void setVerification_Code(String verification_Code) {
        this.verification_Code = verification_Code;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String province_id) {
        this.provinceId = province_id;
    }

    public String getDistrictId() {
        return districtId;
    }

    public void setDistrictId(String district_id) {
        this.districtId = district_id;
    }

    public String getWardId() {
        return wardId;
    }

    public void setWardId(String ward_id) {
        this.wardId = ward_id;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public UserGroup getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(UserGroup userGroup) {
        this.userGroup = userGroup;
    }

    public List<Role> getRolesUser() {
        return rolesUser;
    }

    public void setRolesUser(List<Role> roles_user) {
        this.rolesUser = roles_user;
    }
}
