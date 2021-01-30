package com.github.arlan.library.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "user")
public class User {
    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = "fname")
    private String fname;

    @DatabaseField(columnName = "lname")
    private String lname;

    @DatabaseField(unique = true,columnName = "email")
    private String email;

    @DatabaseField(unique = true,columnName = "login")
    private  String login;

    @DatabaseField(columnName = "password")
    private String password;

    @DatabaseField(columnName = "role")
    private Role role;

    @DatabaseField(unique = true,columnName = "YIN")
    private String YIN;

    @DatabaseField(columnName = "img")
    private String img;

    @DatabaseField(foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true, columnName = "favourite")
    private FavouriteList favourite;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFavourite(FavouriteList favourite) {
        this.favourite = favourite;
    }

    public FavouriteList getFavourite() {
        return favourite;
    }

    public String getEmail() {
        return email;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getFname() {
        return fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getLname() {
        return lname;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {return role;}

    public void setRole(Role role) {this.role = role;}

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public String getYIN() {
        return YIN;
    }

    public void setYIN(String YIN) {
        this.YIN = YIN;
    }

    public User() {
    }

    public User(int id, String fname, String lname, String email, String login, String password, Role role, String YIN, FavouriteList favourite, String img) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.login = login;
        this.email = email;
        this.role = role;
        this.password = password;
        this.img = img;
        this.YIN = YIN;
        this.favourite = favourite;
    }
}
