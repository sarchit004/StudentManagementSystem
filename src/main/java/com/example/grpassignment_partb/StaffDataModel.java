package com.example.grpassignment_partb;

import javafx.beans.property.SimpleStringProperty;

public class StaffDataModel {
    private SimpleStringProperty column1;
    private SimpleStringProperty column2;
    private SimpleStringProperty column3;
    private SimpleStringProperty column4;

    public StaffDataModel(String col1, String col2, String col3, String col4) {
        this.column1 = new SimpleStringProperty(col1);
        this.column2 = new SimpleStringProperty(col2);
        this.column3 = new SimpleStringProperty(col3);
        this.column4 = new SimpleStringProperty(col4);
    }

    public String getColumn1() { return column1.get(); }
    public String getColumn2() { return column2.get(); }
    public String getColumn3() { return column3.get(); }
    public String getColumn4() { return column4.get(); }

    public void setColumn1(String col1) { column1.set(col1); }
    public void setColumn2(String col2) { column2.set(col2); }
    public void setColumn3(String col3) { column3.set(col3); }
    public void setColumn4(String col4) { column4.set(col4); }

    public SimpleStringProperty column1Property() { return column1; }
    public SimpleStringProperty column2Property() { return column2; }
    public SimpleStringProperty column3Property() { return column3; }
    public SimpleStringProperty column4Property() { return column4; }
}
