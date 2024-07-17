package com.example.studentmanagementsystem;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.example.studentmanagementsystem.Uses.changeScene;

public class LoginController implements Initializable {
    @FXML
    private TextField email;
    @FXML
    private PasswordField password;
    @FXML
    private ComboBox<String> role;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        role.setItems(FXCollections.observableArrayList("Admin", "Student", "AdmissionOfficer", "Librarian", "Teacher"));
    }

    public void clickLogin(ActionEvent event) throws IOException {
        if (role.getValue() == "Admin"){
            changeScene(event, "adminDashboard.fxml", "STUDENT MANAGEMENT SYSTEM");
        } else if (role.getValue() == "Student") {
            changeScene(event, "studentDashboard.fxml", "STUDENT MANAGEMENT SYSTEM");
        } else if (role.getValue() == "AdmissionOfficer") {
            changeScene(event, "admissionOfficerDashboard.fxml", "STUDENT MANAGEMENT SYSTEM");
        } else if (role.getValue() == "Librarian") {

        } else if (role.getValue() == "Teacher") {
            changeScene(event, "teacherDashboard.fxml", "STUDENT MANAGEMENT SYSTEM");
        }

    }
}