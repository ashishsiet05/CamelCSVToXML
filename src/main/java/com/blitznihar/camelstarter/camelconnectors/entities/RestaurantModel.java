package com.blitznihar.camelstarter.camelconnectors.entities;

import java.io.Serializable;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

@CsvRecord( separator = "," , skipFirstLine = true)
public class RestaurantModel implements Serializable{
    @DataField(pos=1)
    private String id;
    @DataField(pos=2)
    private String name;
    @DataField(pos=3)
    private String borough;
    @DataField(pos=4)
    private String cuisine;
    @DataField(pos=5)
    private String street;
    @DataField(pos=6)
    private String building;
    @DataField(pos=7)
    private String zipcode;

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
    public String getBorough() {
        return borough;
    }
    public void setBorough(String borough) {
        this.borough = borough;
    }
    public String getCuisine() {
        return cuisine;
    }
    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
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

    @Override
    public String toString() {
        return "RestaurantModel [borough=" + borough + ", building=" + building + ", cuisine=" + cuisine + ", id=" + id
                + ", name=" + name + ", street=" + street + ", zipcode=" + zipcode + "]";
    }
    

}

