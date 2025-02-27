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

public class ManageLibrary {
    @FXML
    private TableView<LibraryDataModel> tableView;
    @FXML
    private TableColumn<LibraryDataModel, String> bookID;
    @FXML
    private TableColumn<LibraryDataModel, String> bookTitle;
    @FXML
    private TableColumn<LibraryDataModel, String> bookAuthor;

    private ObservableList<LibraryDataModel> data;

    @FXML
    public void initialize() {
        data = FXCollections.observableArrayList();
        bookID.setCellValueFactory(cellData -> cellData.getValue().bookIDProperty());
        bookTitle.setCellValueFactory(cellData -> cellData.getValue().bookTitleProperty());
        bookAuthor.setCellValueFactory(cellData -> cellData.getValue().bookAuthorProperty());

        tableView.setItems(data);
        loadCSVData("bookData.csv");
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
                data.add(new LibraryDataModel(row[0], row[1], row[2]));
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
        changeScene(event, "librarianDashboard.fxml", "STUDENT MANAGEMENT SYSTEM");
    }
    @FXML
    public void clickAddStudents(ActionEvent event) throws IOException {
        changeScene(event, "addBooks.fxml", "STUDENT MANAGEMENT SYSTEM");
    }
}
