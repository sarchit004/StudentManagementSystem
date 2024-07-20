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
    private TableColumn<StaffDataModel, String> column1;
    @FXML
    private TableColumn<StaffDataModel, String> column2;
    @FXML
    private TableColumn<StaffDataModel, String> column3;
    @FXML
    private TableColumn<StaffDataModel, String> column4;

    private ObservableList<StaffDataModel> data;

    @FXML
    public void initialize() {
        data = FXCollections.observableArrayList();
        column1.setCellValueFactory(cellData -> cellData.getValue().column1Property());
        column2.setCellValueFactory(cellData -> cellData.getValue().column2Property());
        column3.setCellValueFactory(cellData -> cellData.getValue().column3Property());
        column4.setCellValueFactory(cellData -> cellData.getValue().column4Property());

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
                data.add(new StaffDataModel(row[0], row[1], row[2], row[3]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void handleLoadCSVButtonAction() {
        loadCSVData("staffData.csv");
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
