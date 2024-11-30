package com.freeland.oop.session15library;

import java.util.Scanner;

import com.freeland.oop.session15library.items.Book;
import com.freeland.oop.session15library.items.Magazine;
import com.freeland.oop.session15library.items.Newspaper;

public class LibraryApp {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Add Magazine");
            System.out.println("3. Add Newspaper");
            System.out.println("4. Remove Item");
            System.out.println("5. Display Items");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String bookTitle = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter book ISBN: ");
                    String isbn = scanner.nextLine();
                    library.addItem(new Book(bookTitle, author, isbn));
                    break;
                case 2:
                    System.out.print("Enter magazine title: ");
                    String magazineTitle = scanner.nextLine();
                    System.out.print("Enter magazine issue: ");
                    String issue = scanner.nextLine();
                    library.addItem(new Magazine(magazineTitle, issue));
                    break;
                case 3:
                    System.out.print("Enter newspaper title: ");
                    String newspaperTitle = scanner.nextLine();
                    System.out.print("Enter newspaper date: ");
                    String date = scanner.nextLine();
                    library.addItem(new Newspaper(newspaperTitle, date));
                    break;
                case 4:
                    System.out.print("Enter title of item to remove: ");
                    String titleToRemove = scanner.nextLine();
                    library.removeItem(titleToRemove);
                    break;
                case 5:
                    library.displayItems();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }
}