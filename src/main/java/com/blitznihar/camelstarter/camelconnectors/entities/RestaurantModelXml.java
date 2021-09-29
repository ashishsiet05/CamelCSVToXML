package com.blitznihar.camelstarter.camelconnectors.entities;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "restaurant")
public class RestaurantModelXml implements Serializable{

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public String getBorough() {
        return borough;
    }

    public void setBorough(String borough) {
        this.borough = borough;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    private String id;

    @Override
    public String toString() {
        return "RestaurantModelXml [address=" + address + ", borough=" + borough + ", cuisine=" + cuisine + ", id=" + id
                + ", name=" + name + "]";
    }


    private String name;
   
    private String borough;

    private String cuisine;

    public AddressModel getAddress() {
        return address;
    }

    public void setAddress(AddressModel address) {
        this.address = address;
    }

    @XmlElement(name="address")
    private AddressModel address;

    
}

