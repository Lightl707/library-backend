package com.github.arlan.library.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "address")
public class Address {
    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = "country")
    private String country;

    @DatabaseField(columnName = "city")
    private String city;

    @DatabaseField(unique = true,columnName = "text")
    private String text;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public Address() {
    }

    public Address(int id,String country,String city,String text) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.text = text;
    }
}