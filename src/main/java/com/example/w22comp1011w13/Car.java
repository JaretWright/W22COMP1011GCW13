package com.example.w22comp1011w13;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Car {
    private int id;
    private int year;
    private String make;
    private double price;
    private String model;

    @SerializedName("type")
    private ArrayList<String> types;

    public int getId() {
        return id;
    }

    public int getYear() {
        return year;
    }

    public String getMake() {
        return make;
    }

    public double getPrice() {
        return price;
    }

    public String getModel() {
        return model;
    }

    public ArrayList<String> getTypes() {
        return types;
    }
}
