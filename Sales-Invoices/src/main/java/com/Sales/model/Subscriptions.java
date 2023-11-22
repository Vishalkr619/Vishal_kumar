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
public class Subscriptions {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	private String ClientName;
	private String Plan;
	private String Amount;
	private String Renewed;
	private String Payments;
	private String Status;
	
	/////////////////////////////////////////////////////////////

	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getClientName() {
		return ClientName;
	}
	public void setClientName(String clientName) {
		ClientName = clientName;
	}
	public String getPlan() {
		return Plan;
	}
	public void setPlan(String plan) {
		Plan = plan;
	}
	public String getAmount() {
		return Amount;
	}
	public void setAmount(String amount) {
		Amount = amount;
	}
	public String getRenewed() {
		return Renewed;
	}
	public void setRenewed(String renewed) {
		Renewed = renewed;
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
	
	/////////////////////////////////////////////////////////////

	public Subscriptions(int id, String clientName, String plan, String amount, String renewed, String payments,
			String status) {
		super();
		Id = id;
		ClientName = clientName;
		Plan = plan;
		Amount = amount;
		Renewed = renewed;
		Payments = payments;
		Status = status;
	}
	
	/////////////////////////////////////////////////////////////

	public Subscriptions() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
