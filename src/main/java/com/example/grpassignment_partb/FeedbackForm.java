package com.example.grpassignment_partb;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;

import static com.example.grpassignment_partb.Uses.*;
import static com.example.grpassignment_partb.Uses.success;

public class FeedbackForm {
    @FXML
    private TextField emailIDBox;
    @FXML
    private TextField nameBox;
    @FXML
    private TextField courseBox;
    @FXML
    private TextArea qn1Box;
    @FXML
    private TextArea qn2Box;
    @FXML
    private TextArea additionalCommentsBox;

    @FXML
    public void clickSubmit(ActionEvent event){
        String emailID = emailIDBox.getText();
        String name = nameBox.getText();
        String course = courseBox.getText();
        String qn1 = qn1Box.getText();
        String qn2 = qn2Box.getText();
        String additionalComments = additionalCommentsBox.getText();

        if (emailID.isEmpty() || name.isEmpty() || course.isEmpty() || qn1.isEmpty() || qn2.isEmpty() || additionalComments.isEmpty()){
            showAlert(Alert.AlertType.ERROR, "Error", "All fields are required!");
        } else {
            String[] headers = {"EmailID", "Name", "Course", "QN1", "QN2", "Comments"};
            String[] values = {emailID, name, course, qn1, qn2, additionalComments};

            try {
                saveDatatoCSV("feedbackData.csv", headers, values);
                showAlert(Alert.AlertType.INFORMATION, "Success", "Your feedback has been posted!");
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
    public void clickStudentIssueForm(ActionEvent event) throws IOException {
        changeScene(event, "studentIssueForm.fxml", "STUDENT MANAGEMENT SYSTEM");
    }

    @FXML
    public void clickUpdateStudent(ActionEvent event) throws IOException {
        changeScene(event, "updateStudent.fxml", "STUDENT MANAGEMENT SYSTEM");
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
    public void clickViewGrades(ActionEvent event) throws IOException {
        changeScene(event, "viewGrades.fxml", "STUDENT MANAGEMENT SYSTEM");
    }
}
