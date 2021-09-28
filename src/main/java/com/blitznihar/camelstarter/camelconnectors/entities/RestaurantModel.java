package com.blitznihar.camelstarter.camelconnectors.entities;

import java.io.Serializable;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

@CsvRecord( separator = "," , skipFirstLine = true)
public class RestaurantModel implements Serializable{

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

    @DataField(pos=1)
    private String id;
    @DataField(pos=2)
    private String name;
    @DataField(pos=3)
    private String borough;
    @DataField(pos=4)
    private String cuisine;

    @Override
    public String toString() {
        return "Restaurant: [borough=" + borough + ", cuisine=" + cuisine + ", id=" + id + ", name=" + name + "]";
    }
}

