package com.model;

import javax.persistence.*;

@Entity
@Table(name = "wards")
public class Ward {
    @Id
    private String id;

    @Column
    private String name;

    @Column
    private String type;

    @Column
    private Long transport_fee;

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

    public Long getTransport_fee() {
        return transport_fee;
    }

    public void setTransport_fee(Long transport_fee) {
        this.transport_fee = transport_fee;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }
}
