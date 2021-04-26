package com.capgemini.lms.exception;

import java.util.ArrayList;
import java.util.List;

/*********************************************************************************
 * 
 * @author Priyanka
 * Description: This class is used for handling ValidationException
 * Version: v1.1
 * Created date: 22 April 2021
 *
 **********************************************************************************/
public class ValidationException extends RuntimeException {
	
	List<String> messages =new ArrayList<String>();

	public ValidationException() {
		super();
	}

	public ValidationException(List<String> messages) {
		super();
		this.messages = messages;
	}
	
	public List<String> getMessages(){
		return messages;
	}
	

}