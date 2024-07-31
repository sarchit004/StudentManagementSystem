package com.example.grpassignment_partb;

import javafx.beans.property.SimpleStringProperty;

public class StudentGradeDataModel {
    private SimpleStringProperty StudentsEmail;
    private SimpleStringProperty CourseID;
    private SimpleStringProperty CourseTitle;
    private SimpleStringProperty Grade;
    private SimpleStringProperty Comment;

    public StudentGradeDataModel(String col1, String col2, String col3, String col4, String col5) {
        this.StudentsEmail = new SimpleStringProperty(col1);
        this.CourseID = new SimpleStringProperty(col2);
        this.CourseTitle = new SimpleStringProperty(col3);
        this.Grade = new SimpleStringProperty(col4);
        this.Comment = new SimpleStringProperty(col5);
    }
    public String getStudentsEmail() { return StudentsEmail.get(); }
    public String getCourseID() { return CourseID.get(); }
    public String getCourseTitle() { return CourseTitle.get(); }
    public String getGrade() { return Grade.get(); }
    public String getComment() { return Comment.get(); }

    public void setStudentsEmail(String col1) { StudentsEmail.set(col1); }
    public void setCourseID(String col2) { CourseID.set(col2); }
    public void setCourseTitle(String col3) { CourseTitle.set(col3); }
    public void setGrade(String col4) { Grade.set(col4); }
    public void setComment(String col5) { Comment.set(col5); }

    public SimpleStringProperty studentEmailIDProperty() { return StudentsEmail; }
    public SimpleStringProperty studentCourseIDProperty() { return CourseID; }
    public SimpleStringProperty studentCourseTitleProperty() { return CourseTitle; }
    public SimpleStringProperty studentGradeProperty() { return Grade; }
    public SimpleStringProperty studentCommentProperty() { return Comment; }

}