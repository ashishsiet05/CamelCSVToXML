package com.blitznihar.camelstarter.camelconnectors.entities;

import java.io.Serializable;

public class AddressModel implements Serializable{

    public AddressModel() {
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    private String street;
    private String building;
    private String zipcode;

    public AddressModel(String street, String building, String zipcode) {
        this.street = street;
        this.building = building;
        this.zipcode = zipcode;
    }
}