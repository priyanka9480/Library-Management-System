package com.capgemini.lms.exception;


/*********************************************************************************
 * 
 * @author Priyanka
 * Description: This class is used for handling SubscriptionExpiredException
 * Version: v1.1
 * Created date: 22 April 2021
 *
 **********************************************************************************/
public class SubscriptionExpiredException extends RuntimeException{
	

	public SubscriptionExpiredException() {
		
	}
	
	public SubscriptionExpiredException(String msg) {
		super(msg);
	}
}
