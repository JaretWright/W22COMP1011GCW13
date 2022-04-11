package com.example.w22comp1011w13;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import java.util.TreeSet;

public class DealerViewController implements Initializable {

    @FXML
    private ListView<Car> carListView;

    @FXML
    private Label dealerNameLabel;

    @FXML
    private TextField searchTextField;

    @FXML
    private ListView<String> typeOfCarListView;

    @FXML
    private Label numOfVehiclesLabel;

    @FXML
    private Label vehicleValueLabel;

    private ArrayList<Car> inventory;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Dealership dealership = ReadJson.getDealershipFromJson("carData.json");
        dealerNameLabel.setText(dealership.getDealershipName());
        inventory = dealership.getInventory();
        Collections.sort(inventory);

        carListView.getItems().addAll(inventory);

        TreeSet<String> types = new TreeSet<>();
        for (Car car : inventory)
        {
            for (String type : car.getTypes())
                types.add(type);
        }
        updateLabels();

        //add a listener to the search text field
        searchTextField.textProperty().addListener((obs, oldValue, newValue)->{
            filter();
        });

        //add the types to the filter list
        typeOfCarListView.getItems().addAll(types);


        //attach a listener to the type list view so that it will filter the list of
        //cars
        typeOfCarListView.getSelectionModel().selectedItemProperty().addListener((obs, oldValue, typeSelected)->{

            //loop over the inventory to check if the car is the correct type
            //if it is, add it to the list
//            for (Car car : inventory)
//            {
//                if (car.isType(typeSelected))
//                    carListView.getItems().add(car);
//            }

            filter();
        });
    }

    private void filter()
    {
        carListView.getItems().clear();

        String typeSelected = typeOfCarListView.getSelectionModel().getSelectedItem();

        if (typeSelected == null)
            carListView.getItems().addAll(inventory.stream()
                    .filter(car -> car.contains(searchTextField.getText()))
                    .sorted()
                    .toList());
        else
            //performing the filter using a stream
            carListView.getItems().addAll(inventory.stream()
                    .filter(car -> car.isType(typeSelected))
                    .filter(car -> car.contains(searchTextField.getText()))
                    .sorted()
                    .toList());

        updateLabels();
    }

    private void updateLabels()
    {
        numOfVehiclesLabel.setText("# of vehicles: " +carListView.getItems().size());
        vehicleValueLabel.setText(String.format("Value of Inventory $%.0f", carListView.getItems().stream()
                                                                .mapToDouble(car -> car.getPrice())
                                                                .sum()));
    }
}

