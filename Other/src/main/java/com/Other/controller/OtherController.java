package com.Other.controller;

import java.util.List;

import javax.management.relation.RoleNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Other.model.TeamMembers;
import com.Other.model.TimeSheet;
import com.Other.service.TeamMembersService;
import com.Other.service.TimeSheetService;

@RestController
@RequestMapping("/api/test")
public class OtherController {

	@Autowired
	private TimeSheetService timeSheetService;
	
	@Autowired
	private TeamMembersService teamMembersService;
	
	
	////////////////// GET METHOD //////////////////

	@GetMapping("/getsheet")
	public List<TimeSheet> getAllTimeSheets()
	{
		return timeSheetService.getAllTimeSheets();
	}
	
	
	@GetMapping("/getteam")
	public List<TeamMembers> getAllTeamMembers()
	{
		return teamMembersService.getAllTeamMembers();
	}
	
	////////////////// Get Method BY ID //////////////////
	
	@GetMapping("/sheet/{id}")
	public TimeSheet getTimeSheetById(@PathVariable int id) throws RoleNotFoundException
	{
		return timeSheetService.getTimeSheetById(id);
	}
	
	
	@GetMapping("/team/{id}")
	public TeamMembers getTeamMembersById(@PathVariable int id) throws RoleNotFoundException
	{
		return teamMembersService.getTeamMembersById(id);
	}
	
	////////////////// CREATE METHOD //////////////////
	
	@PostMapping("/addsheet")
	public TimeSheet createTimeSheet(@RequestBody TimeSheet timeSheet)
	{
		return timeSheetService.createTimeSheet(timeSheet);
	}
	
	
	@PostMapping("/addteam")
	public TeamMembers createTeamMembers(@RequestBody TeamMembers teamMembers)
	{
		return teamMembersService.createTeamMembers(teamMembers);
	}
	
	////////////////// UPDATE METHOD //////////////////

	@PutMapping("/sheet/{id}")
	public ResponseEntity<String> updateTimeSheet(@PathVariable int id, @RequestBody TimeSheet updateTimeSheet)
	{
		timeSheetService.updateTimeSheetById(id, updateTimeSheet);
		return ResponseEntity.ok("Update Successfull");
	}

	@PutMapping("/team/{id}")
	public ResponseEntity<String> updateTeamMembers(@PathVariable int id, @RequestBody TeamMembers teamMembers)
	{
		teamMembersService.updateTeamMembersById(id, teamMembers);
		return ResponseEntity.ok("Update Successfull");
	}
	
	////////////////// DELETE METHOD //////////////////
	
	@DeleteMapping("/sheet/{id}")
	public ResponseEntity<?> deleteTimeSheet(@PathVariable int id) throws Exception
	{
		timeSheetService.deleteTimeSheetById(id);
		return ResponseEntity.ok("Delete Successfull");
	}
	
	@DeleteMapping("/team/{id}")
	public ResponseEntity<?> deleteTeamMembers(@PathVariable int id) throws Exception
	{
		teamMembersService.deleteTeamMembersById(id);
		return ResponseEntity.ok("Delete Successfull");
	}

}
