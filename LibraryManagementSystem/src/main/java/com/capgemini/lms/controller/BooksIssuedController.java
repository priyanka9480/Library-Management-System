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


import com.capgemini.lms.entities.BooksIssued;
import com.capgemini.lms.exception.BookNotFoundException;
import com.capgemini.lms.exception.SubscriptionExpiredException;
import com.capgemini.lms.exception.UserNotFoundException;
import com.capgemini.lms.service.BooksIssuedService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/************************************************************************************************* 
 * 
 * @author Priyanka
 * Description: This class is used for controller where we can add, update, view and delete Issued Books
 * Version: v1.1
 * Created date: 21 April 2021
 * 
 **************************************************************************************************/
@Api("Book Issued Controller")
@RestController
@RequestMapping(value = "/BooksIssued")
public class BooksIssuedController {

	@Autowired
	BooksIssuedService booksIssuedService;

	/********************************************************************************
	 * 
	 * Method : insertBooksIssued
	 * DEscription: method used for Issuing new Books
	 * @param booksIssued
	 * @throws UserNotFoundException
	 * @throws SubscriptionExpiredException
	 * @throws BookNotFoundException
	 * @return ResponseEntity<String>
	 * @PostMapping Annotation for mapping HTTP POST requests onto insert issued books
	 * @Created date: 21 April 2021
	 * 
	 *  
	 *********************************************************************************/
	@ApiOperation(value = "Issue Books")
	@PostMapping(value = "/insertBooksissued")
	public ResponseEntity<String> insertBooksIssued(@RequestBody BooksIssued booksIssued) {

		try {
			booksIssuedService.addIssuedBook(booksIssued);
			return new ResponseEntity<>("Inserted BooksIssued successfully", HttpStatus.OK);
		} catch (UserNotFoundException e) {
			throw new BookNotFoundException("Enter Valid User ID");
		} catch (SubscriptionExpiredException e) {
			throw new SubscriptionExpiredException("Subscription Expired_Cannot Issue Books");
		} catch (BookNotFoundException e) {
			throw new BookNotFoundException("Enter Valid Book ID");
		}

	}

	/********************************************************************************
	 * 
	 * Method : updateBooksIssued
	 * DEscription: method used for updating Issued Books details
	 * @param issuedBooks
	 * @throws UserNotFoundException
	 * @throws SubscriptionExpiredException
	 * @throws BookNotFoundException
	 * @return ResponseEntity<String>
	 * @PutMapping Annotation for mapping HTTP PUT requests onto update issued books
	 * @Created date: 21 April 2021
	 * 
	 *  
	 *********************************************************************************/
	@ApiOperation(value = "Update Issued Books")
	@PutMapping(value = "/updateBooksIssued")
	public ResponseEntity<String> updateBooksIssued(@RequestBody BooksIssued booksIssued) {
		try {
			booksIssuedService.updateIssuedBookDetails(booksIssued);
			return new ResponseEntity<>("Updated BooksIssued successfully", HttpStatus.OK);
		} catch (BookNotFoundException e) {
			throw new BookNotFoundException("Enter Valid Book ID");
		} catch (UserNotFoundException e) {
			throw new BookNotFoundException("Enter Valid User ID");
		}

	}

	/********************************************************************************
	 * 
	 * Method : ViewIssuedBooks
	 * DEscription: method used for viewing Issued books list
	 * @param 
	 * @return List<BooksIssued>
	 * @GetMapping Annotation for mapping HTTP GET requests to view Issued books
	 * @Created date: 21 April 2021
	 * 
	 *  
	 *********************************************************************************/
	
	@ApiOperation(value = "View Issued Books")
	@GetMapping(value = "/ViewIssuedBooks")
	public List<BooksIssued> getAllBooksIssued() {
		return booksIssuedService.viewBooksIssuedList();
	}

	
	/********************************************************************************
	 * 
	 * Method : deleteIssuedBook
	 * Description: method used for deleting Issued Books
	 * @param bookId
	 * @throws BookNotFoundException
	 * @return ResponseEntity<String>
	 * @PostMapping Annotation for mapping HTTP DELETE requests onto delete suggested books
	 * @Created date: 21 April 2021
	 * 
	 *  
	 *********************************************************************************/
	@DeleteMapping(value = "/deleteById/{bookId}")
	public ResponseEntity<String> deleteIssuedBook(@PathVariable int bookId) {
		try {
			booksIssuedService.deleteIssuedBookS(bookId);
			return new ResponseEntity<String>("Deleted", HttpStatus.OK);
		} catch (BookNotFoundException e) {
			throw new BookNotFoundException("Id not found to delete");
		}
	}

}