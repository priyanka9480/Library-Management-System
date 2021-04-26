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
import javax.validation.constraints.Min;


/********************************************************************************************************************
 * 
 * @author Priyanka
 * Description:  This entity class is used to create BooksIssued table in the database
 * Version: v1.1
 * Created date: 16 April 2021
 *
 ********************************************************************************************************************/
@Entity
@Table(name="BooksIssued1")
public class BooksIssued {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private int issueId;

	@OneToOne//(cascade=CascadeType.ALL)
	@JoinColumn(name="userid")
	private Users users;
	
	@ManyToOne//(cascade=CascadeType.ALL)
	@JoinColumn(name="book_id")
	private Books books;
	
	private LocalDate issueDate;
	@Min(1)
	private int quantity;
	private LocalDate dueDate;
	
	
	public BooksIssued(int issueId, Users users, Books books, LocalDate issueDate, int quantity, LocalDate dueDate) {
		super();
		this.issueId = issueId;
		this.users = users;
		this.books = books;
		this.issueDate = issueDate;
		this.quantity = quantity;
		this.dueDate = dueDate;
	}
	
	public BooksIssued(int issueId) {
		super();
		this.issueId = issueId;
	}

	public BooksIssued(Users users, Books books, LocalDate issueDate, int quantity, LocalDate dueDate) {
		super();
		this.users = users;
		this.books = books;
		this.issueDate = issueDate;
		this.quantity = quantity;
		this.dueDate = dueDate;
	}

	public BooksIssued() {
		super();
	}
	public int getIssueId() {
		return issueId;
	}
	public void setIssueId(int issueId) {
		this.issueId = issueId;
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
	public LocalDate getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	@Override
	public String toString() {
		return "BooksIssued [issueId=" + issueId + ", users=" +users + ", books=" + books + ", issueDate=" + issueDate
				+ ", quantity=" + quantity + ", dueDate=" + dueDate + "]";
	}
	
	
}
