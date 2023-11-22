package com.Other.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@DynamicInsert
@DynamicUpdate
public class TeamMembers {

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int Id;
	private String FirstName;
	private String Position;
	private String Role;
	private String Email;
	private String Phone;
	private String lastSeen;
	
	///////////////////////////////////////////////////////////
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getPosition() {
		return Position;
	}
	public void setPosition(String position) {
		Position = position;
	}
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getLastSeen() {
		return lastSeen;
	}
	public void setLastSeen(String lastSeen) {
		this.lastSeen = lastSeen;
	}
	
	///////////////////////////////////////////////////////////

	public TeamMembers(int id, String firstName, String position, String role, String email, String phone,
			String lastSeen) {
		super();
		Id = id;
		FirstName = firstName;
		Position = position;
		Role = role;
		Email = email;
		Phone = phone;
		this.lastSeen = lastSeen;
	}
	
	///////////////////////////////////////////////////////////

	public TeamMembers() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
