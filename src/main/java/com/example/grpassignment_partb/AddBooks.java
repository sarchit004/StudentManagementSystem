package com.example.grpassignment_partb;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;

import static com.example.grpassignment_partb.Uses.changeScene;
import static com.example.grpassignment_partb.Uses.saveDatatoCSV;

public class AddBooks {
    @FXML
    private TextField bookIdBox;
    @FXML
    private TextField bookTitleBox;
    @FXML
    private TextField bookAuthorBox;

    @FXML
    public void clickAdd(ActionEvent event) throws IOException {
        String bookID = bookIdBox.getText();
        String bookTitle = bookTitleBox.getText();
        String bookAuthor = bookAuthorBox.getText();

        String[] values = {bookID, bookTitle, bookAuthor};
        saveDatatoCSV("bookData.csv", values);
    }

    @FXML
    public void clickCancel(ActionEvent event) throws IOException {
        changeScene(event, "manageLibrary.fxml", "STUDENT MANAGEMENT SYSTEM");
    }
}
