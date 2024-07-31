package com.example.grpassignment_partb;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.io.IOException;

import static com.example.grpassignment_partb.Uses.*;

public class StudentIssueForm {
    @FXML
    private TextField emailIDBox;
    @FXML
    private TextField dateReportedBox;
    @FXML
    private RadioButton academicIssueBtn;
    @FXML
    private RadioButton financialProblemBtn;
    @FXML
    private RadioButton leaveNoteBtn;
    @FXML
    private RadioButton healthRelatedIssueBtn;
    @FXML
    private RadioButton othersBtn;
    @FXML
    private TextArea issueDescriptionBox;

    @FXML
    public void clickSubmit(ActionEvent event) {
        String emailID = emailIDBox.getText();
        String dateReported = dateReportedBox.getText();
        String problemCategory = selectedProblemCategory(academicIssueBtn, financialProblemBtn, leaveNoteBtn, healthRelatedIssueBtn, othersBtn);
        String issueDescription = issueDescriptionBox.getText();

        if (emailID.isEmpty() || dateReportedBox.getText().isEmpty() || issueDescription.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Error", "All fields are required");
        } else {
            String[] headers = {"EmailID", "DateReported", "ProblemCategory", "Description"};
            String[] values = {emailID, dateReported, problemCategory, issueDescription};

            try {
                saveDatatoCSV("issuesData.csv", headers, values);
                showAlert(Alert.AlertType.INFORMATION, "Success", "Issue filed successfully!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @FXML
    public void clickLogout(ActionEvent event) throws IOException {
        changeScene(event, "login.fxml", "STUDENT MANAGEMENT SYSTEM");
    }
    @FXML
    public void clickViewGrades(ActionEvent event) throws IOException {
        changeScene(event, "viewGrades.fxml", "STUDENT MANAGEMENT SYSTEM");

    }
    @FXML
    public void clickDashboard(ActionEvent event) throws IOException {
        changeScene(event, "studentDashboard.fxml", "STUDENT MANAGEMENT SYSTEM");
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
    @FXML
    public void clickClose(ActionEvent event) throws IOException {
        changeScene(event, "studentDashboard.fxml", "STUDENT MANAGEMENT SYSTEM");
    }
}
