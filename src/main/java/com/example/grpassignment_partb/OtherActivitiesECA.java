package com.example.grpassignment_partb;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

import static com.example.grpassignment_partb.Uses.changeScene;

public class OtherActivitiesECA {
    @FXML
    public void clickLogout(ActionEvent event) throws IOException {
        changeScene(event, "login.fxml", "STUDENT MANAGEMENT SYSTEM");
    }
    @FXML
    public void clickSports(ActionEvent event) throws IOException {
        changeScene(event, "ecaForm.fxml", "STUDENT MANAGEMENT SYSTEM");
    }
    @FXML
    public void clickBack(ActionEvent event) throws IOException {
        changeScene(event, "studentDashboard.fxml", "STUDENT MANAGEMENT SYSTEM");
    }
}
