package com.Proposals.service;

import java.util.List;

import javax.management.relation.RoleNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proposals.model.Templates;
import com.Proposals.repository.TemplatesRepository;

@Service
public class TemplatesService {

	@Autowired
	private TemplatesRepository templatesRepository;
	
	public TemplatesService(TemplatesRepository templatesRepository)
	{
		this.templatesRepository = templatesRepository;
	}
	
	//Get Method
	public List<Templates> getAllTemplates()
	{
		return templatesRepository.findAll();
	}
	
	//Get By Id
	public Templates getTemplatesById(int id) throws RoleNotFoundException
	{
		return templatesRepository.findById(id)
					 .orElseThrow(() -> new RoleNotFoundException("Process not found with Id: " +id));
	}
	
	//Post Method
	public Templates createTemplates(Templates templates)
	{
		return templatesRepository.save(templates);
	}
	
	//Put Method By Id
	public Templates updateTemplates(int id,Templates updatetemplates)
	{
		Templates templates = templatesRepository.findById(id).get();
		
		templates.setId(updatetemplates.getId());
		templates.setDateCreated(updatetemplates.getDateCreated());
		templates.setCreatedBy(updatetemplates.getCreatedBy());
		
		return templatesRepository.save(templates);
	}
	
	//Delete Method By Id
	public void deleteTemplates(int id) throws Exception
	{
		if(!templatesRepository.existsById(id))
		{
			throw new Exception("process not found with id: "+id);
		}
		templatesRepository.deleteById(id);
	}
}
