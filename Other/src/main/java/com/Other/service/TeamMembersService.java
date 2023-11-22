package com.Other.service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

import javax.management.relation.RoleNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Other.model.TeamMembers;
import com.Other.repository.TeamMembersRepository;

@Service
public class TeamMembersService {

	@Autowired
	private TeamMembersRepository teamMembersRepository;
	
	public TeamMembersService(TeamMembersRepository teamMembersRepository)
	{
		this.teamMembersRepository = teamMembersRepository;
	}
	
	//Get method
	public List<TeamMembers> getAllTeamMembers()
	{
		return teamMembersRepository.findAll();
	}
	
	//get by id
	public TeamMembers getTeamMembersById(int id) throws RoleNotFoundException
	{
		return teamMembersRepository.findById(id)
									.orElseThrow(() -> new RoleNotFoundException("Progress not found with id "+id));
	}
	
	//create method
	public TeamMembers createTeamMembers(TeamMembers teamMembers)
	{
		return teamMembersRepository.save(teamMembers);
	}
	
	//update method
	public TeamMembers updateTeamMembersById(int id, TeamMembers updateTeamMembers)
	{
		TeamMembers teamMembers = teamMembersRepository.findById(id).get();
		
		teamMembers.setId(updateTeamMembers.getId());
		teamMembers.setFirstName(updateTeamMembers.getFirstName());
		teamMembers.setPosition(updateTeamMembers.getPosition());
		teamMembers.setRole(updateTeamMembers.getRole());
		teamMembers.setEmail(updateTeamMembers.getEmail());
		teamMembers.setPhone(updateTeamMembers.getPhone());
		teamMembers.setLastSeen(updateTeamMembers.getLastSeen());
		
		return teamMembersRepository.save(teamMembers);
	}
	
	//Delete method
	public void deleteTeamMembersById(int id) throws Exception
	{
		if(!teamMembersRepository.existsById(id))
		{
			throw new UserPrincipalNotFoundException("progress not found with id "+id);
		}
		
		teamMembersRepository.deleteById(id);
	}
}
