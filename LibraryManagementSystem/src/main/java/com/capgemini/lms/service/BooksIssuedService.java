package com.capgemini.lms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.lms.entities.BooksIssued;

/********************************************************************************
 * 
 * @author Priyanka
 * Description: This is Service Interface for BooksIssued
 * Version: v1.1
 * Created 20 April 2021
 * 
 ********************************************************************************/
@Service
public interface BooksIssuedService {
	public BooksIssued addIssuedBook(BooksIssued issued);
	public BooksIssued updateIssuedBookDetails(BooksIssued booksIssued);
	public void deleteIssuedBookS(int bookid);
	public List<BooksIssued> viewBooksIssuedList();
}
