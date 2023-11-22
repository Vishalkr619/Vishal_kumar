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
public class Payment {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	private String Date;
	private String Invoice;
	private String Amount;
	private String Client;
	private String Project;
	private String Method;
	
	/////////////////////////////////////////////////////////////
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getInvoice() {
		return Invoice;
	}
	public void setInvoice(String invoice) {
		Invoice = invoice;
	}
	public String getAmount() {
		return Amount;
	}
	public void setAmount(String amount) {
		Amount = amount;
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
	public String getMethod() {
		return Method;
	}
	public void setMethod(String method) {
		Method = method;
	}
	
	/////////////////////////////////////////////////////////////

	public Payment(int id, String date, String invoice, String amount, String client, String project, String method) {
		super();
		Id = id;
		Date = date;
		Invoice = invoice;
		Amount = amount;
		Client = client;
		Project = project;
		Method = method;
	}
	
	/////////////////////////////////////////////////////////////

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
