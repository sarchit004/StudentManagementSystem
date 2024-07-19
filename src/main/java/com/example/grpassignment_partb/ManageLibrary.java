package com.example.grpassignment_partb;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

import static com.example.grpassignment_partb.Uses.changeScene;

public class ManageLibrary {
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
