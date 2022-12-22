package com.example.superbarhatapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LogHistoryController {

    ConnectDB connect = new ConnectDB();

    private ObservableList<User> userData = FXCollections.observableArrayList();
    @FXML
    private TableView<User> tableUsers;
    @FXML
    private TableColumn<User, String > postColumn;
    @FXML
    private TableColumn<User, String> fioColumn;
    @FXML
    private TableColumn<User, String> passwordColumn;
    @FXML
    private TableColumn<User, String> loginColumn;
    @FXML
    private TableColumn<User, String> lastLogColumn;
    @FXML
    private TableColumn<User, String > typeLogColumn;
    @FXML
    private void initialize() throws SQLException {
        initData();
        postColumn.setCellValueFactory(new PropertyValueFactory<>("post"));
        fioColumn.setCellValueFactory(new PropertyValueFactory<>("fio"));
        passwordColumn.setCellValueFactory(new PropertyValueFactory<>("password"));
        loginColumn.setCellValueFactory(new PropertyValueFactory<>("login"));
        lastLogColumn.setCellValueFactory(new PropertyValueFactory<>("last_log"));
        typeLogColumn.setCellValueFactory(new PropertyValueFactory<>("typeLog"));
        tableUsers.setItems(userData);
    }


    private void initData() throws SQLException {
        ResultSet result = connect.getTableWorkers();
        while (result.next()){
            userData.add(new User(result.getString(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5),result.getString(6)));


        }

    }
}
