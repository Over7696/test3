module com.example.superbarhatapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;
    requires java.desktop;


    opens com.example.superbarhatapp to javafx.fxml;
    exports com.example.superbarhatapp;
}