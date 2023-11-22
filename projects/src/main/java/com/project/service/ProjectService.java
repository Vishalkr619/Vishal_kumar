package com.project.service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

import javax.management.relation.RoleNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Project;
import com.project.repository.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;
	
	
	public ProjectService(ProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
	}
	
	//Get method
	public List<Project> getAllProjects()
	{
		return projectRepository.findAll();
	}
	
	//Get method by Id
	public Project getProjectById(int id ) throws RoleNotFoundException{
		return projectRepository.findById(id)
								.orElseThrow(() -> new RoleNotFoundException("Progress not found with id: " + id));
	}
	
	//Create method 
	public Project createProject(Project project) {
		return projectRepository.save(project);
	}
	
	//update method by Id
	public Project updateProject(int id,Project updateproject) {
		
		Project project = projectRepository.findById(id).get();
		
		project.setId(updateproject.getId());
		project.setTitle(updateproject.getTitle());
		project.setClient(updateproject.getClient());
		project.setDueDate(updateproject.getDueDate());
		project.setProgress(updateproject.getProgress());
		project.setTeam(updateproject.getTeam());
		project.setStatus(updateproject.getStatus());
		
		return projectRepository.save(project);
	}
	
	//Delete method by Id
	public void deleteProject(int id) throws Exception
	{
		if (!projectRepository.existsById(id)) {
    	    throw new UserPrincipalNotFoundException("Progress not found with id: " + id);
    	}
	
    	projectRepository.deleteById(id);
	}
}
