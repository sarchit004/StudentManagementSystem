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

public class EcaForm implements Initializable {
    @FXML
    private TextField studentIdBox;
    @FXML
    private TextField studentFullNameBox;
    @FXML
    private ComboBox<String> facultyBox;
    @FXML
    private RadioButton volleyballBtn;
    @FXML
    private RadioButton basketballBtn;
    @FXML
    private RadioButton badmintonBtn;
    @FXML
    private RadioButton footballBtn;
    @FXML
    private TextField memberCountBox;
    @FXML
    private TextArea memberListBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        facultyBox.setItems(FXCollections.observableArrayList("BCS", "BBS", "BIHM", "BCA"));
    }
    @FXML
    public void clickRegister(ActionEvent event){
        String studentID = studentIdBox.getText();
        String fullName = studentFullNameBox.getText();
        String faculty = facultyBox.getValue();
        String sportSelected = selectedECA(volleyballBtn, basketballBtn, badmintonBtn, footballBtn);
        String memberCount = memberCountBox.getText();
        String memberList = memberListBox.getText();

        if (studentID.isEmpty() || fullName.isEmpty() || facultyBox.getValue().isEmpty() || memberCount.isEmpty() || memberList.isEmpty()){
            showAlert(Alert.AlertType.WARNING, "Error", "All fields are required!");
        } else {
            String[] headers = {"StudentID", "FullName", "Faculty", "SportsSelected", "MemberCount", "MembersList"};
            String[] values = {studentID, fullName, faculty, sportSelected, memberCount, memberList};

            try{
                saveDatatoCSV("sportsParticipation.csv", headers, values);
                showAlert(Alert.AlertType.INFORMATION, "Success!!", "You have successfully registered!");
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    @FXML
    public void clickLogout(ActionEvent event) throws IOException {
        changeScene(event, "login.fxml", "STUDENT MANAGEMENT SYSTEM");
    }
    @FXML
    public void clickBack(ActionEvent event) throws IOException {
        changeScene(event, "studentDashboard.fxml", "STUDENT MANAGEMENT SYSTEM");
    }

    @FXML
    public void clickOtherActivities(ActionEvent event) throws IOException {
        changeScene(event, "ecaOtherActivitesForm.fxml", "STUDENT MANAGEMENT SYSTEM");
    }
}
