package com.example.superbarhatapp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MainMenuController {
    @FXML
    private Button hisBtn;

    @FXML
    private Button setOrder;

    public void goTohistory() throws IOException {
        Parent wLogin = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("logHistory.fxml")));
        Stage window = (Stage) hisBtn.getScene().getWindow();
        window.setScene(new Scene(wLogin, 700, 500));
        window.show();
    }

    @FXML
    void initialize() {
       setOrder.setOnAction(event ->{
           setOrder.getScene().getWindow().hide();
           FXMLLoader loader = new FXMLLoader();
           loader.setLocation(getClass().getResource("shtrihCode.fxml"));
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

       });
    }


}
