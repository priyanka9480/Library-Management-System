package com.capgemini.lms.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**************************************************************************************************************
 * 
 * @author Priyanka
 * Description:This entity class is used to create BooksReturned table in the Oracle database
 * Version: v1.1
 * Created date: 16 April 2021
 *
 ***************************************************************************************************************/
@Entity
@Table(name="BooksReturned1")
public class BooksReturned {
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private int id;
	
	@OneToOne//(cascade=CascadeType.ALL)
	@JoinColumn(name="userid")
	private Users users;
	
	@ManyToOne//(cascade=CascadeType.ALL)
	@JoinColumn(name="bookid")
	private Books books;
	
	private LocalDate returnedDate;
	private int delayedDays;
	private double penalty;
	private String penalty_Status;
	
	
	public BooksReturned(int id, Users users, Books books, LocalDate returnedDate, int delayedDays, double penalty,
			String penalty_Status) {
		super();
		this.id = id;
		this.users = users;
		this.books = books;
		this.returnedDate = returnedDate;
		this.delayedDays = delayedDays;
		this.penalty = penalty;
		this.penalty_Status = penalty_Status;
	}
	
	
	public BooksReturned(Users users, Books books, LocalDate returnedDate, int delayedDays, double penalty,
			String penalty_Status) {
		super();
		this.users = users;
		this.books = books;
		this.returnedDate = returnedDate;
		this.delayedDays = delayedDays;
		this.penalty = penalty;
		this.penalty_Status = penalty_Status;
	}


	public BooksReturned() {
		super();
	}
	@Override
	public String toString() {
		return "BooksReturned [id=" + id + ", users=" + users + ", books=" + books + ", returnedDate=" + returnedDate
				+ ", delayedDays=" + delayedDays + ", penalty=" + penalty + ", penalty_Status=" + penalty_Status
				+ "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public Books getBooks() {
		return books;
	}
	public void setBooks(Books books) {
		this.books = books;
	}
	public LocalDate getReturnedDate() {
		return returnedDate;
	}
	public void setReturnedDate(LocalDate returnedDate) {
		this.returnedDate = returnedDate;
	}
	public int getDelayed_Days() {
		return delayedDays;
	}
	public void setDelayed_Days(int delayed_Days) {
		this.delayedDays = delayed_Days;
	}
	public double getPenalty() {
		return penalty;
	}
	public void setPenalty(double penalty) {
		this.penalty = penalty;
	}
	public String getPenalty_Status() {
		return penalty_Status;
	}
	public void setPenalty_Status(String penalty_Status) {
		this.penalty_Status = penalty_Status;
	}
	
}
