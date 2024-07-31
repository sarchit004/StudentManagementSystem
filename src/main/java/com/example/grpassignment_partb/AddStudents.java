package com.example.grpassignment_partb;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.example.grpassignment_partb.Uses.*;

public class AddStudents implements Initializable {
    @FXML
    private TextField firstNameBox;
    @FXML
    private TextField lastNameBox;
    @FXML
    private ComboBox<String> selectFacultyBox;
    @FXML
    private TextField phoneNumberBox;
    @FXML
    private RadioButton maleBtn;
    @FXML
    private RadioButton femaleBtn;
    @FXML
    private RadioButton otherBtn;
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
        selectFacultyBox.setItems(FXCollections.observableArrayList("BCS", "BBA", "BIHM", "BCA"));
    }

    @FXML
    public void clickAdd(ActionEvent event) throws IOException {
        String firstName = firstNameBox.getText();
        String lastName = lastNameBox.getText();
        String faculty = selectFacultyBox.getValue();
        String phoneNumber = phoneNumberBox.getText();
        String gender = selectedRadioBtn(maleBtn, femaleBtn, otherBtn);
        String email = emailBox.getText();
        String password = passwordBox.getText();
        String confirmPassword = confirmPasswordBox.getText();

        errorLabelVisibility(messageLabel, false);

        String fullName = firstName + " " + lastName;
        String encryptedPassword;

        if (firstNameBox.getText().isEmpty() || lastNameBox.getText().isEmpty() || selectFacultyBox.getValue() == null || phoneNumberBox.getText().isEmpty() || gender == null || emailBox.getText().isEmpty() || passwordBox.getText().isEmpty() || confirmPasswordBox.getText().isEmpty()) {
            error(messageLabel, "All above fields are required!!");
        } else if (!password.equals(confirmPassword)) {
            error(messageLabel, "Passwords don't match!!");
        } else if (!isEmailUnique(email, "studentsData.csv", 4)) { // 4 is the email column index in studentsData.csv
            error(messageLabel, "Email already exists!!");
        } else if (password.length() < 6) {
            error(messageLabel, "Password must contain atleast 6 characters!!");
        } else {
            encryptedPassword = encryptPassword(password);
            String[] headers = {"FullName", "Faculty", "PhoneNumber", "Gender", "Email", "Password"};
            String[] values = {fullName, faculty, phoneNumber, gender, email, encryptedPassword};

            try {
                saveDatatoCSV("studentsData.csv", headers, values);
                success(messageLabel, "Added Successfully!!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @FXML
    public void clickCancel(ActionEvent event) throws IOException {
        changeScene(event, "manageStudents.fxml", "STUDENT MANAGEMENT SYSTEM");
    }
}
