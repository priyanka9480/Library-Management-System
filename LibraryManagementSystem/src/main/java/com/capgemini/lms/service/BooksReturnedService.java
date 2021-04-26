package com.capgemini.lms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.lms.entities.BooksReturned;

/********************************************************************************
 * 
 * @author Priyanka
 * Description: This Service Interface for BooksReturned
 * Version: v1.1
 * Created 20 April 2021
 * 
 ********************************************************************************/
@Service
public interface BooksReturnedService{
	public BooksReturned returnBooks(BooksReturned returned);
	public BooksReturned updateReturnedBookDetails(BooksReturned booksReturned);
	public List<BooksReturned> viewReturnedBooksList();
	public List<BooksReturned> viewDelayedBooksList(int delayed_Days);
	public void deleteReturnedBooks(int bookid);
	
	
}
