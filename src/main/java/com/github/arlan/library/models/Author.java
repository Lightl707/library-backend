package com.github.arlan.library.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "author")
public class Author {
    @DatabaseField(generatedId = true, columnName = "id")
    private int id;

    @DatabaseField(foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true, columnName = "fname")
    private Translatable_String fname;

    @DatabaseField(foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true, columnName = "lname")
    private Translatable_String lname;

    @DatabaseField(columnName = "nickname")
    private String nickname;

    @DatabaseField(columnName = "year_of_birthday")
    private String year_of_birthday;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setLname(Translatable_String lname) {
        this.lname = lname;
    }

    public Translatable_String getFname() {
        return fname;
    }

    public void setFname(Translatable_String fname) {
        this.fname = fname;
    }

    public Translatable_String getLname() {
        return lname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setYear_of_birthday(String year_of_birthday) {
        this.year_of_birthday = year_of_birthday;
    }

    public String getYear_of_birthday() {
        return year_of_birthday;
    }

    public Author() {
    }

    public Author(int id,Translatable_String fname,Translatable_String lname,String nickname,String year_of_birthday ) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.nickname = nickname;
        this.year_of_birthday = year_of_birthday;
    }
}