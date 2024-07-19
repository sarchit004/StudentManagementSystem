package com.example.grpassignment_partb;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

import static com.example.grpassignment_partb.Uses.changeScene;

public class AddTeachers {
    @FXML
    public void clickCancel(ActionEvent event) throws IOException {
        changeScene(event, "manageTeachers.fxml", "STUDENT MANAGEMENT SYSTEM");
    }
}
