package com.github.arlan.library.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "history_user")
public class HistoryUser {
    @DatabaseField(generatedId = true, columnName = "id")
    private int id;

    @DatabaseField(foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true, columnName = "user")
    private User user;

    @DatabaseField(foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true, columnName = "book")
    private Book book;

    @DatabaseField(columnName = "issue")
    private Boolean issue;

    @DatabaseField(columnName = "deadline")
    private String deadline;

    public void setBook(Book book) {
        this.book = book;
    }

    public Book getBook() {
        return book;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public Boolean getIssue() {
        return issue;
    }

    public void setIssue(Boolean issue) {
        this.issue = issue;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public HistoryUser() {}

    HistoryUser(int id, User user, Book book, Boolean issue, String deadline) {
        this.id = id;
        this.user = user;
        this.book = book;
        this.deadline = deadline;
        this.issue = issue;
    }
}