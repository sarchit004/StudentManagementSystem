package com.example.studentmanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

import static com.example.studentmanagementsystem.Uses.changeScene;

public class ManageStaffs {
    @FXML
    public void clickAddStaffs(ActionEvent event) throws IOException {
        changeScene(event, "addStaffs.fxml", "STUDENT MANAGEMENT SYSTEM");
    }
    @FXML
    public void clickLogout(ActionEvent event) throws IOException {
        changeScene(event, "login.fxml", "STUDENT MANAGEMENT SYSTEM");
    }
    @FXML
    public void clickDashboard(ActionEvent event) throws IOException {
        changeScene(event, "adminDashboard.fxml", "STUDENT MANAGEMENT SYSTEM");
    }
    @FXML
    public void clickManageTeachers(ActionEvent event) throws IOException {
        changeScene(event, "manageTeachers.fxml", "STUDENT MANAGEMENT SYSTEM");
    }
    @FXML
    public void clickGenerateReport(ActionEvent event) throws IOException {
        changeScene(event, "generateReport.fxml", "STUDENT MANAGEMENT SYSTEM");
    }
}
