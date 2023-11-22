package com.project.controller;

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
import com.project.model.Project;
import com.project.model.Templates;
import com.project.service.ProjectService;
import com.project.service.TemplatesService;

@RestController
@RequestMapping("/api/test")
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private TemplatesService templatesService;
	
	
	
	////////////////// GET METHOD //////////////////
	
	@GetMapping("/getproject")
	public List<Project> getAllProject()
	{
		return projectService.getAllProjects();
	}
	
	
	@GetMapping("/gettemplate")
	public List<Templates> getAllTemplates()
	{
		return templatesService.getAllTemplates();
	}
	
	
	////////////////// GET METHOD BY ID //////////////////
	
	@GetMapping("/getpro/{id}")
	public Project getProjectById(@PathVariable int id) throws RoleNotFoundException
	{
		return projectService.getProjectById(id);
	}
	
	@GetMapping("/gettemp/{id}")
	public Templates getTemplatesById(@PathVariable int id) throws RoleNotFoundException
	{
		return templatesService.getTemplatesById(id);
	}
	
	
	
	////////////////// CREATE METHOD //////////////////
	
	@PostMapping("/addproject")
	public Project createProject(@RequestBody Project project)
	{
		return projectService.createProject(project);
	}
	
	@PostMapping("/addtemplate")
	public Templates createTemplates(@RequestBody Templates templates)
	{
		return templatesService.createTemplates(templates);
	}
	
	
		
	////////////////// UPDATE METHOD BY ID //////////////////
	
	 @PutMapping("/updateproject/{id}")
	 public ResponseEntity<String> updateProject(@PathVariable int id,@RequestBody Project updateProject )
	 {
		 projectService.updateProject(id, updateProject);
	    	 return ResponseEntity.ok("updated Successfull");
	    }
	 
	 @PutMapping("/updatetemplate/{id}")
	 public ResponseEntity<String> updateTemplatesById(@PathVariable int id,@RequestBody Templates templates)
	 {
		templatesService.updateTemplatesById(id, templates);
		return ResponseEntity.ok("Updated Successfull");
	 }
	 
	 
		////////////////// DELETE METHOD BY ID //////////////////
	 
	 @DeleteMapping("/deleteproject/{id}")
	    public ResponseEntity<?> deleteProject(@PathVariable int id) throws Exception 
	  {
	      projectService.deleteProject(id);
	        return ResponseEntity.ok().build();
	  }
	 
	 @DeleteMapping("/deletetemplate/{id}")
	 public ResponseEntity<?> deleteTemplates(@PathVariable int id) throws Exception
	 {
		 templatesService.deleteTemplates(id);
		 return ResponseEntity.ok().build();
	 }
}
