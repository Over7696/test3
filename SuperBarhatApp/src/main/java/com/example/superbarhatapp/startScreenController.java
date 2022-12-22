package com.example.superbarhatapp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class startScreenController {
    @FXML
    private Button logBtn;

    @FXML
    private TextField logField;

    @FXML
    private PasswordField passField;

    public startScreenController() {
    }

    @FXML
    void initialize() {
        logBtn.setOnAction(event ->{
            String loginText = logField.getText().trim();
            String loginPassword = passField.getText().trim();

            //Проверка на пустоту полей
            if (!loginText.equals("") && !loginPassword.equals("")) {
                try {
                    loginUser(loginText, loginPassword);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }



    public void loginUser(String loginText, String loginPassword) throws SQLException{
        ConnectDB dbHandler = new ConnectDB();
        ResultSet result = dbHandler.getUser(loginText,loginPassword);

        int counter = 0;
        while (true) {
            try {
                if (!result.next())
                    break;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            counter++;
            dbHandler.updateTime(loginText);
        }
        if (counter >= 1) {

            logBtn.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("mainMenu.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.showAndWait();
        }

    }
}