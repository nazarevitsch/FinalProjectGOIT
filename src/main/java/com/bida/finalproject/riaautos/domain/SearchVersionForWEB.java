package com.bida.finalproject.riaautos.domain;

import org.hibernate.annotations.Formula;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "searches")
public class SearchVersionForWEB {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private long id;

    @Column(name = "username")
    private String username;

    @Column(name = "category_id")
    private long categoryID;

    @Transient
    private String categoryName;

    @Column(name = "body_style_id")
    private long bodyStyleID;

    @Transient
    private String bodyStyleName;

    @Column(name = "mark_id")
    private long markID;

    @Transient
    private String markName;

    @Formula("(select m.name from models m where model_id = m.value)")
    private String model;

    @Column(name = "gear_box_id")
    private long gearBoxID;

    @Transient
    private String gearBoxName;

    @Column(name = "fuel_type_id")
    private long fuelTypeID;

    @Transient
    private String fuelTypeName;

    @Formula("(select r.name from regions r where region_id = r.value)")
    private String region;

    @Formula("(select c.name from colors c where color_id = c.value)")
    private String color;

    @Column(name = "price_from")
    private int priceFrom;

    @Column(name = "price_to")
    private int priceTo;

    public SearchVersionForWEB() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(long categoryID) {
        this.categoryID = categoryID;
    }

    public long getBodyStyleID() {
        return bodyStyleID;
    }

    public void setBodyStyleID(long bodyStyleID) {
        this.bodyStyleID = bodyStyleID;
    }

    public long getMarkID() {
        return markID;
    }

    public void setMarkID(long markID) {
        this.markID = markID;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public long getGearBoxID() {
        return gearBoxID;
    }

    public void setGearBoxID(long gearBoxID) {
        this.gearBoxID = gearBoxID;
    }

    public long getFuelTypeID() {
        return fuelTypeID;
    }

    public void setFuelTypeID(long fuelTypeID) {
        this.fuelTypeID = fuelTypeID;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPriceFrom() {
        return priceFrom;
    }

    public void setPriceFrom(int priceFrom) {
        this.priceFrom = priceFrom;
    }

    public int getPriceTo() {
        return priceTo;
    }

    public void setPriceTo(int priceTo) {
        this.priceTo = priceTo;
    }

    public String getBodyStyleName() {
        return bodyStyleName;
    }

    public void setBodyStyleName(String bodyStyleName) {
        this.bodyStyleName = bodyStyleName;
    }

    public String getMarkName() {
        return markName;
    }

    public void setMarkName(String markName) {
        this.markName = markName;
    }

    public String getGearBoxName() {
        return gearBoxName;
    }

    public void setGearBoxName(String gearBoxName) {
        this.gearBoxName = gearBoxName;
    }

    public String getFuelTypeName() {
        return fuelTypeName;
    }

    public void setFuelTypeName(String fuelTypeName) {
        this.fuelTypeName = fuelTypeName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "SearchVersionForWEB{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", categoryID=" + categoryID +
                ", bodyStyleID=" + bodyStyleID +
                ", bodyStyleName='" + bodyStyleName + '\'' +
                ", markID=" + markID +
                ", markName='" + markName + '\'' +
                ", modelID='" + model + '\'' +
                ", gearBoxID=" + gearBoxID +
                ", gearBoxName='" + gearBoxName + '\'' +
                ", fuelTypeID=" + fuelTypeID +
                ", fuelTypeName='" + fuelTypeName + '\'' +
                ", region='" + region + '\'' +
                ", color='" + color + '\'' +
                ", priceFrom=" + priceFrom +
                ", priceTo=" + priceTo +
                '}';
    }
}
