package com.model;

import javax.persistence.*;

@Entity
@Table(name ="v_statistic")
public class Statistic {
    @Id
    private Long id;
    private String name;
    private Long inputMoney;
    private Long outputMoney;
    private Long profit;

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

    public Long getInputMoney() {
        return inputMoney;
    }

    public void setInputMoney(Long inputMoney) {
        this.inputMoney = inputMoney;
    }

    public Long getOutputMoney() {
        return outputMoney;
    }

    public void setOutputMoney(Long outputMoney) {
        this.outputMoney = outputMoney;
    }

    public Long getProfit() {
        return profit;
    }

    public void setProfit(Long profit) {
        this.profit = profit;
    }
}
