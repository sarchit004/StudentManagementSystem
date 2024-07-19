package com.example.grpassignment_partb;

import com.opencsv.CSVWriter;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;

public class Uses {

    public static Stage getCurrentStage(ActionEvent event){
        Node node = (Node)event.getSource();
        Stage stage = (Stage)node.getScene().getWindow();
        return stage;
    }
    public static void changeScene(ActionEvent event, String sceneName, String title) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader((HelloApplication.class.getResource(sceneName)));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = getCurrentStage(event);
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }

    public static String selectedRadioBtn(RadioButton btn1,RadioButton btn2,RadioButton btn3){
        if (btn1.isSelected()) {
            return btn1.getText();
        } else if (btn2.isSelected()) {
            return btn2.getText();
        } else if (btn3.isSelected()) {
            return btn3.getText();
        }
        return null;
    }

    public static void error(Label errorLabel, String message){
        errorLabel.setVisible(true);
        errorLabel.setText(message);
        errorLabel.setStyle("-fx-text-fill: red;");
    }
    public static void errorLabelVisibility(Label errorLabel, boolean value){
        errorLabel.setVisible(value);
    }

    public static void saveDatatoCSV(String fileName, String... values) throws IOException {
        try(CSVWriter writer = new CSVWriter(new FileWriter(fileName, true))) {
            writer.writeNext(values);
        }
    }
}