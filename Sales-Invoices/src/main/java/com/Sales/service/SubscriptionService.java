package com.Sales.service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

import javax.management.relation.RoleNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Sales.model.Subscriptions;
import com.Sales.repository.SubscriptionsRepository;

@Service
public class SubscriptionService {

	@Autowired
	private SubscriptionsRepository subscriptionsRepository;
	
	public SubscriptionService(SubscriptionsRepository subscriptionsRepository)
	{
		this.subscriptionsRepository = subscriptionsRepository;
	}
	
	//Get method
	public List<Subscriptions> getAllSubscriptions()
	{
		return subscriptionsRepository.findAll();
	}
	
	//Get By Id
	public Subscriptions getSubscriptionsById(int id) throws RoleNotFoundException
	{
		return subscriptionsRepository.findById(id)
								 .orElseThrow(()-> new RoleNotFoundException("Progress not found with id: " + id));
	}
	
	//Post Method
	public Subscriptions createSubscriptions(Subscriptions subscriptions)
	{
		return subscriptionsRepository.save(subscriptions);
	}
	
	//Put Method
	public Subscriptions updateSubscriptionsById(int id, Subscriptions updateSubscriptions)
	{
		Subscriptions subscriptions = subscriptionsRepository.findById(id).get();
		
		subscriptions.setId(updateSubscriptions.getId());
		subscriptions.setClientName(updateSubscriptions.getClientName());
		subscriptions.setPlan(updateSubscriptions.getPlan());
		subscriptions.setAmount(updateSubscriptions.getAmount());
		subscriptions.setRenewed(updateSubscriptions.getRenewed());
		subscriptions.setPayments(updateSubscriptions.getPayments());
		subscriptions.setStatus(updateSubscriptions.getStatus());
		
		return subscriptionsRepository.save(subscriptions);
	}
	
	
	//Delete By Id
	public void deletepSubscriptionstById(int id) throws Exception
	{
		if(!subscriptionsRepository.existsById(id))
		{
			throw new UserPrincipalNotFoundException("Progress not found with id: " + id);
		}
		 subscriptionsRepository.deleteById(id);
	}
	
}
