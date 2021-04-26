package com.capgemini.lms.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.lms.dao.BooksDao;
import com.capgemini.lms.dao.BooksIssuedDao;
import com.capgemini.lms.dao.UsersDao;
import com.capgemini.lms.entities.Books;
import com.capgemini.lms.entities.BooksIssued;
import com.capgemini.lms.entities.Users;
import com.capgemini.lms.exception.BookNotFoundException;
import com.capgemini.lms.exception.SubscriptionExpiredException;
import com.capgemini.lms.exception.UserNotFoundException;

/********************************************************************************
 * 
 * @author Priyanka
 * Description: This class is used to create Service Implementation for BooksIssued
 * Version: v1.1
 * Created 20 April 2021
 * 
 ********************************************************************************/
@Service
public class BooksIssuedServiceImpl implements BooksIssuedService {
	
	@Autowired
	BooksIssuedDao booksIssuedDao;
	@Autowired
	BooksDao booksDao;
	@Autowired
	UsersDao usersDao;

	/********************************************************************************
	 * 
	 * Method: addIssuedBook
	 * Description: This method is used to Issue Books 
	 * @param issued
	 * @throws BookNotFoundException
	 * @throws UserNotFoundException
	 * @return BooksIssued
	 * Created: 20 April 2021
	 * 
	 ********************************************************************************/
	@Override
	public BooksIssued addIssuedBook(BooksIssued issued) {
		
		Optional<Books> book=booksDao.findById(issued.getBooks().getBookid());
		Optional<Users> user=usersDao.findById(issued.getUsers().getUserid());
		
		if(!user.isPresent())
			throw new UserNotFoundException();
		else if(user.get().getSub_expire_date().isBefore(LocalDate.now()))
			throw new SubscriptionExpiredException();
		else if (!book.isPresent())
			throw new BookNotFoundException();
		else
			return booksIssuedDao.save(issued);
			
	}


	/********************************************************************************
	 * 
	 * Method: updateIssuedBookDetails
	 * Description: This method is used to update issued books details
	 * @param booksIssued
	 * @throws BookNotFoundException
	 * @throws UserNotFoundException
	 * @return BooksIssued
	 * Created: 20 April 2021
	 * 
	 ********************************************************************************/
	@Override
	public BooksIssued updateIssuedBookDetails(BooksIssued booksIssued) {
		Optional<Books> book=booksDao.findById(booksIssued.getBooks().getBookid());
		Optional<Users> user=usersDao.findById(booksIssued.getUsers().getUserid());
		
		if(!book.isPresent())
			throw new BookNotFoundException();
		else if(!user.isPresent())
			throw new UserNotFoundException();
		else
			return booksIssuedDao.save(booksIssued);
	}
	
	/********************************************************************************
	 * 
	 * Method: viewBooksIssuedList
	 * Description: To view list of Issued books details present in the database
	 * @return List<BooksIssued>
	 * Created: 20 April 2021
	 * 
	 ********************************************************************************/

	@Override
	public List<BooksIssued> viewBooksIssuedList() {
		return booksIssuedDao.findAll();
	}
	
	/********************************************************************************
	 * 
	 * Method: deleteIssuedBookS
	 * Description: This method is used to delete the Issued books details
	 * @param bookid
	 * @throws BookNotFoundException
	 * @return void
	 * Created: 20 April 2021
	 * 
	 ********************************************************************************/
	@Override
	public void deleteIssuedBookS(int bookid) {
		if(booksIssuedDao.existsById(bookid))
		 booksIssuedDao.deleteById(bookid);
		else throw new BookNotFoundException();
	}

	

}
