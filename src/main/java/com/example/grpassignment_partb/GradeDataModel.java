package com.example.grpassignment_partb;

public class GradeDataModel {
    private String courseId;
    private String courseTitle;
    private String grade;
    private String comments;

    public GradeDataModel(String courseId, String courseTitle, String grade, String comments) {
        this.courseId = courseId;
        this.courseTitle = courseTitle;
        this.grade = grade;
        this.comments = comments;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public String getGrade() {
        return grade;
    }

    public String getComments() {
        return comments;
    }
}
