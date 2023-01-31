package com.bookLibrary.main;

import java.util.Date;
import java.util.Scanner;

import com.bookLibrary.Book;
import com.bookLibrary.BookLibraryDaoImpl.BookLibraryDaoImpl;
import com.bookLibrary.dao.BookLibraryDao;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter ID to find book:");
		int bookId=sc.nextInt();
		
		BookLibraryDao dao=new BookLibraryDaoImpl();
		
		Book book=dao.getBookInfoById(bookId);
		
		System.out.println(book);
		
		//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		
		System.out.println("Enter Book Details ");
		System.out.println("Enter BookID: ");
		int book_Id=sc.nextInt();
		
		System.out.println("Enter Book name: ");
		String name=sc.next();
		
		System.out.println("Enter Author's name: ");
		String author=sc.next();
		
		System.out.println("Enter Publication: ");
		String publication=sc.next();
		
		System.out.println("Enter Category: ");
		String category=sc.next();
		
		System.out.println("Enter No. of pages: ");
		int pages=sc.nextInt();
		
		System.out.println("Enter price: ");
		int price=sc.nextInt();
		
		Date d = new Date();
		Book book2 =  new Book(bookId, name, author, publication, category, pages, price, d);
		
		System.out.println(dao.createANewBook(book2));
		
		//+++++++++++++++++++++++++++++++++++++++++++++++++++++++
		
		System.out.println("Enter ID to delete book:");
		int bookID=sc.nextInt();
		
		System.out.println(dao.deleteBookById(bookID));
		
		
		//+++++++++++++++++++++++++++++++++++++++
		System.out.println("Enter ID to double book price:");
		int bookId2=sc.nextInt();
		
		System.out.println(dao.updateBookByprice(bookId2));
		
		
	}
}
