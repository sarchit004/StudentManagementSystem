package com.example.grpassignment_partb;

import com.opencsv.CSVReader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.scene.control.Alert.AlertType;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;


import static com.example.grpassignment_partb.Uses.*;

public class AssignGrades implements Initializable {
    @FXML
    private TextField studentEmailBox;
    @FXML
    private TextField courseIdBox;
    @FXML
    private TextField courseTitleBox;
    @FXML
    private ComboBox<String> assignGrade;
    @FXML
    private TextArea commentsBox;

    @FXML
    private TableView<StudentGradeDataModel> tableView;
    @FXML
    private TableColumn<StudentGradeDataModel, String> studentEmailID;
    @FXML
    private TableColumn<StudentGradeDataModel, String> courseID;
    @FXML
    private TableColumn<StudentGradeDataModel, String> courseTitle;
    @FXML
    private TableColumn<StudentGradeDataModel, String> studentGrade;
    @FXML
    private TableColumn<StudentGradeDataModel, String> comment;

    private ObservableList<StudentGradeDataModel> data;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        data = FXCollections.observableArrayList();
        studentEmailID.setCellValueFactory(cellData -> cellData.getValue().studentEmailIDProperty());
        courseID.setCellValueFactory(cellData -> cellData.getValue().studentCourseIDProperty());
        courseTitle.setCellValueFactory(cellData -> cellData.getValue().studentCourseTitleProperty());
        studentGrade.setCellValueFactory(cellData -> cellData.getValue().studentGradeProperty());
        comment.setCellValueFactory(cellData -> cellData.getValue().studentCommentProperty());

        tableView.setItems(data);
        loadCSVData("studentsGrade.csv");

        assignGrade.setItems(FXCollections.observableArrayList("A", "A-", "B", "B-", "C", "C-", "NG"));
    }

    private void loadCSVData(String filePath) {
        try (CSVReader csvReader = new CSVReader(new FileReader(filePath))) {
            List<String[]> csvData = csvReader.readAll();
            boolean headerSkipped = false;
            for (String[] row : csvData) {
                if (!headerSkipped) {
                    headerSkipped = true;
                    continue;  // Skip the header row
                }
                data.add(new StudentGradeDataModel(row[0], row[1], row[2], row[3], row[4]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void clickSubmit(ActionEvent event) throws IOException {
        String studentEmail = studentEmailBox.getText();
        String courseId = courseIdBox.getText();
        String courseTitle = courseTitleBox.getText();
        String grade = assignGrade.getValue();
        String comments = commentsBox.getText();

        if (studentEmail.isEmpty() || courseId.isEmpty() || courseTitle.isEmpty() || grade.isEmpty() || comments.isEmpty()){
            showAlert(AlertType.WARNING, "Error", "All fields are required");
        }

        if (studentEmail != null && !studentEmail.isEmpty()) {
            if (EmailExistsOrNot(studentEmail)) {
                String[] headers = {"StudentEmail", "CourseID", "CourseTitle", "CourseID", "Grade", "Comments"};
                String[] values = {studentEmail, courseId, courseTitle,grade, comments};

                try{
                    saveDatatoCSV("studentsGrade.csv", headers, values);
                    showAlert(AlertType.INFORMATION, "Successful", "Grade assigned successfully!");
                } catch (IOException e){
                    e.printStackTrace();
                }
            } else {
                showAlert(AlertType.ERROR, "Error", "Student with this email doesn't exist!!");
            }
        } else {
            showAlert(AlertType.WARNING, "Warning", "Email Field is required!!");
        }
    }

    @FXML
    public void clickLogout(ActionEvent event) throws IOException {
        changeScene(event, "login.fxml", "STUDENT MANAGEMENT SYSTEM");
    }

    @FXML
    public void clickDashboard(ActionEvent event) throws IOException {
        changeScene(event, "teacherDashboard.fxml", "STUDENT MANAGEMENT SYSTEM");
    }
    @FXML
    public void clickECAformResponse(ActionEvent event) throws IOException {
        changeScene(event, "teacherECAResponses.fxml", "STUDENT MANAGEMENT SYSTEM");
    }
    @FXML
    public void clickViewIssues(ActionEvent event) throws IOException {
        changeScene(event, "viewIssues.fxml", "STUDENT MANAGEMENT SYSTEM");
    }


    public boolean EmailExistsOrNot(String email) {
        String csvFilePath = "studentsData.csv";
        String line;
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            br.readLine(); // Skip the header

            while ((line = br.readLine()) != null) {
                String[] userDetails = line.split(csvSplitBy);
                String savedEmail = userDetails[4]; // Assuming email is in the 5th column

                if (savedEmail.equals(email)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }
}