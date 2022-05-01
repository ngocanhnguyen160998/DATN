package com.model;

import javax.persistence.*;

@Entity
@Table(name = "commune")
public class Commune {
    @Id
    private String id;
    private String name;
    private String type;
    private Long transportFee;

    @ManyToOne
    @JoinColumn(name = "district_id")
    private District district = new District();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getTransportFee() {
        return transportFee;
    }

    public void setTransportFee(Long transportFee) {
        this.transportFee = transportFee;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }
}
