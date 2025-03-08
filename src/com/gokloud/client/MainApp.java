package com.gokloud.client;

import com.gokloud.service.BookService;
import com.gokloud.service.BookServiceImple;
import java.util.Scanner;

public class MainApp {
    private final BookService bookService;
    private final Scanner scanner;

    public MainApp() {
        bookService = new BookServiceImple();
        scanner = new Scanner(System.in);
    }

    public void showMenu() {
        while (true) {
            System.out.println("\n===== Book Management System =====");
            System.out.println("1. Insert Book");
            System.out.println("2. Delete Book");
            System.out.println("3. Update Book");
            System.out.println("4. Retrieve Books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    bookService.insertBook();
                    break;
                case 2:
                    bookService.deleteBook();
                    break;
                case 3:
                    bookService.updateBook();
                    break;
                case 4:
                    bookService.retreiveData();
                    break;
                case 5:
                    System.out.println("Exiting... Thank you!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
