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

        String fullName = firstName + " "+ lastName;

        String[] values = {fullName, department, role, phoneNumber,gender, email, password, confirmPassword};
        saveDatatoCSV("staffData.csv", values);

    }


    @FXML
    public void clickCancel(ActionEvent event) throws IOException {
        changeScene(event, "manageStaffs.fxml", "STUDENT MANAGEMENT SYSTEM");
    }

}
