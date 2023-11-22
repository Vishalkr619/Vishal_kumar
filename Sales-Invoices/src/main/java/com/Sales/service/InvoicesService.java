package com.Sales.service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

import javax.management.relation.RoleNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Sales.model.Invoices;
import com.Sales.repository.InvoicesRepository;

@Service
public class InvoicesService {

	@Autowired
	private InvoicesRepository invoicesRepository;
	
	public InvoicesService(InvoicesRepository invoicesRepository)
	{
		this.invoicesRepository = invoicesRepository;
	}
	
	//Get method
	public List<Invoices> getAllInvoices()
	{
		return invoicesRepository.findAll();
	}
	
	//Get by Id method
	public Invoices getInvoicesById(int id) throws RoleNotFoundException{
		return invoicesRepository.findById(id)
									.orElseThrow(() -> new RoleNotFoundException("Progress not found with id: " + id));
	}
	
	//Post method
	public Invoices createInvoices(Invoices invoices) {
		return invoicesRepository.save(invoices);
	}
	
	//Update by Id
	public Invoices updateInvoices(int id, Invoices updateinvoices) {
		Invoices invoices = invoicesRepository.findById(id).get();
		
		invoices.setId(updateinvoices.getId());
		invoices.setDate(updateinvoices.getDate());
		invoices.setCompanyName(updateinvoices.getCompanyName());
		invoices.setProject(updateinvoices.getProject());
		invoices.setAmount(updateinvoices.getAmount());
		invoices.setPayments(updateinvoices.getPayments());
		invoices.setStatus(updateinvoices.getStatus());
		
		return invoicesRepository.save(invoices);
		
	}
	
	//Delete By Id
	public void deleteInvoices(int id) throws Exception
	{
		if(!invoicesRepository.existsById(id))
		{
			throw new UserPrincipalNotFoundException("Progress not found with id: " + id);
		}
		invoicesRepository.deleteById(id);
	}
}
