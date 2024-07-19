package com.example.grpassignment_partb;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.example.grpassignment_partb.Uses.*;

public class LoginController implements Initializable {
    @FXML
    private TextField email;
    @FXML
    private PasswordField password;
    @FXML
    private ComboBox<String> role;
    @FXML
    private Label overallError;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        role.setItems(FXCollections.observableArrayList("Admin", "Student", "AdmissionOfficer", "Librarian", "Teacher"));
    }

    public void clickLogin(ActionEvent event) throws IOException {
        errorLabelVisibility(overallError, false);
        if (role.getValue() == null){
            error(overallError, "All Fields are required!!");
        }
        if (role.getValue() == "Admin"){
            changeScene(event, "adminDashboard.fxml", "STUDENT MANAGEMENT SYSTEM");
        } else if (role.getValue() == "Student") {
            changeScene(event, "studentDashboard.fxml", "STUDENT MANAGEMENT SYSTEM");
        } else if (role.getValue() == "AdmissionOfficer") {
            changeScene(event, "admissionOfficerDashboard.fxml", "STUDENT MANAGEMENT SYSTEM");
        } else if (role.getValue() == "Librarian") {
            changeScene(event, "librarianDashboard.fxml", "STUDENT MANAGEMENT SYSTEM");
        } else if (role.getValue() == "Teacher") {
            changeScene(event, "teacherDashboard.fxml", "STUDENT MANAGEMENT SYSTEM");
        }

    }
}