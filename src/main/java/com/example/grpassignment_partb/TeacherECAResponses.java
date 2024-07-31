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

public class TeacherECAResponses {
    @FXML
    private TableView<SportsParticipationDataModel> tableView;
    @FXML
    private TableColumn<SportsParticipationDataModel, String> studentID;
    @FXML
    private TableColumn<SportsParticipationDataModel, String> studentFullName;
    @FXML
    private TableColumn<SportsParticipationDataModel, String> faculty;
    @FXML
    private TableColumn<SportsParticipationDataModel, String> sportsSelected;
    @FXML
    private TableColumn<SportsParticipationDataModel, String> memberCount;
    @FXML
    private TableColumn<SportsParticipationDataModel, String> memberList;

    private ObservableList<SportsParticipationDataModel> data;

    @FXML
    public void initialize() {
        data = FXCollections.observableArrayList();
        studentID.setCellValueFactory(cellData -> cellData.getValue().studentsSportsIDProperty());
        studentFullName.setCellValueFactory(cellData -> cellData.getValue().studentSportsFullNameProperty());
        faculty.setCellValueFactory(cellData -> cellData.getValue().studentsSportsFacultyProperty());
        sportsSelected.setCellValueFactory(cellData -> cellData.getValue().studentsSelectedSportProperty());
        memberCount.setCellValueFactory(cellData -> cellData.getValue().studentsMemberCountProperty());
        memberList.setCellValueFactory(cellData -> cellData.getValue().studentsMemberListProperty());

        tableView.setItems(data);
        loadCSVData("sportsParticipation.csv");
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
                data.add(new SportsParticipationDataModel(row[0], row[1], row[2], row[3], row[4], row[5]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void clickViewIssues(ActionEvent event) throws IOException {
        changeScene(event, "viewIssues.fxml", "STUDENT MANAGEMENT SYSTEM");
    }
    @FXML
    public void clickLogout(ActionEvent event) throws IOException {
        changeScene(event, "login.fxml", "STUDENT MANAGEMENT SYSTEM");
    }
    @FXML
    public void clickAssignGrades(ActionEvent event) throws IOException {
        changeScene(event, "assignGrades.fxml", "STUDENT MANAGEMENT SYSTEM");
    }
    @FXML
    public void clickDashboard(ActionEvent event) throws IOException {
        changeScene(event, "teacherDashboard.fxml", "STUDENT MANAGEMENT SYSTEM");
    }
}
