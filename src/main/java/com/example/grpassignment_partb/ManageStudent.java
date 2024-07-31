package com.example.grpassignment_partb;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static com.example.grpassignment_partb.Uses.changeScene;
import static com.example.grpassignment_partb.Uses.showAlert;

public class ManageStudent {
    @FXML
    private TableView<StudentDataModel> tableView;
    @FXML
    private TableColumn<StudentDataModel, String> fullName;
    @FXML
    private TableColumn<StudentDataModel, String> faculty;
    @FXML
    private TableColumn<StudentDataModel, String> phoneNumber;
    @FXML
    private TableColumn<StudentDataModel, String> gender;
    @FXML
    private TableColumn<StudentDataModel, String> email;
    @FXML
    private TableColumn<StudentDataModel, String> password;

    private ObservableList<StudentDataModel> data;

    @FXML
    public void initialize() {
        data = FXCollections.observableArrayList();
        fullName.setCellValueFactory(cellData -> cellData.getValue().studentFullNameProperty());
        faculty.setCellValueFactory(cellData -> cellData.getValue().studentFacultyProperty());
        phoneNumber.setCellValueFactory(cellData -> cellData.getValue().studentPhoneNumberProperty());
        gender.setCellValueFactory(cellData -> cellData.getValue().studentGenderProperty());
        email.setCellValueFactory(cellData -> cellData.getValue().studentEmailProperty());
        password.setCellValueFactory(cellData -> cellData.getValue().studentPasswordProperty());

        tableView.setItems(data);
        loadCSVData("studentsData.csv");
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
                data.add(new StudentDataModel(row[0], row[1], row[2], row[3], row[4], row[5]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void clickDelete() {
        StudentDataModel selectedStudent = tableView.getSelectionModel().getSelectedItem();
        if (selectedStudent != null) {
            Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete this student?", ButtonType.YES, ButtonType.NO);
            Optional<ButtonType> result = confirmationAlert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.YES) {
                data.remove(selectedStudent);
                saveAllDataToCSV();
//                showAlert("Success", "Student deleted successfully.");
            }
        } else {
//            showAlert("Error", "No student selected.");
        }
    }

    private void saveAllDataToCSV() {
        try (CSVWriter csvWriter = new CSVWriter(new FileWriter("studentsData.csv"))) {
            String[] headers = {"FullName", "Faculty", "PhoneNumber", "Email", "Password"};
            csvWriter.writeNext(headers);
            for (StudentDataModel student : data) {
                String[] studentData = {student.getFullName(), student.getFaculty(), student.getPhoneNumber(),student.getGender(), student.getEmail(), student.getPassword()};
                csvWriter.writeNext(studentData);
            }
        } catch (IOException e) {
            e.printStackTrace();
//            showAlert("Error", "Failed to update the CSV file.");
        }
    }

    @FXML
    public void clickLogout(ActionEvent event) throws IOException {
        changeScene(event, "login.fxml", "STUDENT MANAGEMENT SYSTEM");
    }
    @FXML
    public void clickDashboard(ActionEvent event) throws IOException {
        changeScene(event, "admissionOfficerDashboard.fxml", "STUDENT MANAGEMENT SYSTEM");
    }
    @FXML
    public void clickAddStudents(ActionEvent event) throws IOException {
        changeScene(event, "addStudents.fxml", "STUDENT MANAGEMENT SYSTEM");
    }
}
