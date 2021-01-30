package com.github.arlan.library.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "over_release_data")
public class OverReleaseData {
    @DatabaseField(generatedId = true, columnName = "id")
    private int id;

    @DatabaseField(columnName = "series_title")
    private String series_title;

    @DatabaseField(columnName = "series_issue_number")
    private String series_issue_number;

    @DatabaseField(columnName = "type_of_publication")
    private String type_of_publication;

    @DatabaseField(columnName = "title_publication")
    private String title_publication;

    @DatabaseField(columnName = "originators_name")
    private String originators_name;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setDate_of_signing(String date_of_signing) {
        this.series_title = date_of_signing;
    }

    public String getDate_of_signing() {
        return series_title;
    }

    public void setOriginators_name(String originators_name) {
        this.originators_name = originators_name;
    }

    public String getOriginators_name() {
        return originators_name;
    }

    public void setSeries_issue_number(String series_issue_number) {
        this.series_issue_number = series_issue_number;
    }

    public String getSeries_issue_number() {
        return series_issue_number;
    }

    public void setSeries_title(String series_title) {
        this.series_title = series_title;
    }

    public String getSeries_title() {
        return series_title;
    }

    public void setTitle_publication(String title_publication) {
        this.title_publication = title_publication;
    }

    public String getTitle_publication() {
        return title_publication;
    }

    public void setType_of_publication(String type_of_publication) {
        this.type_of_publication = type_of_publication;
    }

    public String getType_of_publication() {
        return type_of_publication;
    }

    public OverReleaseData() {}

    public OverReleaseData(int id, String series_title, String series_issue_number, String type_of_publication, String title_publication, String originators_name) {
        this.id = id;
        this.series_title = series_title;
        this.series_issue_number = series_issue_number;
        this.type_of_publication = type_of_publication;
        this.title_publication = title_publication;
        this.originators_name = originators_name;
    }
}