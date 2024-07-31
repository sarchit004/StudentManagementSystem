package com.example.grpassignment_partb;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static com.example.grpassignment_partb.Uses.changeScene;
import static com.example.grpassignment_partb.Uses.getStudentGrades;

public class ViewGrades implements Initializable {
    @FXML
    private TableView<GradeDataModel> gradesTable;
    @FXML
    private TableColumn<GradeDataModel, String> courseIDColumn;
    @FXML
    private TableColumn<GradeDataModel, String> courseTitleColumn;
    @FXML
    private TableColumn<GradeDataModel, String> studentGradeColumn;
    @FXML
    private TableColumn<GradeDataModel, String> commentsColumn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        courseIDColumn.setCellValueFactory(new PropertyValueFactory<>("courseId"));
        courseTitleColumn.setCellValueFactory(new PropertyValueFactory<>("courseTitle"));
        studentGradeColumn.setCellValueFactory(new PropertyValueFactory<>("grade"));
        commentsColumn.setCellValueFactory(new PropertyValueFactory<>("comments"));

        // Load grades if student email is available
        String studentEmail = SessionManager.getInstance().getStudentEmail();
        if (studentEmail != null && !studentEmail.isEmpty()) {
            loadGrades(studentEmail);
        }
    }

    private void loadGrades(String studentEmail) {
        List<String[]> grades = getStudentGrades(studentEmail, "studentsGrade.csv");
        ObservableList<GradeDataModel> gradeList = FXCollections.observableArrayList();

        for (String[] grade : grades) {
            gradeList.add(new GradeDataModel(grade[1], grade[2], grade[3], grade[4])); // Skipping the email field
        }

        gradesTable.setItems(gradeList);
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
}
