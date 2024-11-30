package com.freeland.oop.session15library.items;

public class Magazine implements LibraryItem {
    private String title;
    private String issue;

    public Magazine(String title, String issue) {
        this.title = title;
        this.issue = issue;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getDetails() {
        return "Magazine Title: " + title + ", Issue: " + issue;
    }
}