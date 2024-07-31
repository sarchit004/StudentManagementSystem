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

public class AddTeachers implements Initializable {
    @FXML
    private TextField firstNameBox;
    @FXML
    private TextField lastNameBox;
    @FXML
    private ComboBox<String> selectFaculty;
    @FXML
    private TextField phoneNumberBox;
    @FXML
    private ToggleGroup genderRadioBtns;
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
        selectFaculty.setItems(FXCollections.observableArrayList("BCS", "BBA", "BCA", "BIHM", "BBS"));
    }

    @FXML
    public void clickAdd(ActionEvent event) throws IOException {
        String firstName = firstNameBox.getText();
        String lastName = lastNameBox.getText();
        String faculty = selectFaculty.getValue();
        String phoneNumber = phoneNumberBox.getText();
        String gender = selectedRadioBtn(maleBtn, femaleBtn, otherBtn);
        String email = emailBox.getText();
        String password = passwordBox.getText();
        String confirmPassword = confirmPasswordBox.getText();

        errorLabelVisibility(messageLabel, false);

        String fullName = firstName + " " + lastName;

        String encryptedPassword;

        if (firstNameBox.getText().isEmpty() || lastNameBox.getText().isEmpty() || selectFaculty.getValue() == null || phoneNumberBox.getText().isEmpty() || gender == null || emailBox.getText().isEmpty() || passwordBox.getText().isEmpty() || confirmPasswordBox.getText().isEmpty()) {
            error(messageLabel, "All above fields are required!!");
        } else if (!password.equals(confirmPassword)) {
            error(messageLabel, "Passwords don't match!!");
        } else if (!isEmailUnique(email, "teachersData.csv", 4)) {
            error(messageLabel, "Email already exists!!");
        } else if (password.length() < 6) {
            error(messageLabel, "Password must contain atleast 6 characters!!");
        } else {
            encryptedPassword = encryptPassword(password);
            String[] headers = {"FullName", "Faculty", "PhoneNumber", "Gender", "Email", "Password"};
            String[] values = {fullName, faculty, phoneNumber,gender, email, encryptedPassword};

            try{
                saveDatatoCSV("teachersData.csv", headers, values);
                success(messageLabel, "Added Succesfully!!");
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void clickCancel(ActionEvent event) throws IOException {
        changeScene(event, "manageTeachers.fxml", "STUDENT MANAGEMENT SYSTEM");
    }
}
