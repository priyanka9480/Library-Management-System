package com.capgemini.lms.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


/**************************************************************************************************************
 * 
 * @author Priyanka
 * Description: This entity class is used to create Users table in the Oracle database
 * Version: v1.1
 * Created date: 16 April 2021
 *
 ***************************************************************************************************************/
@Entity
@Table(name="Users1")
public class Users {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private int userid;
	private String password;
	
	@NotEmpty(message = "FirstName should not be empty")
	private String firstName;
	
	@NotEmpty(message = "LastName should not be empty")
	private String lastName;
	
	@Size(min = 10, max = 10, message = "Mobile number should be 10 characters long")
	private String mobileno;
	
	@Email(message = "Email must be in a valid format")
	private String email;
	private LocalDate date_of_birth;
	private LocalDate subscription_date;
	private LocalDate sub_expire_date;
	private String subscription_status;
	public Users(String password, String firstName, String lastName, String mobileno, String email,
			LocalDate date_of_birth, LocalDate subscription_date, LocalDate sub_expire_date, String subscription_status) {
		super();
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileno = mobileno;
		this.email = email;
		this.date_of_birth = date_of_birth;
		this.subscription_date = subscription_date;
		this.sub_expire_date = sub_expire_date;
		this.subscription_status = subscription_status;
	}
	
	public Users() {
		super();
	}

	public Users(int userid) {
		super();
		this.userid = userid;
	}

	public Users(int userid, String password, String firstName, String lastName, String mobileno, String email,
			LocalDate date_of_birth, LocalDate subscription_date, LocalDate sub_expire_date,
			String subscription_status) {
		super();
		this.userid = userid;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileno = mobileno;
		this.email = email;
		this.date_of_birth = date_of_birth;
		this.subscription_date = subscription_date;
		this.sub_expire_date = sub_expire_date;
		this.subscription_status = subscription_status;
	}

	@Override
	public String toString() {
		return "Users [userid=" + userid + ", password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", mobileno=" + mobileno + ", email=" + email + ", date_of_birth=" + date_of_birth
				+ ", subscription_date=" + subscription_date + ", sub_expire_date=" + sub_expire_date
				+ ", subscription_status=" + subscription_status + "]";
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(LocalDate date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public LocalDate getSubscription_date() {
		return subscription_date;
	}
	public void setSubscription_date(LocalDate subscription_date) {
		this.subscription_date = subscription_date;
	}
	public LocalDate getSub_expire_date() {
		return sub_expire_date;
	}
	public void setSub_expire_date(LocalDate sub_expire_date) {
		this.sub_expire_date = sub_expire_date;
	}
	public String getSubscription_status() {
		return subscription_status;
	}
	public void setSubscription_status(String subscription_status) {
		this.subscription_status = subscription_status;
	}
	
	
}
