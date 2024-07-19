package com.example.grpassignment_partb;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

import static com.example.grpassignment_partb.Uses.changeScene;

public class TeacherDashboard {
    @FXML
    public void clickLogout(ActionEvent event) throws IOException {
        changeScene(event, "login.fxml", "STUDENT MANAGEMENT SYSTEM");
    }
    @FXML
    public void clickAssignGrades(ActionEvent event) throws IOException {
        changeScene(event, "AssignGrades.fxml", "STUDENT MANAGEMENT SYSTEM");
    }
    @FXML
    public void clickECAformResponse(ActionEvent event) throws IOException {
        changeScene(event, "ecaFormResponse.fxml", "STUDENT MANAGEMENT SYSTEM");
    }
    @FXML
    public void clickReplyIssues(ActionEvent event) throws IOException {
        changeScene(event, "replyIssues.fxml", "STUDENT MANAGEMENT SYSTEM");
    }
}
