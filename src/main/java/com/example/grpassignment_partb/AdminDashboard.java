package com.example.grpassignment_partb;

import com.opencsv.CSVReader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static com.example.grpassignment_partb.Uses.changeScene;
import static com.example.grpassignment_partb.Uses.countCSVrows;

public class AdminDashboard {
    @FXML
    private TableView<AdminDataModel> tableView;
    @FXML
    private TableColumn<AdminDataModel, String> fullName;
    @FXML
    private TableColumn<AdminDataModel, String> gender;
    @FXML
    private TableColumn<AdminDataModel, String> phoneNumber;
    @FXML
    private TableColumn<AdminDataModel, String> email;
    @FXML
    private TableColumn<AdminDataModel, String> password;

    private ObservableList<AdminDataModel> data;

    @FXML
    private Label adminCount;
    @FXML
    private Label studentCount;
    @FXML
    private Label teacherCount;
    @FXML
    private Label staffCount;

    @FXML
    public void initialize() {
        data = FXCollections.observableArrayList();
        fullName.setCellValueFactory(cellData -> cellData.getValue().adminFullNameProperty());
        gender.setCellValueFactory(cellData -> cellData.getValue().adminGenderProperty());
        phoneNumber.setCellValueFactory(cellData -> cellData.getValue().adminPhoneNumberProperty());
        email.setCellValueFactory(cellData -> cellData.getValue().adminEmailProperty());
        password.setCellValueFactory(cellData -> cellData.getValue().adminPasswordProperty());

        tableView.setItems(data);
        loadCSVData("adminData.csv");

        int totalAdmins = countCSVrows("adminData.csv");
        int totalStaffs = countCSVrows("staffData.csv");
        int totalStudents = countCSVrows("studentsData.csv");
        int totalTeacher = countCSVrows("teachersData.csv");

        adminCount.setText(""+ totalAdmins);
        staffCount.setText(""+ totalStaffs);
        studentCount.setText(""+ totalStudents);
        teacherCount.setText(""+ totalTeacher);
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
                data.add(new AdminDataModel(row[0], row[1], row[2], row[3], row[4]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void clickLogout(ActionEvent event) throws IOException {
        changeScene(event, "login.fxml", "STUDENT MANAGEMENT SYSTEM");
    }
    @FXML
    public void clickAddAdmin(ActionEvent event) throws IOException {
        changeScene(event, "addAdmin.fxml", "STUDENT MANAGEMENT SYSTEM");
    }
    @FXML
    public void clickManageStaffs(ActionEvent event) throws IOException {
        changeScene(event, "manageStaffs.fxml", "STUDENT MANAGEMENT SYSTEM");
    }
    @FXML
    public void clickManageTeachers(ActionEvent event) throws IOException {
        changeScene(event, "manageTeachers.fxml", "STUDENT MANAGEMENT SYSTEM");
    }
    @FXML
    public void clickGenerateReport(ActionEvent event) throws IOException {
        changeScene(event, "generateReport.fxml", "STUDENT MANAGEMENT SYSTEM");
    }
}
