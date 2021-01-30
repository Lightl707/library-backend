package com.github.arlan.library.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "author_book")
public class Author_Book {
    @DatabaseField(generatedId = true, columnName = "id")
    private int id;

    @DatabaseField(foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true, columnName = "book")
    private Book book;

    @DatabaseField(foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true, columnName = "author")
    private Author author;

    @DatabaseField(columnName = "ordinal")
    private String ordinal;

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Author getAuthor() {
        return author;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Book getBook() {
        return book;
    }

    public void setOrdinal(String ordinal) {
        this.ordinal = ordinal;
    }

    public String getOrdinal() {
        return ordinal;
    }

    public Author_Book() {}

    public Author_Book(int id,Book book,Author author,String ordinal) {
        this.id = id;
        this.book = book;
        this.author = author;
        this.ordinal = ordinal;
    }
}