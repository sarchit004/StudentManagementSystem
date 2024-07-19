package com.example.grpassignment_partb;

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

import static com.example.grpassignment_partb.Uses.changeScene;
import static com.example.grpassignment_partb.Uses.saveDatatoCSV;

public class AddAdmin implements Initializable {
    @FXML
    private TextField firstNameBox;
    @FXML
    private TextField lastNameBox;
    @FXML
    private ComboBox<String> genderBox;
    @FXML
    private TextField phoneNumberBox;
    @FXML
    private TextField emailBox;
    @FXML
    private PasswordField passwordBox;
    @FXML
    private PasswordField confirmPasswordBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        genderBox.setItems(FXCollections.observableArrayList("Male", "Female", "Others"));
    }

    @FXML
    public void clickAdd(ActionEvent event) throws IOException {
        String firstName = firstNameBox.getText();
        String lastName = lastNameBox.getText();
        String gender = genderBox.getValue();
        String phoneNumber = phoneNumberBox.getText();
        String email = emailBox.getText();
        String password = passwordBox.getText();
        String confirmPassword = confirmPasswordBox.getText();

        String fullName = firstName + " "+ lastName;

        String[] values = {fullName, gender, phoneNumber, email, password, confirmPassword};
        saveDatatoCSV("adminData.csv", values);
    }
    @FXML
    public void clickCancel(ActionEvent event) throws IOException {
        changeScene(event, "adminDashboard.fxml", "STUDENT MANAGEMENT SYSTEM");
    }
}
