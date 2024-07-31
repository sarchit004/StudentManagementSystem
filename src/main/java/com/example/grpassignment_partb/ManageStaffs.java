package com.example.grpassignment_partb;

import com.opencsv.CSVReader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static com.example.grpassignment_partb.Uses.changeScene;

public class ManageStaffs {
    @FXML
    private TableView<StaffDataModel> tableView;
    @FXML
    private TableColumn<StaffDataModel, String> fullName;
    @FXML
    private TableColumn<StaffDataModel, String> department;
    @FXML
    private TableColumn<StaffDataModel, String> role;
    @FXML
    private TableColumn<StaffDataModel, String> phoneNumber;
    @FXML
    private TableColumn<StaffDataModel, String> gender;
    @FXML
    private TableColumn<StaffDataModel, String> email;
    @FXML
    private TableColumn<StaffDataModel, String> password;

    private ObservableList<StaffDataModel> data;
    @FXML
    public void initialize() {
        data = FXCollections.observableArrayList();
        fullName.setCellValueFactory(cellData -> cellData.getValue().staffFullNameProperty());
        department.setCellValueFactory(cellData -> cellData.getValue().staffDepartmentProperty());
        role.setCellValueFactory(cellData -> cellData.getValue().staffRoleProperty());
        phoneNumber.setCellValueFactory(cellData -> cellData.getValue().staffPhoneNumberProperty());
        gender.setCellValueFactory(cellData -> cellData.getValue().staffGenderProperty());
        email.setCellValueFactory(cellData -> cellData.getValue().staffEmailProperty());
        password.setCellValueFactory(cellData -> cellData.getValue().staffPasswordProperty());

        tableView.setItems(data);
        loadCSVData("staffData.csv");
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
                data.add(new StaffDataModel(row[0], row[1], row[2], row[3], row[4], row[5], row[6]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void clickAddStaffs(ActionEvent event) throws IOException {
        changeScene(event, "addStaffs.fxml", "STUDENT MANAGEMENT SYSTEM");
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
    public void clickManageTeachers(ActionEvent event) throws IOException {
        changeScene(event, "manageTeachers.fxml", "STUDENT MANAGEMENT SYSTEM");
    }
    @FXML
    public void clickGenerateReport(ActionEvent event) throws IOException {
        changeScene(event, "generateReport.fxml", "STUDENT MANAGEMENT SYSTEM");
    }
}
