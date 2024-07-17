package com.example.studentmanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

import static com.example.studentmanagementsystem.Uses.changeScene;

public class AdmissionOfficerDashboard {
    @FXML
    public void clickLogout(ActionEvent event) throws IOException {
        changeScene(event, "login.fxml", "STUDENT MANAGEMENT SYSTEM");
    }
    @FXML
    public void clickManageStudents(ActionEvent event) throws IOException {
        changeScene(event, "manageStudents.fxml", "STUDENT MANAGEMENT SYSTEM");
    }

}
