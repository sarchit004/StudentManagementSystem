package com.example.grpassignment_partb;

import javafx.beans.property.SimpleStringProperty;

public class StudentDataModel {
    private SimpleStringProperty FullName;
    private SimpleStringProperty Faculty;
    private SimpleStringProperty PhoneNumber;
    private SimpleStringProperty Gender;
    private SimpleStringProperty Email;
    private SimpleStringProperty Password;

    public StudentDataModel(String col1, String col2, String col3, String col4, String col5, String col6) {
        this.FullName = new SimpleStringProperty(col1);
        this.Faculty = new SimpleStringProperty(col2);
        this.PhoneNumber = new SimpleStringProperty(col3);
        this.Gender = new SimpleStringProperty(col4);
        this.Email = new SimpleStringProperty(col5);
        this.Password = new SimpleStringProperty(col6);
    }
    public String getFullName() { return FullName.get(); }
    public String getFaculty() { return Faculty.get(); }
    public String getPhoneNumber() { return PhoneNumber.get(); }
    public String getGender() { return Gender.get(); }
    public String getEmail() { return Email.get(); }
    public String getPassword() { return Password.get(); }

    public void setFullName(String col1) { FullName.set(col1); }
    public void setFaculty(String col2) { Faculty.set(col2); }
    public void setPhoneNumber(String col3) { PhoneNumber.set(col3); }
    public void setGender(String col4) { Gender.set(col4); }
    public void setEmail(String col5) { Email.set(col5); }
    public void setPassword(String col6) { Password.set(col6); }

    public SimpleStringProperty studentFullNameProperty() { return FullName; }
    public SimpleStringProperty studentFacultyProperty() { return Faculty; }
    public SimpleStringProperty studentPhoneNumberProperty() { return PhoneNumber; }
    public SimpleStringProperty studentGenderProperty() { return Gender; }
    public SimpleStringProperty studentEmailProperty() { return Email; }
    public SimpleStringProperty studentPasswordProperty() { return Password; }

}