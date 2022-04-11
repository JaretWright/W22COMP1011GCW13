package com.example.w22comp1011w13;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class DealerViewController {

    @FXML
    private ListView<Car> carListView;

    @FXML
    private Label dealerNameLabel;

    @FXML
    private TextField searchTextField;

    @FXML
    private ListView<String> typeOfCarListView;

}

