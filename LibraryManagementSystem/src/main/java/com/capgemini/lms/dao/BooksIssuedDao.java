package com.capgemini.lms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.capgemini.lms.entities.BooksIssued;

/********************************************************************************************************************
 * 
 * @author Priyanka 
 * Description:  This is a data access object of Books Issued
 * @Repository:Indicates that an annotated class is a "Repository".
 * Version: v1.1
 * Created date: 19 April 2021
 *
 ********************************************************************************************************************/
@Repository
public interface BooksIssuedDao extends JpaRepository<BooksIssued, Integer> {

}
