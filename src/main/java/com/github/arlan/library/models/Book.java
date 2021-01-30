package com.github.arlan.library.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "book")
public class Book {
    @DatabaseField(generatedId = true, columnName = "id")
    private int id;

    @DatabaseField(foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true, columnName = "author")
    private Author author;

    @DatabaseField(foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true, columnName = "original_Title")
    private Translatable_String original_Title;

    @DatabaseField(columnName = "img")
    private String img;

    @DatabaseField(columnName = "description")
    private String description;

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getImg() {
        return img;
    }

    public Author getAuthor() {
        return author;
    }

    public Translatable_String getOriginal_Title() {
        return original_Title;
    }

    public void setOriginal_Title(Translatable_String original_Title) {
        this.original_Title = original_Title;
    }

    public Book() {}

    public Book(int id,Author author,Translatable_String original_Title, String img, String description) {
        this.id = id;
        this.author = author;
        this.original_Title = original_Title;
        this.img = img;
        this.description = description;
    }
}
