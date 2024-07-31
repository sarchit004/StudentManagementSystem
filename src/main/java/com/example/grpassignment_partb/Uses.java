package com.example.grpassignment_partb;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

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

    public static void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
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
    public static String selectedProblemCategory(RadioButton btn1,RadioButton btn2,RadioButton btn3, RadioButton btn4, RadioButton btn5){
        if (btn1.isSelected()) {
            return btn1.getText();
        } else if (btn2.isSelected()) {
            return btn2.getText();
        } else if (btn3.isSelected()) {
            return btn3.getText();
        } else if (btn4.isSelected()) {
            return btn4.getText();
        } else if (btn5.isSelected()) {
            return btn5.getText();
        }
        return null;
    }
    public static String selectedECA(RadioButton btn1,RadioButton btn2,RadioButton btn3, RadioButton btn4){
        if (btn1.isSelected()) {
            return btn1.getText();
        } else if (btn2.isSelected()) {
            return btn2.getText();
        } else if (btn3.isSelected()) {
            return btn3.getText();
        } else if (btn4.isSelected()) {
            return btn4.getText();
        }
        return null;
    }

    public static void error(Label errorLabel, String message){
        errorLabel.setVisible(true);
        errorLabel.setText(message);
        errorLabel.setStyle("-fx-text-fill: red;");
    }
    public static void success(Label successLabel, String message){
        successLabel.setVisible(true);
        successLabel.setText(message);
        successLabel.setStyle("-fx-text-fill: green;");
    }
    public static void errorLabelVisibility(Label errorLabel, boolean value){
        errorLabel.setVisible(value);
    }

    public static void saveDatatoCSV(String fileName, String[] headers, String... values) throws IOException {
        File file = new File(fileName);
        try (CSVWriter writer = new CSVWriter(new FileWriter(file, true),
                CSVWriter.DEFAULT_SEPARATOR,
                CSVWriter.NO_QUOTE_CHARACTER,
                CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                CSVWriter.DEFAULT_LINE_END)) {
            if (file.length() == 0) {
                writer.writeNext(headers);
            }
            writer.writeNext(values);
        }
    }
    public static int countCSVrows(String filePath) {
        int rowCount = 0;
        try (CSVReader csvReader = new CSVReader(new FileReader(filePath))) {
            while (csvReader.readNext() != null) {
                rowCount++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rowCount-1;
    }

    public static String encryptPassword(String password) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = messageDigest.digest(password.getBytes());

            // Convert the hashed bytes to a hexadecimal format
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashedBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error encrypting password", e);
        }
    }

    public static boolean isEmailUnique(String email, String filePath, int emailColumnIndex) {
        String line;
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Skip the header line
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] userDetails = line.split(csvSplitBy);
                if (userDetails.length > emailColumnIndex) {
                    String existingEmail = userDetails[emailColumnIndex];
                    if (email.equals(existingEmail)) {
                        return false;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static boolean validateCredentials(String enteredUsername, String enteredPassword, String selectedRole, String csvFilePath) {
        String line;
        String csvSplitBy = ",";

        String encryptedEnteredPassword = encryptPassword(enteredPassword);

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            // Skip the header line
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] userDetails = line.split(csvSplitBy);

                // Initialize variables to hold user details
                String savedEmail = "";
                String savedPassword = "";
                String role = "";

                switch (csvFilePath) {
                    case "adminData.csv":
                        savedEmail = userDetails[3];
                        savedPassword = userDetails[4];
                        role = "Admin";
                        break;
                    case "teachersData.csv":
                        savedEmail = userDetails[4];
                        savedPassword = userDetails[5];
                        role = "Teacher";
                        break;
                    case "studentsData.csv":
                        savedEmail = userDetails[4];
                        savedPassword = userDetails[5];
                        role = "Student";
                        break;
                    case "staffData.csv":
                        savedEmail = userDetails[5];
                        savedPassword = userDetails[6];
                        role = userDetails[2];
                        break;
                    default:
                        throw new IllegalArgumentException("Unsupported CSV file: " + csvFilePath);
                }

                // Check credentials
                if (enteredUsername.equals(savedEmail) && encryptedEnteredPassword.equals(savedPassword) && selectedRole.equals(role)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static List<String[]> getStudentGrades(String studentEmail, String csvFilePath) {
        List<String[]> grades = new ArrayList<>();
        String line;
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            br.readLine(); // Skip the header

            while ((line = br.readLine()) != null) {
                String[] gradeDetails = line.split(csvSplitBy);

                if (gradeDetails[0].equals(studentEmail)) {
                    grades.add(gradeDetails);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return grades;
    }



    public static void printColumn(String filePath, int columnIndex) {
        String line;
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Read and skip the header line
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] values = line.split(csvSplitBy);
                if (values.length > columnIndex) {
                    String columnValue = values[columnIndex].trim();  // Trim any extra spaces
                    System.out.println("Column " + columnIndex + " value: " + columnValue);
                } else {
                    System.out.println("Row does not have enough columns.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}