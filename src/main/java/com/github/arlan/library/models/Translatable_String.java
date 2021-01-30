package com.github.arlan.library.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "translatable_string")
public class Translatable_String {
    @DatabaseField(generatedId = true, columnName = "id")
    private int id;

    @DatabaseField(columnName = "text")
    private String text;

    @DatabaseField(foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true, columnName = "parent")
    private Translatable_String parent;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setParent(Translatable_String parent) {
        this.parent = parent;
    }

    public Translatable_String getParent() {
        return parent;
    }

    public Translatable_String() {
    }

    public Translatable_String(int id,String text,Translatable_String parent) {
        this.id = id;
        this.parent = parent;
        this.text = text;
    }
}
