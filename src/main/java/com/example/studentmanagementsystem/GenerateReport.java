package com.example.studentmanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

import static com.example.studentmanagementsystem.Uses.changeScene;

public class GenerateReport {
    @FXML
    public void clickLogout(ActionEvent event) throws IOException {
        changeScene(event, "login.fxml", "STUDENT MANAGEMENT SYSTEM");
    }
    @FXML
    public void clickDashboard(ActionEvent event) throws IOException {
        changeScene(event, "adminDashboard.fxml", "STUDENT MANAGEMENT SYSTEM");
    }
    @FXML
    public void clickManageStaffs(ActionEvent event) throws IOException {
        changeScene(event, "manageStaffs.fxml", "STUDENT MANAGEMENT SYSTEM");
    }
    @FXML
    public void clickManageTeachers(ActionEvent event) throws IOException {
        changeScene(event, "manageTeachers.fxml", "STUDENT MANAGEMENT SYSTEM");
    }
}
