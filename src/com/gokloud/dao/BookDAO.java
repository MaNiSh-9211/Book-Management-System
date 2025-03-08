package com.gokloud.dao;

import java.util.List;

public interface BookDAO {
	public void insertBook(List<Book> blist);
	public void deleteBook(int id);
	public void updateBook(Book b);
	public List<Book> retreiveBook();
	

}

