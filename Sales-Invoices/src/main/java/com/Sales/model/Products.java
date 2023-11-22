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
public class Products {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	private String Descrription;
	private String Rate;
	private String Unit;
	private String Cetegory;
	
	/////////////////////////////////////////////////////////////

	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getDescrription() {
		return Descrription;
	}
	public void setDescrription(String descrription) {
		Descrription = descrription;
	}
	public String getRate() {
		return Rate;
	}
	public void setRate(String rate) {
		Rate = rate;
	}
	public String getUnit() {
		return Unit;
	}
	public void setUnit(String unit) {
		Unit = unit;
	}
	public String getCetegory() {
		return Cetegory;
	}
	public void setCetegory(String cetegory) {
		Cetegory = cetegory;
	}
	
	/////////////////////////////////////////////////////////////

	public Products(int id, String descrription, String rate, String unit, String cetegory) {
		super();
		Id = id;
		Descrription = descrription;
		Rate = rate;
		Unit = unit;
		Cetegory = cetegory;
	}
	
	/////////////////////////////////////////////////////////////

	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
