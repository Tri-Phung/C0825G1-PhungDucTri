package com.codegym.customer_list.entity;

public class Customer {
    private String name;
    private String dob;
    private String city;
    private String srcImage;

    public Customer(String name, String dob, String city, String srcImage) {
        this.name = name;
        this.dob = dob;
        this.city = city;
        this.srcImage = srcImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSrcImage() {
        return srcImage;
    }

    public void setSrcImage(String srcImage) {
        this.srcImage = srcImage;
    }
}
