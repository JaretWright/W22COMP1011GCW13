module com.example.w22comp1011w13 {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;

    opens com.example.w22comp1011w13 to javafx.fxml, com.google.gson;
    exports com.example.w22comp1011w13;
}