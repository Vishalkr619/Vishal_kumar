package com.Sales.service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

import javax.management.relation.RoleNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Sales.model.Estimates;
import com.Sales.repository.EstimatesRepository;

@Service
public class EstimatesService {

	@Autowired
	private EstimatesRepository estimatesRepository;
	
	public EstimatesService(EstimatesRepository estimatesRepository)
	{
		this.estimatesRepository = estimatesRepository;
	}
	
	
	//Get method
	public List<Estimates> getAllEstimates()
	{
		return estimatesRepository.findAll();
	}
	
	//Get By Id 
	public Estimates getEstimatesById(int id) throws RoleNotFoundException
	{
		return estimatesRepository.findById(id)
								 .orElseThrow(()-> new RoleNotFoundException("Progress not found with id: " + id));
	}
	
	
	//Post Method
	public Estimates createEstimates(Estimates estimates)
	{
		return estimatesRepository.save(estimates);
	}
	
	
	//Put Method
	public Estimates updateEstimatesById(int id, Estimates updateEstimates)
	{
		Estimates estimates = estimatesRepository.findById(id).get();
		
		estimates.setId(updateEstimates.getId());
		estimates.setDate(updateEstimates.getDate());
		estimates.setCompanyName(updateEstimates.getCompanyName());
		estimates.setCreatedBy(updateEstimates.getCreatedBy());
		estimates.setAmount(updateEstimates.getAmount());
		estimates.setStatus(updateEstimates.getStatus());
		
		return estimatesRepository.save(estimates);
	}
	
	
	//Delete By Id
	public void deleteEstimatesById(int id) throws Exception
	{
		if(!estimatesRepository.existsById(id))
		{
			throw new UserPrincipalNotFoundException("Progress not found with id: " + id);
		}
		 estimatesRepository.deleteById(id);
	}
	
}
