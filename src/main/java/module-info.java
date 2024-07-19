module com.example.grpassignment_partb {
    requires javafx.controls;
    requires javafx.fxml;

    requires opencsv;


    opens com.example.grpassignment_partb to javafx.fxml;
    exports com.example.grpassignment_partb;
}