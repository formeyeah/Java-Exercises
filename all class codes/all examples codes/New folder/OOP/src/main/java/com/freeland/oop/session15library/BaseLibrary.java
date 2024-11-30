package com.freeland.oop.session15library;

import java.util.ArrayList;
import java.util.List;

import com.freeland.oop.session15library.items.LibraryItem;

public abstract class BaseLibrary implements LibraryOperations {
    protected List<LibraryItem> items;

    public BaseLibrary() {
        items = new ArrayList<>();
    }

    @Override
    public void addItem(LibraryItem item) {
        items.add(item);
        System.out.println(item.getTitle() + " has been added to the library.");
    }

    @Override
    public void removeItem(String title) {
        items.removeIf(item -> item.getTitle().equalsIgnoreCase(title));
        System.out.println(title + " has been removed from the library.");
    }

    @Override
    public void displayItems() {
        if (items.isEmpty()) {
            System.out.println("No items in the library.");
            return;
        }
        System.out.println("Library Items:");
        for (LibraryItem item : items) {
            System.out.println(item.getDetails());
        }
    }
}
