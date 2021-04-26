package com.capgemini.lms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.lms.entities.BooksReturned;

/********************************************************************************************************************
 * 
 * @author Priyanka
 * Description: This is a data access object of Books Returned
 * @Repository:Indicates that an annotated class is a "Repository".
 * Version: v1.1 
 * Created date: 19 April 2021
 *
 ********************************************************************************************************************/
@Repository
public interface BooksReturnedDao extends JpaRepository<BooksReturned, Integer> {
	List<BooksReturned> findByDelayedDays(int delayedDays);

}
