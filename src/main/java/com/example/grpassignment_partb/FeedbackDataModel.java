package com.example.grpassignment_partb;

import javafx.beans.property.SimpleStringProperty;

public class FeedbackDataModel {
    private SimpleStringProperty EmailID;
    private SimpleStringProperty Name;
    private SimpleStringProperty Course;
    private SimpleStringProperty Qn1;
    private SimpleStringProperty Qn2;
    private SimpleStringProperty AdditionalComments;

    public FeedbackDataModel(String col1, String col2, String col3, String col4, String col5, String col6) {
        this.EmailID = new SimpleStringProperty(col1);
        this.Name = new SimpleStringProperty(col2);
        this.Course = new SimpleStringProperty(col3);
        this.Qn1 = new SimpleStringProperty(col4);
        this.Qn2 = new SimpleStringProperty(col5);
        this.AdditionalComments = new SimpleStringProperty(col6);
    }
    public String getEmailID() { return EmailID.get(); }
    public String getName() { return Name.get(); }
    public String getCourse() { return Course.get(); }
    public String getQn1() { return Qn1.get(); }
    public String getQn2() { return Qn2.get(); }
    public String getAdditionalComments() { return AdditionalComments.get(); }

    public void setEmailID(String col1) { EmailID.set(col1); }
    public void setName(String col2) { Name.set(col2); }
    public void setCourse(String col3) { Course.set(col3); }
    public void setQn1(String col4) { Qn1.set(col4); }
    public void setQn2(String col5) { Qn2.set(col5); }
    public void setAdditionalComments(String col6) { AdditionalComments.set(col6); }

    public SimpleStringProperty feedbackEmailIDProperty() { return EmailID; }
    public SimpleStringProperty feedbackNameProperty() { return Name; }
    public SimpleStringProperty feedbackCourseProperty() { return Course; }
    public SimpleStringProperty feedbackQn1Property() { return Qn1; }
    public SimpleStringProperty feedbackQn2Property() { return Qn2; }
    public SimpleStringProperty feedbackAdditionalCommentsProperty() { return AdditionalComments; }

}