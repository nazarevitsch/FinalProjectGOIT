package com.bida.finalproject.riaautos.domain;

public class Auto {

    private String title;
    private String phone;
    private int price;
    private String locationCityName;
    private String linkToView;
    private String seoLinkM;

    public Auto(){}

    public Auto(String title, String phone, int price, String locationCityName, String linkToView, String seoLinkM) {
        this.title = title;
        this.phone = phone;
        this.price = price;
        this.locationCityName = locationCityName;
        this.linkToView = linkToView;
        this.seoLinkM = seoLinkM;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getLocationCityName() {
        return locationCityName;
    }

    public void setLocationCityName(String locationCityName) {
        this.locationCityName = locationCityName;
    }

    public String getLinkToView() {
        return linkToView;
    }

    public void setLinkToView(String linkToView) {
        this.linkToView = "https://auto.ria.com" + linkToView;
    }

    public String getSeoLinkM() {
        return seoLinkM;
    }

    public void setSeoLinkM(String seoLinkM) {
        this.seoLinkM = seoLinkM;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "title='" + title + '\'' +
                ", phone='" + phone + '\'' +
                ", price=" + price +
                ", locationCityName='" + locationCityName + '\'' +
                ", linkToView='" + linkToView + '\'' +
                ", seoLinkM='" + seoLinkM + '\'' +
                '}';
    }
}
