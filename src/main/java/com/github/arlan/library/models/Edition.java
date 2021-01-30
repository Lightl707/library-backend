package com.github.arlan.library.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "edition")
public class Edition {
    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = "ISBN")
    private String ISBN;

    @DatabaseField(columnName = "UDK")
    private String UDK;

    @DatabaseField(columnName = "BBK")
    private String BBK;

    @DatabaseField(columnName = "pages")
    private String pages;

    @DatabaseField(foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true, columnName = "publisher_id")
    private Publisher publisher;

    @DatabaseField(foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true, columnName = "book")
    private Book book;

    @DatabaseField(foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true, columnName = "release_data")
    private ReleaseData release_data;

    @DatabaseField(foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true, columnName = "over_release_data")
    private OverReleaseData over_release_data;

    @DatabaseField(foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true, columnName = "company")
    private Company company;

    @DatabaseField(columnName = "title")
    private String title;

    @DatabaseField(columnName = "author_sign")
    private String author_sign;

    @DatabaseField(columnName = "size")
    private String size;

    @DatabaseField(columnName = "year")
    private String year;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Book getBook() {
        return book;
    }

    public void setBBK(String BBK) {
        this.BBK = BBK;
    }

    public Company getCompany() {
        return company;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public OverReleaseData getOver_release_data() {
        return over_release_data;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setAuthor_sign(String author_sign) {
        this.author_sign = author_sign;
    }

    public ReleaseData getRelease_data() {
        return release_data;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getBBK() {
        return BBK;
    }

    public void setOver_release_data(OverReleaseData over_release_data) {
        this.over_release_data = over_release_data;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getPages() {
        return pages;
    }

    public void setRelease_data(ReleaseData release_data) {
        this.release_data = release_data;
    }

    public String getAuthor_sign() {
        return author_sign;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setUDK(String UDK) {
        this.UDK = UDK;
    }

    public String getUDK() {
        return UDK;
    }

    public Edition() {
    }

    public Edition(int id, String ISBN, String UDK, String BBK, String pages, Publisher publisher, Book book, ReleaseData release_data, OverReleaseData over_release_data, Company company, String title, String author_sign, String size, String year) {
        this.id = id;
        this.author_sign = author_sign;
        this.BBK = BBK;
        this.ISBN = ISBN;
        this.UDK = UDK;
        this.pages = pages;
        this.publisher = publisher;
        this.book = book;
        this.release_data = release_data;
        this.over_release_data = over_release_data;
        this.company = company;
        this.title = title;
        this.size = size;
        this.year = year;
    }
}
