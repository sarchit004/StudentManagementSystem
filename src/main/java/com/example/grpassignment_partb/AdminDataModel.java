package com.example.grpassignment_partb;

import javafx.beans.property.SimpleStringProperty;

public class AdminDataModel {
    private SimpleStringProperty FullName;
    private SimpleStringProperty Gender;
    private SimpleStringProperty PhoneNumber;
    private SimpleStringProperty Email;
    private SimpleStringProperty Password;

    public AdminDataModel(String col1, String col2, String col3, String col4, String col5) {
        this.FullName = new SimpleStringProperty(col1);
        this.Gender = new SimpleStringProperty(col2);
        this.PhoneNumber = new SimpleStringProperty(col3);
        this.Email = new SimpleStringProperty(col4);
        this.Password = new SimpleStringProperty(col5);
    }
    public String getFullName() { return FullName.get(); }
    public String getGender() { return Gender.get(); }
    public String getPhoneNumber() { return PhoneNumber.get(); }
    public String getEmail() { return Email.get(); }
    public String getPassword() { return Password.get(); }

    public void setFullName(String col1) { FullName.set(col1); }
    public void setGender(String col2) { Gender.set(col2); }
    public void setPhoneNumber(String col3) { PhoneNumber.set(col3); }
    public void setEmail(String col4) { Email.set(col4); }
    public void setPassword(String col5) { Password.set(col5); }

    public SimpleStringProperty adminFullNameProperty() { return FullName; }
    public SimpleStringProperty adminGenderProperty() { return Gender; }
    public SimpleStringProperty adminPhoneNumberProperty() { return PhoneNumber; }
    public SimpleStringProperty adminEmailProperty() { return Email; }
    public SimpleStringProperty adminPasswordProperty() { return Password; }

}