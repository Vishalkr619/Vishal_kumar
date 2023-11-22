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
public class Estimates {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	private String Date;
	private String CompanyName;
	private String CreatedBy;
	private String Amount;
	private String Status;
	
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
	public String getCompanyName() {
		return CompanyName;
	}
	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}
	public String getCreatedBy() {
		return CreatedBy;
	}
	public void setCreatedBy(String createdBy) {
		CreatedBy = createdBy;
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
	
	/////////////////////////////////////////////////////////////

	public Estimates(int id, String date, String companyName, String createdBy, String amount, String status) {
		super();
		Id = id;
		Date = date;
		CompanyName = companyName;
		CreatedBy = createdBy;
		Amount = amount;
		Status = status;
	}
	
	/////////////////////////////////////////////////////////////

	public Estimates() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
