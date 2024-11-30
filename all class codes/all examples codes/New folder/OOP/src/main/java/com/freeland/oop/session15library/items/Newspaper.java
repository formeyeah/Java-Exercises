package com.freeland.oop.session15library.items;

public class Newspaper implements LibraryItem {
    private String title;
    private String date;

    public Newspaper(String title, String date) {
        this.title = title;
        this.date = date;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getDetails() {
        return "Newspaper Title: " + title + ", Date: " + date;
    }
}