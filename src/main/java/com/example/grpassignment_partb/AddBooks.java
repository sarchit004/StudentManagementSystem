package com.example.grpassignment_partb;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

import static com.example.grpassignment_partb.Uses.*;

public class AddBooks {
    @FXML
    private TextField bookIdBox;
    @FXML
    private TextField bookTitleBox;
    @FXML
    private TextField bookAuthorBox;
    @FXML
    private Label messageLabel;

    @FXML
    public void clickAdd(ActionEvent event) throws IOException {
        String bookID = bookIdBox.getText();
        String bookTitle = bookTitleBox.getText();
        String bookAuthor = bookAuthorBox.getText();

        errorLabelVisibility(messageLabel, false);

        if (bookID.isEmpty() || bookTitle.isEmpty() || bookAuthor.isEmpty()){
            error(messageLabel, "All above fields are requrired");
        } else {
            String[] values = {bookID, bookTitle, bookAuthor};
            saveDatatoCSV("bookData.csv", values);
            success(messageLabel, "Added Succesfully!!");
        }
    }

    @FXML
    public void clickCancel(ActionEvent event) throws IOException {
        changeScene(event, "manageLibrary.fxml", "STUDENT MANAGEMENT SYSTEM");
    }
}
