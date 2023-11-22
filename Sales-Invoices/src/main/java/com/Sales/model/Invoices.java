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

public class Invoices {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	private String Date;
	private String CompanyName;
	private String Project;
	private String Amount;
	private String Payments;
	private String Status;
	
	
	///////////////////////////////////////////////////////////////////////////////
	
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
	public String getCompanyName() {
		return CompanyName;
	}
	public void setCompanyName(String companyName) {
		CompanyName = companyName;
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
	public String getPayments() {
		return Payments;
	}
	public void setPayments(String payments) {
		Payments = payments;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	
	///////////////////////////////////////////////////////////////////////////////
	
	public Invoices(int id, String date, String companyName, String project, String amount, String payments,
			String status) {
		super();
		Id = id;
		Date = date;
		CompanyName = companyName;
		Project = project;
		Amount = amount;
		Payments = payments;
		Status = status;
	}
	
	///////////////////////////////////////////////////////////////////////////////
	
	public Invoices() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
