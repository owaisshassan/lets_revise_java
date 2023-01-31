package com.bookLibrary.dao;

import com.bookLibrary.Book;

public interface BookLibraryDao {
	
	public Book getBookInfoById(int bookId);
	public String createANewBook(Book book);
	public String deleteBookById(int bookId);
	public Book updateBookByprice(int bookId);

}
