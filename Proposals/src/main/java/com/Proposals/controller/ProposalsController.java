package com.Proposals.controller;

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

import com.Proposals.model.Proposals;
import com.Proposals.model.Templates;
import com.Proposals.service.ProposalsService;
import com.Proposals.service.TemplatesService;

@RestController
@RequestMapping("/api/test")
public class ProposalsController {

	@Autowired
	private ProposalsService proposalsService;
	
	@Autowired
	private TemplatesService templatesService;
	
	
	
	////////////////// GET METHOD //////////////////

	@GetMapping("/getproposal")
	public List<Proposals> getAllProposals()
	{
		return proposalsService.getAllProposals();
	}
	
	
	@GetMapping("/gettemplate")
	public List<Templates> getAllTemplates()
	{
		return templatesService.getAllTemplates();
	}
	
	
	////////////////// GET BY ID //////////////////

	@GetMapping("/prop/{id}")
	public Proposals getProposalsById(@PathVariable int id) throws RoleNotFoundException
	{
		return proposalsService.getpProposalsById(id);
	}
	
	
	@GetMapping("/temp/{id}")
	public Templates getTemplatesById(@PathVariable int id) throws RoleNotFoundException
	{
		return templatesService.getTemplatesById(id);
	}
	
	
	////////////////// CREATE METHOD //////////////////

	@PostMapping("/addproposal")
	public Proposals createProposals(@RequestBody Proposals proposals)
	{
		return proposalsService.createProposals(proposals);
	}
	
	@PostMapping("/addtemplate")
	public Templates createTemplates(@RequestBody Templates templates)
	{
		return templatesService.createTemplates(templates);
	}
	
	
	////////////////// UPDATE METHOD //////////////////

	@PutMapping("/prop{id}")
	public ResponseEntity<String> updateProposals(@PathVariable int id, @RequestBody Proposals updateProposal)
	{
		proposalsService.updateProposals(id, updateProposal);
   	 return ResponseEntity.ok("updated Successfull");
	}
	
	
	@PutMapping("/temp{id}")
	public ResponseEntity<String> updateTemplates(@PathVariable int id, @RequestBody Templates updateTemplates)
	{
		templatesService.updateTemplates(id, updateTemplates);
		return ResponseEntity.ok("update Successfull");
	}
	
	
	///////////////// DELETE METHOD //////////////////

	 @DeleteMapping("/prop/{id}")
	    public ResponseEntity<?> deleteProposals(@PathVariable int id) throws Exception {
	      proposalsService.deleteProposals(id);
	        return ResponseEntity.ok().build();
	  }
	 

	 
	 @DeleteMapping("/temp/{id}")
	    public ResponseEntity<?> deleteTemplates(@PathVariable int id) throws Exception {
	      templatesService.deleteTemplates(id);
	        return ResponseEntity.ok().build();
	  }
}
