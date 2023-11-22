package com.Proposals.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@DynamicInsert
@DynamicUpdate
public class Proposals {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	private String Date;
	private String ProposedTo;
	private String Title;
	private String Value;
	private String ValidUntil;
	private String Status;
	
	
////////////////////////////////////////////////////////////////////////////////////////////////////
	
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
	public String getProposedTo() {
		return ProposedTo;
	}
	public void setProposedTo(String proposedTo) {
		ProposedTo = proposedTo;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getValue() {
		return Value;
	}
	public void setValue(String value) {
		Value = value;
	}
	public String getValidUntil() {
		return ValidUntil;
	}
	public void setValidUntil(String validUntil) {
		ValidUntil = validUntil;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public Proposals(int id, String date, String proposedTo, String title, String value, String validUntil,
			String status) {
		super();
		Id = id;
		Date = date;
		ProposedTo = proposedTo;
		Title = title;
		Value = value;
		ValidUntil = validUntil;
		Status = status;
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public Proposals() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
