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

public class ViewIssues {
    @FXML
    private TableView<IssueDataModel> tableView;
    @FXML
    private TableColumn<IssueDataModel, String> emailID;
    @FXML
    private TableColumn<IssueDataModel, String> dateReported;
    @FXML
    private TableColumn<IssueDataModel, String> problemCategory;
    @FXML
    private TableColumn<IssueDataModel, String> issueDescription;

    private ObservableList<IssueDataModel> data;

    @FXML
    public void initialize() {
        data = FXCollections.observableArrayList();
        emailID.setCellValueFactory(cellData -> cellData.getValue().issueEmailIDProperty());
        dateReported.setCellValueFactory(cellData -> cellData.getValue().issueDateReportedProperty());
        problemCategory.setCellValueFactory(cellData -> cellData.getValue().issueProblemCategoryProperty());
        issueDescription.setCellValueFactory(cellData -> cellData.getValue().issueDescriptionProperty());

        tableView.setItems(data);
        loadCSVData("issuesData.csv");
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
                data.add(new IssueDataModel(row[0], row[1], row[2], row[3]));
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
    public void clickDashboard(ActionEvent event) throws IOException {
        changeScene(event, "teacherDashboard.fxml", "STUDENT MANAGEMNENT SYSTEM");
    }

    @FXML
    public void clickAssignGrades(ActionEvent event) throws IOException {
        changeScene(event, "AssignGrades.fxml", "STUDENT MANAGEMENT SYSTEM");
    }

    @FXML
    public void clickECAformResponse(ActionEvent event) throws IOException {
        changeScene(event, "teacherECAResponses.fxml", "STUDENT MANAGEMENT SYSTEM");
    }

}
