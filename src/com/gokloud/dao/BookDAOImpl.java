package com.gokloud.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.gokloud.connect.DataConnect;

public class BookDAOImpl implements BookDAO {
    Connection con1;
    PreparedStatement stat;

    public BookDAOImpl() {
        con1 = DataConnect.connect();
    }

    @Override
    public void insertBook(List<Book> blist) {
        try {
            stat = con1.prepareStatement("INSERT INTO books (bookcode, bookname, price, author) VALUES(?,?,?,?)");
            for (Book b : blist) {
                stat.setInt(1, b.getBookcode());
                stat.setString(2, b.getBookname());
                stat.setDouble(3, b.getPrice());
                stat.setString(4, b.getAuthorName());
                int res = stat.executeUpdate();
                if (res > 0) {
                    System.out.println("Data inserted");
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error inserting book: " + ex.getMessage());
        }
    }

    @Override
    public void deleteBook(int id) {
        try {
            stat = con1.prepareStatement("DELETE FROM books WHERE bookcode = ?");
            stat.setInt(1, id);
            int res = stat.executeUpdate();
            if (res > 0) {
                System.out.println("Book deleted successfully.");
            } else {
                System.out.println("Book not found.");
            }
        } catch (SQLException ex) {
            System.out.println("Error deleting book: " + ex.getMessage());
        }
    }

    @Override
    public void updateBook(Book b) {
        try {
            stat = con1.prepareStatement("UPDATE books SET bookname=?, price=?, author=? WHERE bookcode=?");
            stat.setString(1, b.getBookname());
            stat.setDouble(2, b.getPrice());
            stat.setString(3, b.getAuthorName());
            stat.setInt(4, b.getBookcode());
            int res = stat.executeUpdate();
            if (res > 0) {
                System.out.println("Book updated successfully.");
            } else {
                System.out.println("Book not found.");
            }
        } catch (SQLException ex) {
            System.out.println("Error updating book: " + ex.getMessage());
        }
    }

    @Override
    public List<Book> retreiveBook() {
        List<Book> bookList = new ArrayList<>();
        try {
            stat = con1.prepareStatement("SELECT * FROM books");
            ResultSet rs = stat.executeQuery();
            while (rs.next()) {
                Book b = new Book();
                b.setBookcode(rs.getInt("bookcode"));
                b.setBookname(rs.getString("bookname"));
                b.setPrice(rs.getDouble("price"));
                b.setAuthorName(rs.getString("author")); // Fixed incorrect column name
                bookList.add(b);
            }
        } catch (SQLException ex) {
            System.out.println("Error retrieving books: " + ex.getMessage());
        }
        return bookList;
    }
}
