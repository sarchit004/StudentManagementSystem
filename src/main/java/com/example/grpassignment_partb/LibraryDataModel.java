package com.example.grpassignment_partb;

import javafx.beans.property.SimpleStringProperty;

public class LibraryDataModel {
    private SimpleStringProperty BookID;
    private SimpleStringProperty BookTitle;
    private SimpleStringProperty BookAuthor;

    public LibraryDataModel(String col1, String col2, String col3) {
        this.BookID = new SimpleStringProperty(col1);
        this.BookTitle = new SimpleStringProperty(col2);
        this.BookAuthor = new SimpleStringProperty(col3);
    }

    public String getBookID() { return BookID.get(); }
    public String getBookTitle() { return BookTitle.get(); }
    public String getBookAuthor() { return BookAuthor.get(); }

    public void setBookID(String col1) { BookID.set(col1); }
    public void setBookTitle(String col2) { BookTitle.set(col2); }
    public void setBookAuthor(String col3) { BookAuthor.set(col3); }

    public SimpleStringProperty bookIDProperty() { return BookID; }
    public SimpleStringProperty bookTitleProperty() { return BookTitle; }
    public SimpleStringProperty bookAuthorProperty() { return BookAuthor; }
}
