package com.github.arlan.library.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "release_data")
public class ReleaseData {
    @DatabaseField(generatedId = true, columnName = "id")
    private int id;

    @DatabaseField(columnName = "date_of_signing")
    private String date_of_signing;

    @DatabaseField(columnName = "paper_size")
    private String paper_size;

    @DatabaseField(columnName = "sheet_fraction")
    private String sheet_fraction;

    @DatabaseField(columnName = "volume_edition")
    private String volume_edition;

    @DatabaseField(columnName = "order_number")
    private String order_number;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setDate_of_signing(String date_of_signing) {
        this.date_of_signing = date_of_signing;
    }

    public String getDate_of_signing() {
        return date_of_signing;
    }

    public void setOrder_number(String order_number) {
        this.order_number = order_number;
    }

    public String getOrder_number() {
        return order_number;
    }

    public void setPaper_size(String paper_size) {
        this.paper_size = paper_size;
    }

    public String getPaper_size() {
        return paper_size;
    }

    public void setSheet_fraction(String sheet_fraction) {
        this.sheet_fraction = sheet_fraction;
    }

    public String getSheet_fraction() {
        return sheet_fraction;
    }

    public void setVolume_edition(String volume_edition) {
        this.volume_edition = volume_edition;
    }

    public String getVolume_edition() {
        return volume_edition;
    }

    public ReleaseData() {}

    public ReleaseData(int id, String date_of_signing, String paper_size, String sheet_fraction, String volume_edition, String order_number) {
        this.id = id;
        this.date_of_signing = date_of_signing;
        this.paper_size = paper_size;
        this.sheet_fraction = sheet_fraction;
        this.volume_edition = volume_edition;
        this.order_number = order_number;
    }
}