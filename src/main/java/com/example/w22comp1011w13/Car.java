package com.example.w22comp1011w13;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Car implements Comparable<Car>{
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

    public String toString()
    {
        return String.format("%d-%s %s %s $%.2f",id,types,make,model,price);
    }

    public boolean isType(String typeToCheck)
    {
        return types.contains(typeToCheck);
    }

    /**
     * This method will return true if the search string matches any of the
     * car elements
     */
    public boolean contains(String searchString)
    {
        String idString = Integer.toString(id);
        String yearString = Integer.toString(year);

        return make.contains(searchString) || model.contains(searchString) ||
                idString.contains(searchString) || yearString.contains(searchString);
    }

    /**
     * This method will use the make and model of a car to identify the sort order
     *
     * if the method returns a negative #, the current car object would go first
     * 0 means the 2 car objects are equivalent
     * a positive # sorts if after the "otherCar"
     *
     * @param otherCar
     * @return
     */
    @Override
    public int compareTo(Car otherCar) {
        return (make+model.toLowerCase()+id).compareTo(
                otherCar.getMake()+otherCar.getModel().toLowerCase()+otherCar.getId());
    }
}
