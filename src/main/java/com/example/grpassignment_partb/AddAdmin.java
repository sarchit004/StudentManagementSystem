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
    @FXML
    private Label messageLabel;

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

        errorLabelVisibility(messageLabel, false);

        String fullName = firstName + " "+ lastName;
        String encryptedPassword;

        if (firstNameBox.getText().isEmpty() || lastNameBox.getText().isEmpty() || genderBox.getValue() == null || phoneNumberBox.getText().isEmpty() || emailBox.getText().isEmpty() || passwordBox.getText().isEmpty() || confirmPasswordBox.getText().isEmpty()) {
            error(messageLabel, "All above fields are required!!");
        } else if (!password.equals(confirmPassword)) {
            error(messageLabel, "Passwords don't match!!");
        } else if (!isEmailUnique(email, "adminData.csv", 3)) {
            error(messageLabel, "Email already exists!!");
        } else if (password.length() < 6) {
            error(messageLabel, "Password must contain atleast 6 characters!!");
        } else {
            encryptedPassword = encryptPassword(password);

            String[] headers = {"FullName", "Gender", "PhoneNumber", "Email", "Password"};
            String[] values = {fullName, gender, phoneNumber, email, encryptedPassword};

            try {
                saveDatatoCSV("adminData.csv", headers, values);
                success(messageLabel, "Added Successfully!!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @FXML
    public void clickCancel(ActionEvent event) throws IOException {
        changeScene(event, "adminDashboard.fxml", "STUDENT MANAGEMENT SYSTEM");
    }
}
