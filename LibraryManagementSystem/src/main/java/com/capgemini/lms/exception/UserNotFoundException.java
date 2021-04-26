package com.capgemini.lms.exception;


/*********************************************************************************
 * 
 * @author Priyanka
 * Description: This class is used for handling UserNotFoundException
 * Version: v1.1
 * Created date: 22 April 2021
 *
 **********************************************************************************/
public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException() {

	}

	public UserNotFoundException(String msg) {
		super(msg);
	}

}
