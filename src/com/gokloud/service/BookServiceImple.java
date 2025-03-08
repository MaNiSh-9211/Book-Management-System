package com.gokloud.service;

import java.util.*;

import com.gokloud.dao.Book;
import com.gokloud.dao.BookDAOImpl;

public class BookServiceImple implements BookService {
    private Scanner sc;
    private List<Book> booklist;
    private BookDAOImpl bookdao;

    public BookServiceImple() {
        sc = new Scanner(System.in);
        booklist = new ArrayList<>();
        bookdao = new BookDAOImpl();
    }

    @Override
    public void insertBook() {
        System.out.println("Enter the number of books you want to add:");
        int noofbooks = sc.nextInt();
        for (int x = 1; x <= noofbooks; x++) {
            Book b = new Book();
            System.out.println("Enter book ID:");
            b.setBookcode(sc.nextInt());
            System.out.println("Enter book name:");
            sc.nextLine(); // Consume the newline
            b.setBookname(sc.nextLine());
            System.out.println("Enter price:");
            b.setPrice(sc.nextDouble());
            System.out.println("Enter Author name:");
            sc.nextLine(); // Consume the newline
            b.setAuthorName(sc.nextLine());
            booklist.add(b);
        }
        bookdao.insertBook(booklist);
    }

    @Override
    public void deleteBook() {
        System.out.println("Enter book ID to delete:");
        int bookId = sc.nextInt();
        bookdao.deleteBook(bookId);
    }

    @Override
    public void updateBook() {
        System.out.println("Enter book ID to update:");
        int bookId = sc.nextInt();
        Book b = new Book();
        b.setBookcode(bookId);
        System.out.println("Enter new book name:");
        sc.nextLine(); // Consume the newline
        b.setBookname(sc.nextLine());
        System.out.println("Enter new price:");
        b.setPrice(sc.nextDouble());
        System.out.println("Enter new Author name:");
        sc.nextLine(); // Consume the newline
        b.setAuthorName(sc.nextLine());
        bookdao.updateBook(b);
    }

    @Override
    public void retreiveData() {
        List<Book> books = bookdao.retreiveBook();
        if (books.isEmpty()) {
            System.out.println("No books found.");
        } else {
            System.out.println("Book List:");
            for (Book b : books) {
                System.out.println("Book ID: " + b.getBookcode());
                System.out.println("Book Name: " + b.getBookname());
                System.out.println("Price: " + b.getPrice());
                System.out.println("Author Name: " + b.getAuthorName());
                System.out.println("----------------------");
            }
        }
    }
}
