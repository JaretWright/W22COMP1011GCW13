module com.example.w22comp1011w13 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.w22comp1011w13 to javafx.fxml;
    exports com.example.w22comp1011w13;
}