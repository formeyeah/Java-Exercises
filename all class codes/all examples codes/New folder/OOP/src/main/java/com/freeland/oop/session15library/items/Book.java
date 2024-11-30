package com.freeland.oop.session15library.items;

public class Book implements LibraryItem {
    private String title;
    private String author;
    private String isbn;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getDetails() {
        return "Book Title: " + title + ", Author: " + author + ", ISBN: " + isbn;
    }
}