package com.bookLibrary.BookLibraryDaoImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bookLibrary.Book;
import com.bookLibrary.dao.BookLibraryDao;

public class BookLibraryDaoImpl implements BookLibraryDao{

	@Override
	public Book getBookInfoById(int bookId) {	
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("BookLibraryUnit");
		
		EntityManager em = emf.createEntityManager();
		
		Book book=em.find(Book.class,bookId);
		
		return book;
	}

	@Override
	public String createANewBook(Book book) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("BookLibraryUnit");
		
		EntityManager em = emf.createEntityManager();
		
		Book b=em.find(Book.class,book.getBookId());
		if(b != null)
			return "Book Alreay present with this ID";
		else {
		
			em.getTransaction().begin();
			em.persist(book);
			em.getTransaction().commit();
			
			return "Book Created Successfully";
		}
			
	}

	@Override
	public String deleteBookById(int bookId) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("BookLibraryUnit");
		
		EntityManager em = emf.createEntityManager();
		
		Book book=em.find(Book.class,bookId);
		
		if(book == null)
			return "Book not present with this ID";
		else {
			em.getTransaction().begin();
			em.remove(book);
			em.getTransaction().commit();
			
			return "Book deleted successfully";
		}
	}

	@Override
	public Book updateBookByprice(int bookId) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("BookLibraryUnit");
		
		EntityManager em = emf.createEntityManager();
		
		Book book=em.find(Book.class,bookId);
		
		if(book == null)
			System.out.println("Book not present with this ID");
		else {
			em.getTransaction().begin();
			book.setPrice(book.getPrice()*2);
			em.getTransaction().commit();
		
		}
		return book;
	}

}
