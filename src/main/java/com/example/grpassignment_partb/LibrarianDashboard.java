package com.example.grpassignment_partb;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

import static com.example.grpassignment_partb.Uses.changeScene;

public class LibrarianDashboard {
    @FXML
    public void clickLogout(ActionEvent event) throws IOException {
        changeScene(event, "login.fxml", "STUDENT MANAGEMENT SYSTEM");
    }
    @FXML
    public void clickManageStudents(ActionEvent event) throws IOException {
        changeScene(event, "manageLibrary.fxml", "STUDENT MANAGEMENT SYSTEM");
    }
}
