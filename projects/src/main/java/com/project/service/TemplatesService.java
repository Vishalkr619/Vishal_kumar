package com.project.service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

import javax.management.relation.RoleNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Templates;
import com.project.repository.TemplatesRepository;

@Service
public class TemplatesService {

	@Autowired
	private TemplatesRepository templatesRepository;
	
	
	public TemplatesService (TemplatesRepository templatesRepository)
	{
		this.templatesRepository = templatesRepository;
	}
	
	//Get method
	public List<Templates> getAllTemplates()
	{
		return templatesRepository.findAll();
	}
	
	//Get By Id
	public Templates getTemplatesById(int id) throws RoleNotFoundException
	{
		return templatesRepository.findById(id)
								 .orElseThrow(() -> new RoleNotFoundException("process not found with id "+id));
	}
	
	//Create method
	public Templates createTemplates(Templates templates)
	{
		return templatesRepository.save(templates);
	}
	
	//update By Id
	public Templates updateTemplatesById(int id, Templates updateTamTemplates)
	{
		Templates templates = templatesRepository.findById(id).get();
		
		templates.setId(updateTamTemplates.getId());
		templates.setTitle(updateTamTemplates.getTitle());
		templates.setDateCreated(updateTamTemplates.getDateCreated());
		templates.setCategory(updateTamTemplates.getCategory());
		templates.setCreatedBy(updateTamTemplates.getCreatedBy());
		
		return templatesRepository.save(templates);
	}
	
	//Delete By Id
	public void deleteTemplates(int id) throws Exception
	{
		if(!templatesRepository.existsById(id))
		{
			throw new UserPrincipalNotFoundException("process not found with id "+id);
		}
		
		templatesRepository.deleteById(id);
	}
	
}
