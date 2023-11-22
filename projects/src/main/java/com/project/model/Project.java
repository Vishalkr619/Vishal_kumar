package com.project.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@DynamicInsert
@DynamicUpdate
public class Project {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String Title;
	private String Client;
	private String DueDate;
	private String Progress;
	private String Team;
	private String Status;
	
	
	///////////////////////////////////////////////////

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getClient() {
		return Client;
	}

	public void setClient(String client) {
		Client = client;
	}

	public String getDueDate() {
		return DueDate;
	}

	public void setDueDate(String dueDate) {
		DueDate = dueDate;
	}

	public String getProgress() {
		return Progress;
	}

	public void setProgress(String progress) {
		Progress = progress;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getTeam() {
		return Team;
	}

	public void setTeam(String team) {
		Team = team;
	}
	
	///////////////////////////////////////////////////


	public Project(int id, String title, String client, String dueDate, String progress, String status, String team) {
		super();
		this.id = id;
		Title = title;
		Client = client;
		DueDate = dueDate;
		Progress = progress;
		Status = status;
		Team = team;
	}
	
	///////////////////////////////////////////////////


	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	


	
}
