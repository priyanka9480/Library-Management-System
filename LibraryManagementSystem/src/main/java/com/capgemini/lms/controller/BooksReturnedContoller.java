package com.capgemini.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.lms.entities.BooksReturned;
import com.capgemini.lms.exception.BookNotFoundException;
import com.capgemini.lms.exception.SubscriptionExpiredException;
import com.capgemini.lms.exception.UserNotFoundException;
import com.capgemini.lms.service.BooksReturnedService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/********************************************************************************
 * @author Priyanka
 * Description: This class is used to add,update, get and delete Returned Books
 * Version: v1.1
 * Created 21 April 2021
 *
 ********************************************************************************/
@Api("Book Returned Controller")
@RestController
@RequestMapping(value = "/BooksReturned")
public class BooksReturnedContoller {
	@Autowired
	BooksReturnedService booksReturnedService;

	/********************************************************************************
	 * 
	 * Method : viewReturnedBooks
	 * Description: method used for viewing Returned books list
	 * @return List<BooksReturned>
	 * @GetMapping Annotation for mapping HTTP GET requests to view Returned books
	 * @Created date: 21 April 2021
	 * 
	 *  
	 *********************************************************************************/
	@ApiOperation(value = "View Returned Books")
	@GetMapping(value = "/viewReturnedBooks")
	public List<BooksReturned> viewReturnedBooks() {
		return booksReturnedService.viewReturnedBooksList();
	}

	/********************************************************************************
	 * 
	 * Method : updateBooksReturned
	 * Description: method used for updating Returned Books details
	 * @param returnedBooks
	 * @throws UserNotFoundException
	 * @throws BookNotFoundException
	 * @return ResponseEntity<String>
	 * @PutMapping: Annotation for mapping HTTP PUT requests to update returned books
	 * @Created date: 21 April 2021
	 * 
	 *  
	 *********************************************************************************/
	@PutMapping(value = "/updateBooksReturned")
	public ResponseEntity<String> updateBooksReturned(@RequestBody BooksReturned booksReturned) {
		try {
			booksReturnedService.updateReturnedBookDetails(booksReturned);
			return new ResponseEntity<>("Updated BooksReturned successfully", HttpStatus.OK);
		} catch (BookNotFoundException e) {
			throw new BookNotFoundException("Enter Valid Book ID");
		} catch (UserNotFoundException e) {
			throw new BookNotFoundException("Enter Valid User ID");
		}
	}

	/********************************************************************************
	 * 
	 * Method : insertBooksReturned
	 * Description: method used for Returning Books
	 * @param booksReturned
	 * @throws UserNotFoundException
	 * @throws BookNotFoundException
	 * @return ResponseEntity<String>
	 * @PostMapping Annotation for mapping HTTP POST requests to insert Returned books
	 * @Created date: 21 April 2021
	 * 
	 *  
	 *********************************************************************************/
	@PostMapping(value = "/insertBooksReturned")
	public ResponseEntity<String> insertBooksReturned(@RequestBody BooksReturned booksReturned) {
		try {
			booksReturnedService.returnBooks(booksReturned);
			return new ResponseEntity<>("Inserted BooksReturned successfully", HttpStatus.OK);
		} catch (BookNotFoundException e) {
			throw new BookNotFoundException("Enter Valid Book ID");
		} catch (UserNotFoundException e) {
			throw new BookNotFoundException("Enter Valid User ID");
		}

	}

	/********************************************************************************
	 * 
	 * Method : viewDelayedBooksList
	 * DEscription: method used for viewing Returned books list
	 * @param 
	 * @return List<BooksReturned>
	 * @GetMapping : Annotation for mapping HTTP GET requests to view Delayed books list
	 * @Created date: 21 April 2021
	 * 
	 *  
	 *********************************************************************************/
	@GetMapping(value = "/viewDelayedBooksList/{delayedDays}")
	public List<BooksReturned> viewDelayedBooksList(@PathVariable int delayedDays) {
		return booksReturnedService.viewDelayedBooksList(delayedDays);
	}

	/********************************************************************************
	 * 
	 * Method : deleteReturnedBook
	 * Description: method used for deleting Returned Books
	 * @param bookId
	 * @throws BookNotFoundException
	 * @return ResponseEntity<String>
	 * @PostMapping Annotation for mapping HTTP DELETE requests to delete Returned books details
	 * @Created date: 21 April 2021
	 * 
	 *  
	 *********************************************************************************/
	@DeleteMapping(value = "/deleteById/{bookId}")
	public ResponseEntity<String> deleteReturnedBook(@PathVariable int bookId) {
		try {
			booksReturnedService.deleteReturnedBooks(bookId);
			;
			return new ResponseEntity<String>("Deleted", HttpStatus.OK);
		} catch (BookNotFoundException e) {
			throw new BookNotFoundException("Id not found to delete");
		}
	}
}
