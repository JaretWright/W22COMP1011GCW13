package com.example.w22comp1011w13;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DealerViewController implements Initializable {

    @FXML
    private ListView<Car> carListView;

    @FXML
    private Label dealerNameLabel;

    @FXML
    private TextField searchTextField;

    @FXML
    private ListView<String> typeOfCarListView;

    private ArrayList<Car> inventory;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Dealership dealership = ReadJson.getDealershipFromJson("carData.json");
        dealerNameLabel.setText(dealership.getDealershipName());

        carListView.getItems().addAll(dealership.getInventory());



    }
}

