package com.example.grpassignment_partb;

import com.opencsv.CSVReader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static com.example.grpassignment_partb.Uses.changeScene;

public class ManageTeachers {

    @FXML
    private TableView<TeacherDataModel> tableView;
    @FXML
    private TableColumn<TeacherDataModel, String> fullName;
    @FXML
    private TableColumn<TeacherDataModel, String> faculty;
    @FXML
    private TableColumn<TeacherDataModel, String> phoneNumber;
    @FXML
    private TableColumn<TeacherDataModel, String> gender;
    @FXML
    private TableColumn<TeacherDataModel, String> email;
    @FXML
    private TableColumn<TeacherDataModel, String> password;

    private ObservableList<TeacherDataModel> data;

    @FXML
    public void initialize() {
        data = FXCollections.observableArrayList();
        fullName.setCellValueFactory(cellData -> cellData.getValue().teacherFullNameProperty());
        faculty.setCellValueFactory(cellData -> cellData.getValue().teacherFacultyProperty());
        phoneNumber.setCellValueFactory(cellData -> cellData.getValue().teacherPhoneNumberProperty());
        gender.setCellValueFactory(cellData -> cellData.getValue().teacherGenderProperty());
        email.setCellValueFactory(cellData -> cellData.getValue().teacherEmailProperty());
        password.setCellValueFactory(cellData -> cellData.getValue().teacherPasswordProperty());

        tableView.setItems(data);
        loadCSVData("teachersData.csv");
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
                data.add(new TeacherDataModel(row[0], row[1], row[2], row[3], row[4], row[5]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @FXML
    public void clickAddTeachers(ActionEvent event) throws IOException {
        changeScene(event, "addTeachers.fxml", "STUDENT MANAGEMENT SYSTEM");
    }
    @FXML
    public void clickLogout(ActionEvent event) throws IOException {
        changeScene(event, "login.fxml", "STUDENT MANAGEMENT SYSTEM");
    }
    @FXML
    public void clickDashboard(ActionEvent event) throws IOException {
        changeScene(event, "adminDashboard.fxml", "STUDENT MANAGEMENT SYSTEM");
    }
    @FXML
    public void clickManageStaffs(ActionEvent event) throws IOException {
        changeScene(event, "manageStaffs.fxml", "STUDENT MANAGEMENT SYSTEM");
    }
    @FXML
    public void clickGenerateReport(ActionEvent event) throws IOException {
        changeScene(event, "generateReport.fxml", "STUDENT MANAGEMENT SYSTEM");
    }
}
