package com.example.grpassignment_partb;

import javafx.beans.property.SimpleStringProperty;

public class SportsParticipationDataModel {
    private SimpleStringProperty StudentID;
    private SimpleStringProperty FullName;
    private SimpleStringProperty Faculty;
    private SimpleStringProperty SportSelected;
    private SimpleStringProperty MembersCount;
    private SimpleStringProperty MembersList;

    public SportsParticipationDataModel(String col1, String col2, String col3, String col4, String col5, String col6) {
        this.StudentID = new SimpleStringProperty(col1);
        this.FullName = new SimpleStringProperty(col2);
        this.Faculty = new SimpleStringProperty(col3);
        this.SportSelected = new SimpleStringProperty(col4);
        this.MembersCount = new SimpleStringProperty(col5);
        this.MembersList = new SimpleStringProperty(col6);
    }
    public String getStudentID() { return StudentID.get(); }
    public String getFullName() { return FullName.get(); }
    public String getFaculty() { return Faculty.get(); }
    public String getSportSelected() { return SportSelected.get(); }
    public String getMembersCount() { return MembersCount.get(); }
    public String getMembersList() { return MembersList.get(); }

    public void setStudentID(String col1) { StudentID.set(col1); }
    public void setFullName(String col2) { FullName.set(col2); }
    public void setFaculty(String col3) { Faculty.set(col3); }
    public void setSportSelected(String col4) { SportSelected.set(col4); }
    public void setMembersCount(String col5) { MembersCount.set(col5); }
    public void setMembersList(String col6) { MembersList.set(col6); }

    public SimpleStringProperty studentsSportsIDProperty() { return StudentID; }
    public SimpleStringProperty studentSportsFullNameProperty() { return FullName; }
    public SimpleStringProperty studentsSportsFacultyProperty() { return Faculty; }
    public SimpleStringProperty studentsSelectedSportProperty() { return SportSelected; }
    public SimpleStringProperty studentsMemberCountProperty() { return MembersCount; }
    public SimpleStringProperty studentsMemberListProperty() { return MembersList; }

}