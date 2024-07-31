package com.example.grpassignment_partb;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import static com.example.grpassignment_partb.Uses.*;

public class LoginController implements Initializable {
    @FXML
    private TextField emailBox;
    @FXML
    private PasswordField passwordBox;
    @FXML
    private ComboBox<String> roleBox;
    @FXML
    private Label overallError;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        roleBox.setItems(FXCollections.observableArrayList("Admin", "Student", "AdmissionOfficer", "Librarian", "Teacher"));
    }

    public void clickLogin(ActionEvent event) throws IOException {
        String email = emailBox.getText();
        String password = passwordBox.getText();
        String role = roleBox.getValue();

        errorLabelVisibility(overallError, false);

        if (validateCredentials(email, password, role, "studentsData.csv")) {
            SessionManager.getInstance().setStudentEmail(email);
            changeScene(event, "studentDashboard.fxml", "STUDENT MANAGEMENT SYSTEM");
        }
        else  if(validateCredentials(email, password, role, "teachersData.csv"))
        {
            changeScene(event, "teacherDashboard.fxml", "STUDENT MANAGEMENT SYSTEM");
        }
        else  if(validateCredentials(email, password, role, "adminData.csv"))
        {
            changeScene(event, "adminDashboard.fxml", "STUDENT MANAGEMENT SYSTEM");
        }
        else  if(validateCredentials(email, password, role, "staffData.csv"))
        {
            if (role.equals("AdmissionOfficer")){
                changeScene(event, "admissionOfficerDashboard.fxml", "STUDENT MANAGEMENT SYSTEM");
            } else if (role.equals("Librarian")){
                changeScene(event, "librarianDashboard.fxml", "STUDENT MANAGEMENT SYSTEM");
            }
        }
        else {
            error(overallError, "Invalid Login Credentials");
        }

//        if (roleBox.getValue() == null){
//            error(overallError, "All Fields are required!!");
//        }
//        if (roleBox.getValue() == "Admin"){
//            changeScene(event, "adminDashboard.fxml", "STUDENT MANAGEMENT SYSTEM");
//        } else if (roleBox.getValue() == "Student") {
//            changeScene(event, "studentDashboard.fxml", "STUDENT MANAGEMENT SYSTEM");
//        } else if (roleBox.getValue() == "AdmissionOfficer") {
//            changeScene(event, "admissionOfficerDashboard.fxml", "STUDENT MANAGEMENT SYSTEM");
//        } else if (roleBox.getValue() == "Librarian") {
//            changeScene(event, "librarianDashboard.fxml", "STUDENT MANAGEMENT SYSTEM");
//        } else if (roleBox.getValue() == "Teacher") {
//            changeScene(event, "teacherDashboard.fxml", "STUDENT MANAGEMENT SYSTEM");
//        }
//
//
//        if (email.isEmpty() || password.isEmpty() || role == null) {
//            error(overallError, "All Fields are required!!");
//            return;
//        }
    }
}