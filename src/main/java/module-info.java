module com.example.grpassignment_partb {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.studentmanagementsystem to javafx.fxml;
    exports com.example.studentmanagementsystem;
}