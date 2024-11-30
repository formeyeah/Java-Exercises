package com.freeland.oop.session15library;

import com.freeland.oop.session15library.items.LibraryItem;

public interface LibraryOperations {
    void addItem(LibraryItem item);
    void removeItem(String title);
    void displayItems();
}
