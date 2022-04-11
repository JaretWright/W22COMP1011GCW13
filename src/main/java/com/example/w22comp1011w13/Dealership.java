package com.example.w22comp1011w13;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Dealership {

    @SerializedName("Dealership")
    private String dealershipName;

    @SerializedName("Inventory")
    private ArrayList<Car> inventory;

    public String getDealershipName() {
        return dealershipName;
    }

    public ArrayList<Car> getInventory() {
        return inventory;
    }
}
