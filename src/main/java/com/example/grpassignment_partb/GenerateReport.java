package com.example.grpassignment_partb;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.example.grpassignment_partb.Uses.*;

public class GenerateReport {
    @FXML
    private TextField reportNameBox;
    @FXML
    private Label reportNameLabel;
    @FXML
    private Label messageLabel;


    @FXML
    private void clickCreateReport(ActionEvent event){
        String reportName = reportNameBox.getText();
        String finalReportName = reportName+ ".csv";

        errorLabelVisibility(messageLabel, false);
        errorLabelVisibility(reportNameLabel, false);

        if (reportName.isEmpty()){
            error(messageLabel, "Report Name cannot be empty!");
        } else {
            mergeCSVFiles("studentsData.csv", "studentsGrade.csv", finalReportName);
            reportNameLabel.setText(finalReportName);
            reportNameLabel.setVisible(true);
            success(messageLabel, "Report has been successfully generated. Please Check!");
        }
    }
    private void mergeCSVFiles(String csvFile1, String csvFile2, String outputCsvFile) {
        List<String[]> allRows = new ArrayList<>();

        try (CSVReader csvReader1 = new CSVReader(new FileReader(csvFile1));
             CSVReader csvReader2 = new CSVReader(new FileReader(csvFile2))) {

            allRows.addAll(csvReader1.readAll());
            allRows.addAll(csvReader2.readAll());

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(outputCsvFile))) {
            csvWriter.writeAll(allRows);
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
        changeScene(event, "adminDashboard.fxml", "STUDENT MANAGEMENT SYSTEM");
    }
    @FXML
    public void clickManageStaffs(ActionEvent event) throws IOException {
        changeScene(event, "manageStaffs.fxml", "STUDENT MANAGEMENT SYSTEM");
    }
    @FXML
    public void clickManageTeachers(ActionEvent event) throws IOException {
        changeScene(event, "manageTeachers.fxml", "STUDENT MANAGEMENT SYSTEM");
    }
}
