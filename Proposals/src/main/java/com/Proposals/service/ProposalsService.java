package com.Proposals.service;

import java.util.List;

import javax.management.relation.RoleNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Proposals.model.Proposals;
import com.Proposals.repository.ProposalsRepository;

@Service
public class ProposalsService {

	@Autowired
	private ProposalsRepository proposalsRepository;
	
	public ProposalsService(ProposalsRepository proposalsRepository)
	{
		this.proposalsRepository = proposalsRepository;
	}
	
	//Get method
	public List<Proposals> getAllProposals()
	{
		return proposalsRepository.findAll();
	}
	
	//Get By Id 
	public Proposals getpProposalsById(int id) throws RoleNotFoundException
	{
		return proposalsRepository.findById(id)
							.orElseThrow(() -> new RoleNotFoundException("process not found with id: "+id));
	}
	
	//Post method
	public Proposals createProposals(Proposals proposals)
	{
		return proposalsRepository.save(proposals);
	}
	
	//Put method
	public Proposals updateProposals(int id, Proposals updateProposal)
	{
		Proposals proposal = proposalsRepository.findById(id).get();
		
		proposal.setId(updateProposal.getId());
		proposal.setDate(updateProposal.getDate());
		proposal.setProposedTo(updateProposal.getProposedTo());
		proposal.setTitle(updateProposal.getTitle());
		proposal.setValue(updateProposal.getValue());
		proposal.setValidUntil(updateProposal.getValidUntil());
		proposal.setStatus(updateProposal.getStatus());
		
		
		return proposalsRepository.save(proposal);
	}
	
	//Delete method
	public void deleteProposals(int id) throws Exception 
	{
		if(!proposalsRepository.existsById(id))
		{
			throw new Exception("process not found with id "+id);
		}
		
		proposalsRepository.deleteById(id);
	}
}
