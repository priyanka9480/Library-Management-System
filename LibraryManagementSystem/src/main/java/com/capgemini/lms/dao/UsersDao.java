package com.capgemini.lms.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.lms.entities.Users;

/********************************************************************************************************************
 * 
 * @author Priyanka
 * Description: This Interface is a data access object of User which extends JpaRepository
 * @Repository:Indicates that an annotated class is a "Repository".
 * Version: v1.1 
 * Created date: 19 April 2021
 *
 ********************************************************************************************************************/
@Repository
public interface UsersDao extends JpaRepository<Users, Integer> {

	
}
