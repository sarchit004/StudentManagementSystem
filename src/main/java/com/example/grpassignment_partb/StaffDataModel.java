package com.example.grpassignment_partb;

import javafx.beans.property.SimpleStringProperty;

public class StaffDataModel {
    private SimpleStringProperty FullName;
    private SimpleStringProperty Department;
    private SimpleStringProperty Role;
    private SimpleStringProperty PhoneNumber;
    private SimpleStringProperty Gender;
    private SimpleStringProperty Email;
    private SimpleStringProperty Password;

    public StaffDataModel(String col1, String col2, String col3, String col4, String col5, String col6, String col7) {
        this.FullName = new SimpleStringProperty(col1);
        this.Department = new SimpleStringProperty(col2);
        this.Role = new SimpleStringProperty(col3);
        this.PhoneNumber = new SimpleStringProperty(col4);
        this.Gender = new SimpleStringProperty(col5);
        this.Email = new SimpleStringProperty(col6);
        this.Password = new SimpleStringProperty(col7);
    }
    public String getFullName() { return FullName.get(); }
    public String getDepartment() { return Department.get(); }
    public String getRole() { return Role.get(); }
    public String getPhoneNumber() { return PhoneNumber.get(); }
    public String getGender() { return Gender.get(); }
    public String getEmail() { return Email.get(); }
    public String getPassword() { return Password.get(); }

    public void setFullName(String col1) { FullName.set(col1); }
    public void setDepartment(String col2) { Department.set(col2); }
    public void setRole(String col3) { Role.set(col3); }
    public void setPhoneNumber(String col4) { PhoneNumber.set(col4); }
    public void setGender(String col5) { Gender.set(col5); }
    public void setEmail(String col6) { Email.set(col6); }
    public void setPassword(String col7) { Password.set(col7); }

    public SimpleStringProperty staffFullNameProperty() { return FullName; }
    public SimpleStringProperty staffDepartmentProperty() { return Department; }
    public SimpleStringProperty staffRoleProperty() { return Role; }
    public SimpleStringProperty staffPhoneNumberProperty() { return PhoneNumber; }
    public SimpleStringProperty staffGenderProperty() { return Gender; }
    public SimpleStringProperty staffEmailProperty() { return Email; }
    public SimpleStringProperty staffPasswordProperty() { return Password; }

}