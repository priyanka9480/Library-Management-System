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
import com.capgemini.lms.entities.BooksReturned;
import com.capgemini.lms.entities.Users;
import com.capgemini.lms.exception.BookNotFoundException;
import com.capgemini.lms.exception.UserNotFoundException;
import com.capgemini.lms.service.BooksReturnedService;

/**************************************************************************************************************
 * 
 * @author Priyanka
 * Description:This class is used to test the Books Returned Module
 * @SpringBootTest:Annotation that can be specified on a test class that runs Spring Boot based tests.
 * Version: v1.1
 * Created date: 23 April 2021
 *
 ***************************************************************************************************************/
@SpringBootTest
public class BooksReturnedTests {

	@Autowired
	BooksReturnedService booksReturnedService;
	@Autowired
	UsersDao userDao ;
	@Autowired
	BooksDao booksDao ;

	/***********************************************************************************************************
	 * 
	 * Method: returnBookTest
	 * Description: This method is used to test returnBooks method of service class 
	 * Created: 23 April 2021
	 * 
	 **********************************************************************************************************/
	@Test
	void returnBookTest()
	{
		Books book1=booksDao.findById(1).get();
		Users user1=userDao.findById(2).get();
		
		BooksReturned booksReturned=new BooksReturned(user1,book1,LocalDate.of(2021,06,20),1,1,"Pending");
		assertThat(user1.equals(booksReturnedService.returnBooks(booksReturned).getUsers()));
				
	}
	/***********************************************************************************************************
	 * 
	 * Method: TestUserName
	 * Description: This method is used to test returnBooks method of service class by comparing the user name
	 * Created: 23 April 2021
	 * 
	 ************************************************************************************************************/
	@Test
	void TestUserName()
	{
		Books book1=booksDao.findById(1).get();
		Users user1=userDao.findById(2).get();
		
		BooksReturned booksReturned=new BooksReturned(user1,book1,LocalDate.of(2021,06,20),1,1,"Pending");
		assertEquals("Daniel", booksReturnedService.returnBooks(booksReturned).getUsers().getFirstName());
				
	}
	
	/***********************************************************************************************************
	 * 
	 * Method: validateBooks
	 * Description: This validate the Books to return the books
	 * Created: 23 April 2021
	 * 
	 ************************************************************************************************************/
	@Test
	void validateBooks() {
		Books book1=new Books(11);
		Users user1=userDao.findById(2).get();
		
		BooksReturned booksReturned=new BooksReturned(user1,book1,LocalDate.of(2021,06,20),1,1,"Pending");
		assertThrows(BookNotFoundException.class, ()->booksReturnedService.returnBooks(booksReturned));
	}
	
	/***********************************************************************************************************
	 * 
	 * Method: TestDeleteReturnedBooks
	 * Description: This method is used to test the deleteReturnedBooks method of the service class
	 * Created: 23 April 2021
	 * 
	 ************************************************************************************************************/
	@Test
	void TestDeleteReturnedBooks()
	{
		booksReturnedService.deleteReturnedBooks(261);//262,265,224,225
		assertEquals(Optional.empty(),booksDao.findById(154));

	}
	/***********************************************************************************************************
	 * 
	 * Method: validateDeleteThrow
	 * Description: This method is used to test if the deleteReturnedBooks method throws an exception if the book is not present
	 * Created: 23 April 2021
	 * 
	 ************************************************************************************************************/
	@Test
	void validateDeleteThrow()
	{
		assertThrows(BookNotFoundException.class, ()->booksReturnedService.deleteReturnedBooks(241));

	}
}
