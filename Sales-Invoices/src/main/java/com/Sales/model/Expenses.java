package com.Sales.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@DynamicInsert
@DynamicUpdate
public class Expenses {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	private String Date;
	private String Description;
	private String User;
	private String Client;
	private String Project;
	private String Amount;
	private String Status;
	
	/////////////////////////////////////////////////////////////

	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getUser() {
		return User;
	}
	public void setUser(String user) {
		User = user;
	}
	public String getClient() {
		return Client;
	}
	public void setClient(String client) {
		Client = client;
	}
	public String getProject() {
		return Project;
	}
	public void setProject(String project) {
		Project = project;
	}
	public String getAmount() {
		return Amount;
	}
	public void setAmount(String amount) {
		Amount = amount;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	
	
	/////////////////////////////////////////////////////////////

	public Expenses(int id, String date, String description, String user, String client, String project, String amount,
			String status) {
		super();
		Id = id;
		Date = date;
		Description = description;
		User = user;
		Client = client;
		Project = project;
		Amount = amount;
		Status = status;
	}
	
	
	/////////////////////////////////////////////////////////////

	public Expenses() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
