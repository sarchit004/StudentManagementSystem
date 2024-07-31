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

public class AddStaffs implements Initializable {
    @FXML
    private TextField firstNameBox;
    @FXML
    private TextField lastNameBox;
    @FXML
    private ComboBox<String> selectDepartmentBox;
    @FXML
    private ComboBox<String> selectRoleBox;
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
        selectDepartmentBox.setItems(FXCollections.observableArrayList("Admission", "Library"));
        selectRoleBox.setItems(FXCollections.observableArrayList("AdmissionOfficer", "Librarian"));
    }

    @FXML
    public void clickAdd(ActionEvent event) throws IOException {
        String firstName = firstNameBox.getText();
        String lastName = lastNameBox.getText();
        String department = selectDepartmentBox.getValue();
        String role = selectRoleBox.getValue();
        String phoneNumber = phoneNumberBox.getText();
        String gender = selectedRadioBtn(maleBtn, femaleBtn, otherBtn);
        String email = emailBox.getText();
        String password = passwordBox.getText();
        String confirmPassword = confirmPasswordBox.getText();

        errorLabelVisibility(messageLabel, false);

        String fullName = firstName + " "+ lastName;

        String encryptedPassword;

        if (firstNameBox.getText().isEmpty() || lastNameBox.getText().isEmpty() || selectDepartmentBox.getValue() == null || selectRoleBox.getValue() == null || phoneNumberBox.getText().isEmpty() || gender == null || emailBox.getText().isEmpty() || passwordBox.getText().isEmpty() || confirmPasswordBox.getText().isEmpty()) {
            error(messageLabel, "All above fields are required!!");
        } else if (!password.equals(confirmPassword)) {
            error(messageLabel, "Passwords don't match!!");
        } else if (!isEmailUnique(email, "staffData.csv", 5)) {
            error(messageLabel, "Email already exists!!");
        } else if (password.length() < 6) {
            error(messageLabel, "Password must contain atleast 6 characters!!");
        } else {
            encryptedPassword = encryptPassword(password);
            String[] headers = {"FullName", "Department", "Role", "PhoneNumber", "Gender", "Email", "Password"};
            String[] values = {fullName, department, role, phoneNumber,gender, email, encryptedPassword};

            try{
                saveDatatoCSV("staffData.csv", headers, values);
                success(messageLabel, "Added Succesfully!!");
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }


    @FXML
    public void clickCancel(ActionEvent event) throws IOException {
        changeScene(event, "manageStaffs.fxml", "STUDENT MANAGEMENT SYSTEM");
    }

}
