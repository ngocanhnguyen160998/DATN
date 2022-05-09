package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "v_statistic_product")
public class StatisticProduct {
    @Id
    private Long id;
    private String name;
    private Long totalPrice;
    private Date modefinedDate;


    public StatisticProduct() {
    }

    public StatisticProduct(Long id, String name, Long totalPrice, Date modefinedDate) {
        this.id = id;
        this.name = name;
        this.totalPrice = totalPrice;
        this.modefinedDate = modefinedDate;
    }

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

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getModefinedDate() {
        return modefinedDate;
    }

    public void setModefinedDate(Date modefinedDate) {
        this.modefinedDate = modefinedDate;
    }
}
