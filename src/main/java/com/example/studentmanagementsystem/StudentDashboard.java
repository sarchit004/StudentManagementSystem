package com.example.studentmanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

import static com.example.studentmanagementsystem.Uses.changeScene;

public class StudentDashboard {
    @FXML
    public void clickLogout(ActionEvent event) throws IOException {
        changeScene(event, "login.fxml", "STUDENT MANAGEMENT SYSTEM");
    }
    @FXML
    public void clickViewGrades(ActionEvent event) throws IOException {
        changeScene(event, "viewGrades.fxml", "STUDENT MANAGEMENT SYSTEM");

    }
    @FXML
    public void clickStudentIssueForm(ActionEvent event) throws IOException {
        changeScene(event, "studentIssueForm.fxml", "STUDENT MANAGEMENT SYSTEM");
    }

    @FXML
    public void clickUpdateStudent(ActionEvent event) throws IOException {
        changeScene(event, "updateStudent.fxml", "STUDENT MANAGEMENT SYSTEM");
    }
    @FXML
    public void clickIssueFormResponse(ActionEvent event) throws IOException {
        changeScene(event, "issueFormResponse.fxml", "STUDENT MANAGEMENT SYSTEM");
    }
    @FXML
    public void clickMcqQuiz(ActionEvent event) throws IOException {
        changeScene(event, "mcqQuiz.fxml", "STUDENT MANAGEMENT SYSTEM");
    }
    @FXML
    public void clickEcaForm(ActionEvent event) throws IOException {
        changeScene(event, "ecaForm.fxml", "STUDENT MANAGEMENT SYSTEM");
    }
    @FXML
    public void clickFeedback(ActionEvent event) throws IOException {
        changeScene(event, "feedbackForm.fxml", "STUDENT MANAGEMENT SYSTEM");
    }
}

