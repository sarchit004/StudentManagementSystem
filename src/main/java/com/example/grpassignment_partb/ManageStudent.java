package com.example.grpassignment_partb;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

import static com.example.grpassignment_partb.Uses.changeScene;

public class ManageStudent {
    @FXML
    public void clickLogout(ActionEvent event) throws IOException {
        changeScene(event, "login.fxml", "STUDENT MANAGEMENT SYSTEM");
    }
    @FXML
    public void clickDashboard(ActionEvent event) throws IOException {
        changeScene(event, "admissionOfficerDashboard.fxml", "STUDENT MANAGEMENT SYSTEM");
    }
    @FXML
    public void clickAddStudents(ActionEvent event) throws IOException {
        changeScene(event, "addStudents.fxml", "STUDENT MANAGEMENT SYSTEM");
    }
}
