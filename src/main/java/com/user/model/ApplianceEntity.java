package com.user.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="APPLIANCES")
public class ApplianceEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serialnumber;

    @Column(name="brand")
    private String brand;

    @Column(name="model")
    private String model;

    @Column(name="status")
    private String status;

    @Column(name="date")
    private Date date;


    public ApplianceEntity() {
    }

    public ApplianceEntity(Long id, String brand, String model, String status,Date date) {
        super();
        this.serialnumber = id;
        this.brand = brand;
        this.model = model;
        this.status = status;
        this.date=date;
    }

    public Long getSerialnumber() {
        return serialnumber;
    }

    public void setSerialnumber(Long serialnumber) {
        this.serialnumber = serialnumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
