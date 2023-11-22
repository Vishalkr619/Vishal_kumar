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
public class Templates {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	private String Title;
	private String DateCreated;
	private String CreatedBy;
	
///////////////////////////////////////////////////////////////////////////////////////////////////
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getDateCreated() {
		return DateCreated;
	}
	public void setDateCreated(String dateCreated) {
		DateCreated = dateCreated;
	}
	public String getCreatedBy() {
		return CreatedBy;
	}
	public void setCreatedBy(String createdBy) {
		CreatedBy = createdBy;
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////
	
	public Templates(int id, String title, String dateCreated, String createdBy) {
		super();
		Id = id;
		Title = title;
		DateCreated = dateCreated;
		CreatedBy = createdBy;
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////

	public Templates() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
