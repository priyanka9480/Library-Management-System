package com.capgemini.lms.exception;

/*********************************************************************************
 * 
 * @author Priyanka
 * Description: This class is used for handling AddressNotFoundException
 * Version: v1.1
 * Created date: 22 April 2021
 *
 **********************************************************************************/
public class AddressNotFoundException extends RuntimeException {

	public AddressNotFoundException() {
	}

	public AddressNotFoundException(String message) {

		super(message);
	}
}
