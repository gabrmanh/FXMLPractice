module com.example.fxmlpractice {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.fxmlpractice to javafx.fxml;
    exports com.example.fxmlpractice;
}