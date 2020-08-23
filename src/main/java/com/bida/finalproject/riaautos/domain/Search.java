package com.bida.finalproject.riaautos.domain;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "searches")
public class Search {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private long id;

    @Column(name = "username")
    private String username;

    @Column(name = "category_id")
    private long categoryID;

    @Column(name = "body_style_id")
    private long bodyStyleID;

    @Column(name = "mark_id")
    private long markID;

    @Column(name = "model_id")
    private long modelID;

    @Column(name = "gear_box_id")
    private long gearBoxID;

    @Column(name = "fuel_type_id")
    private long fuelTypeID;

    @Column(name = "region_id")
    private long regionID;

    @Column(name = "color_id")
    private long colorID;

    @Column(name = "price_from")
    private int priceFrom;

    @Column(name = "price_to")
    private int priceTo;

    public Search(long categoryID, long bodyStyleID, long markID, long modelID, long gearBoxID, long fuelTypeID, long regionID, long colorID, int priceFrom, int priceTo) {
        this.categoryID = categoryID;
        this.bodyStyleID = bodyStyleID;
        this.markID = markID;
        this.modelID = modelID;
        this.gearBoxID = gearBoxID;
        this.fuelTypeID = fuelTypeID;
        this.regionID = regionID;
        this.colorID = colorID;
        this.priceFrom = priceFrom;
        this.priceTo = priceTo;
    }

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

    public long getModelID() {
        return modelID;
    }

    public void setModelID(long modelID) {
        this.modelID = modelID;
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

    public long getRegionID() {
        return regionID;
    }

    public void setRegionID(long regionID) {
        this.regionID = regionID;
    }

    public long getColorID() {
        return colorID;
    }

    public void setColorID(long colorID) {
        this.colorID = colorID;
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

    @Override
    public String toString() {
        return "Search{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", categoryID=" + categoryID +
                ", bodyStyleID=" + bodyStyleID +
                ", markID=" + markID +
                ", modelID=" + modelID +
                ", gearBoxID=" + gearBoxID +
                ", fuelTypeID=" + fuelTypeID +
                ", regionID=" + regionID +
                ", colorID=" + colorID +
                ", priceFrom=" + priceFrom +
                ", priceTo=" + priceTo +
                '}';
    }
}
