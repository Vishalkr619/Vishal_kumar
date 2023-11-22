package com.Other.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@DynamicUpdate
@DynamicInsert
public class TimeSheet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String User;
	private String Task;
	private String Project;
	private String Date;
	private String Invoiced;
	private String Time;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser() {
		return User;
	}
	public void setUser(String user) {
		User = user;
	}
	public String getTask() {
		return Task;
	}
	public void setTask(String task) {
		Task = task;
	}
	public String getProject() {
		return Project;
	}
	public void setProject(String project) {
		Project = project;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getInvoiced() {
		return Invoiced;
	}
	public void setInvoiced(String invoiced) {
		Invoiced = invoiced;
	}
	public String getTime() {
		return Time;
	}
	public void setTime(String time) {
		Time = time;
	}
	
	
	public TimeSheet(int id, String user, String task, String project, String date, String invoiced, String time) {
		super();
		this.id = id;
		User = user;
		Task = task;
		Project = project;
		Date = date;
		Invoiced = invoiced;
		Time = time;
	}
	
	
	public TimeSheet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
