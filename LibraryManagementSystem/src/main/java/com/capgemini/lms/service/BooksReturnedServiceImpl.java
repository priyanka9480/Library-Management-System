package com.capgemini.lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.lms.dao.BooksDao;
import com.capgemini.lms.dao.BooksReturnedDao;
import com.capgemini.lms.dao.UsersDao;
import com.capgemini.lms.entities.Books;
import com.capgemini.lms.entities.BooksReturned;
import com.capgemini.lms.entities.Users;
import com.capgemini.lms.exception.BookNotFoundException;
import com.capgemini.lms.exception.UserNotFoundException;

/********************************************************************************
 * 
 * @author Priyanka
 * Description: This class is used to create Service Implementation for BooksReturned
 * Version: v1.1
 * Created 20 April 2021
 * 
 ********************************************************************************/
@Service
public class BooksReturnedServiceImpl implements BooksReturnedService {
	
	@Autowired
	BooksReturnedDao booksReturnedDao;
	@Autowired
	BooksDao booksDao;
	@Autowired
	UsersDao usersDao;

	/********************************************************************************
	 * 
	 * Method: returnBooks
	 * Description: This method is used to return Books 
	 * @param returned
	 * @throws BookNotFoundException
	 * @throws UserNotFoundException
	 * @return BooksReturned
	 * Created: 20 April 2021
	 * 
	 ********************************************************************************/
	@Override
	public BooksReturned returnBooks(BooksReturned returned) {
		Optional<Books> book=booksDao.findById(returned.getBooks().getBookid());
		Optional<Users> user=usersDao.findById(returned.getUsers().getUserid());
		
		if(!book.isPresent())
			throw new BookNotFoundException();
		else if(!user.isPresent())
			throw new UserNotFoundException();
		else
			return booksReturnedDao.save(returned);
	}

	/********************************************************************************
	 * 
	 * Method: updateReturnedBookDetails
	 * Description: This method is used to update returned books details
	 * @param booksReturned
	 * @throws BookNotFoundException
	 * @throws UserNotFoundException
	 * @return BooksReturned
	 * Created: 20 April 2021
	 * 
	 ********************************************************************************/
	@Override
	public BooksReturned updateReturnedBookDetails(BooksReturned booksReturned) {
	
		Optional<Books> book=booksDao.findById(booksReturned.getBooks().getBookid());
		Optional<Users> user=usersDao.findById(booksReturned.getUsers().getUserid());
		
		if(!book.isPresent())
			throw new BookNotFoundException();
		else if(!user.isPresent())
			throw new UserNotFoundException();
		else
			return booksReturnedDao.save(booksReturned);
	}

	/********************************************************************************
	 * 
	 * Method: viewReturnedBooksList
	 * Description: To view list of Returned books details present in the database
	 * @return List<BooksReturned>
	 * Created: 20 April 2021
	 * 
	 ********************************************************************************/
	@Override
	public List<BooksReturned> viewReturnedBooksList() {
		return booksReturnedDao.findAll();
	}

	/********************************************************************************
	 * 
	 * Method: viewDelayedBooksList
	 * Description: This method is used view the Delayed Books List
	 * @param delayed_Days
	 * @return List<BooksReturned>
	 * Created: 20 April 2021
	 * 
	 ********************************************************************************/
	@Override
	public List<BooksReturned> viewDelayedBooksList(int delayed_Days) {
		return booksReturnedDao.findByDelayedDays(delayed_Days);
	}

	/********************************************************************************
	 * 
	 * Method: deleteReturnedBooks
	 * Description: This method is used to delete the returned books details
	 * @param bookid
	 * @throws BookNotFoundException
	 * @return void
	 * Created: 20 April 2021
	 * 
	 ********************************************************************************/
	@Override
	public void deleteReturnedBooks(int bookid) {
		if(booksReturnedDao.existsById(bookid))
			 booksReturnedDao.deleteById(bookid);
			else throw new BookNotFoundException();
		
	}

}
