package com.example.studentmanagementsystem;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.example.studentmanagementsystem.Uses.changeScene;

public class AssignGrades implements Initializable {
    @FXML
    private ComboBox<String> assignGrade;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        assignGrade.setItems(FXCollections.observableArrayList("A", "A-", "B", "B-", "C", "C-", "NG"));
    }

    @FXML
    public void clickDashboard(ActionEvent event) throws IOException {
        changeScene(event, "teacherDashboard.fxml", "STUDENT MANAGEMENT SYSTEM");
    }
    @FXML
    public void clickECAformResponse(ActionEvent event) throws IOException {
        changeScene(event, "teacherDashboard.fxml", "STUDENT MANAGEMENT SYSTEM");
    }
    @FXML
    public void clickReplyIssues(ActionEvent event) throws IOException {
        changeScene(event, "teacherDashboard.fxml", "STUDENT MANAGEMENT SYSTEM");
    }
}
