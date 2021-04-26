package com.capgemini;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.lms.dao.BooksDao;
import com.capgemini.lms.dao.UsersDao;
import com.capgemini.lms.entities.Books;
import com.capgemini.lms.entities.BooksIssued;
import com.capgemini.lms.entities.Users;
import com.capgemini.lms.exception.BookNotFoundException;
import com.capgemini.lms.exception.SubscriptionExpiredException;
import com.capgemini.lms.service.BooksIssuedService;

/**************************************************************************************************************
 * 
 * @author Priyanka
 * Description:This class is used to test the Books Issued Module
 * @SpringBootTest:Annotation that can be specified on a test class that runs Spring Boot based tests.
 * Version: v1.1
 * Created date: 23 April 2021
 *
 ***************************************************************************************************************/
@SpringBootTest
public class BooksIssuedTests {


	@Autowired
	BooksIssuedService booksIssuedService;
	@Autowired
	UsersDao userDao ;
	@Autowired
	BooksDao booksDao ;

	/***********************************************************************************************************
	 * 
	 * Method: addBookIssuedTest
	 * Description: This method is used to test addIssuedBook method of service class 
	 * Created: 23 April 2021
	 * 
	 **********************************************************************************************************/
	@Test
	void addBookIssuedTest()
	{
		Books book1=booksDao.findById(1).get();
		Users user1=userDao.findById(2).get();
		
		BooksIssued booksIssued=new BooksIssued(user1,book1,LocalDate.of(2009,06,20),1, LocalDate.of(2009,06,20).plusDays(30));
		assertThat(user1.equals(booksIssuedService.addIssuedBook(booksIssued).getUsers()));
				
	}
	/***********************************************************************************************************
	 * 
	 * Method: TestUserName
	 * Description: This method is used to test addIssuedBook method of service class by comparing the user name
	 * Created: 23 April 2021
	 * 
	 ************************************************************************************************************/
	@Test
	void TestUserName()
	{
		Books book1=booksDao.findById(1).get();
		Users user1=userDao.findById(2).get();
		
		BooksIssued booksIssued=new BooksIssued(user1,book1,LocalDate.of(2009,06,20),1, LocalDate.of(2009,06,20).plusDays(30));
		assertEquals("Daniel", booksIssuedService.addIssuedBook(booksIssued).getUsers().getFirstName());
				
	}
	
	/***********************************************************************************************************
	 * 
	 * Method: validateBooks
	 * Description: This validate the Books to Issue the books
	 * Created: 23 April 2021
	 * 
	 ************************************************************************************************************/
	@Test
	void validateBooks() {
		Books book1=new Books(11);
		Users user1=userDao.findById(2).get();
		
		BooksIssued booksIssued1=new BooksIssued(user1,book1,LocalDate.of(2009,06,20),1, LocalDate.of(2009,06,20).plusDays(30));
		assertThrows(BookNotFoundException.class, ()->booksIssuedService.addIssuedBook(booksIssued1));
	}
	
	/***********************************************************************************************************
	 * 
	 * Method: validateSubscriptionExpired
	 * Description: This method is used to validate the subscription before Issuing the Books
	 * Created: 23 April 2021
	 * 
	 ************************************************************************************************************/
	@Test
	void validateSubscriptionExpired() {
		Books book1=new Books("Lord Of The Rings", "Fantacy Fiction", "J R R Tolkien", "Allen & Unwin", 1940, "ISBN0098", 100, 500, "R3_C4");//230
		booksDao.save(book1);
		Users user1=new Users("password1", "firstName1", "lastName1", "9056731452", "e1@gmail.com", LocalDate.of(2009, 10, 1), LocalDate.of(2020, 1, 1), LocalDate.of(2021, 1, 1) , "Exprired");//240
		userDao.save(user1);
		BooksIssued booksIssued=new BooksIssued(user1,book1,LocalDate.of(2009,06,20),1, LocalDate.of(2009,06,20).plusDays(30));
		assertThrows(SubscriptionExpiredException.class, ()->booksIssuedService.addIssuedBook(booksIssued));
	}
	
	/***********************************************************************************************************
	 * 
	 * Method: TestDeleteIssuedBooks
	 * Description: This method is used to test the deleteIssuedBookS method of the service class
	 * Created: 23 April 2021
	 * 
	 ************************************************************************************************************/
	@Test
	void TestDeleteIssuedBooks()
	{
		booksIssuedService.deleteIssuedBookS(253);//250,223,228,238,242
		assertEquals(Optional.empty(),booksDao.findById(154));

	}
	/***********************************************************************************************************
	 * 
	 * Method: validateDeleteThrow
	 * Description: This method is used to test if the deleteIssuedBookS method throws an exception if the book is not present
	 * Created: 23 April 2021
	 * 
	 ************************************************************************************************************/
	@Test
	void validateDeleteThrow()
	{
		assertThrows(BookNotFoundException.class, ()->booksIssuedService.deleteIssuedBookS(150));

	}

}
