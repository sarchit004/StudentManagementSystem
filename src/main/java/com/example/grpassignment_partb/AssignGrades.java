package com.example.grpassignment_partb;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.example.grpassignment_partb.Uses.changeScene;
import static com.example.grpassignment_partb.Uses.saveDatatoCSV;

public class AssignGrades implements Initializable {
    @FXML
    private TextField studentIdBox;
    @FXML
    private TextField courseTitleBox;
    @FXML
    private TextField courseIdBox;
    @FXML
    private ComboBox<String> assignGrade;
    @FXML
    private TextArea commentsBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        assignGrade.setItems(FXCollections.observableArrayList("A", "A-", "B", "B-", "C", "C-", "NG"));
    }

    @FXML
    public void clickSubmit(ActionEvent event) throws IOException {
        String studentId = studentIdBox.getText();
        String courseTitle = courseTitleBox.getText();
        String courseId = courseIdBox.getText();
        String grade = assignGrade.getValue();
        String comments = commentsBox.getText();

        String[] values = {studentId,courseId, courseTitle, grade, comments};
        saveDatatoCSV("studentGradesData.csv", values);
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
