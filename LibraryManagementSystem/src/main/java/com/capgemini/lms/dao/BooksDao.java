package com.capgemini.lms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.lms.entities.Books;
import com.capgemini.lms.exception.BookNotFoundException;


/********************************************************************************************************************
 * 
 * @author Priyanka
 * Description: This Interface is a data access object of Books which extends JpaRepository
 * @Repository:Indicates that an annotated class is a "Repository".
 * Version: v1.1 
 * Created date: 19 April 2021
 *
 ********************************************************************************************************************/
@Repository
public interface BooksDao extends JpaRepository<Books, Integer> {

	List<Books> searchBookByTitle(String keyword) throws BookNotFoundException;
	List<Books> searchBookBySubject(String keyword) throws BookNotFoundException;
}