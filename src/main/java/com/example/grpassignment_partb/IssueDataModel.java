package com.example.grpassignment_partb;

import javafx.beans.property.SimpleStringProperty;

public class IssueDataModel {
    private SimpleStringProperty EmailID;
    private SimpleStringProperty DateReported;
    private SimpleStringProperty ProblemCategory;
    private SimpleStringProperty IssueDescription;

    public IssueDataModel(String col1, String col2, String col3, String col4) {
        this.EmailID = new SimpleStringProperty(col1);
        this.DateReported = new SimpleStringProperty(col2);
        this.ProblemCategory = new SimpleStringProperty(col3);
        this.IssueDescription = new SimpleStringProperty(col4);
    }
    public String getEmailID() { return EmailID.get(); }
    public String getDateReported() { return DateReported.get(); }
    public String getProblemCategory() { return ProblemCategory.get(); }
    public String getIssueDescription() { return IssueDescription.get(); }

    public void setEmailID(String col1) { EmailID.set(col1); }
    public void setDateReported(String col2) { DateReported.set(col2); }
    public void setProblemCategory(String col3) { ProblemCategory.set(col3); }
    public void setIssueDescription(String col4) { IssueDescription.set(col4); }

    public SimpleStringProperty issueEmailIDProperty() { return EmailID; }
    public SimpleStringProperty issueDateReportedProperty() { return DateReported; }
    public SimpleStringProperty issueProblemCategoryProperty() { return ProblemCategory; }
    public SimpleStringProperty issueDescriptionProperty() { return IssueDescription; }

}