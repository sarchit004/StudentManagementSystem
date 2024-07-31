package com.example.grpassignment_partb;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.example.grpassignment_partb.Uses.changeScene;

public class EcaOtherActivitiesForm implements Initializable {
    @FXML
    private ComboBox<String> facultyBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        facultyBox.setItems(FXCollections.observableArrayList("BCS", "BBS", "BIHM", "BCA"));
    }
    @FXML
    public void clickLogout(ActionEvent event) throws IOException {
        changeScene(event, "login.fxml", "STUDENT MANAGEMENT SYSTEM");
    }
    @FXML
    public void clickBack(ActionEvent event) throws IOException {
        changeScene(event, "studentDashboard.fxml", "STUDENT MANAGEMENT SYSTEM");
    }
    @FXML
    private void clickSports(ActionEvent event) throws IOException {
        changeScene(event, "ecaForm.fxml", "STUDENT MANAGEMENT SYSTEM");
    }
}
