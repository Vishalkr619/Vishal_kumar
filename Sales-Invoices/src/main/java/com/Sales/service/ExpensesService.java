package com.Sales.service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

import javax.management.relation.RoleNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Sales.model.Expenses;
import com.Sales.repository.ExpensesRepository;

@Service
public class ExpensesService {

	@Autowired
	private ExpensesRepository expensesRepository;
	
	public ExpensesService(ExpensesRepository expensesRepository)
	{
		this.expensesRepository = expensesRepository;
	}
	
	//Get method
	public List<Expenses> getAllExpenses()
	{
		return expensesRepository.findAll();
	}
	
	//Get method by Id
	public Expenses getExpensesById(int id) throws RoleNotFoundException
	{
		return expensesRepository.findById(id)
								 .orElseThrow(()-> new RoleNotFoundException("Progress not found with id: " + id));
	}
	
	
	//Post method
		public Expenses createExpenses(Expenses expenses)
		{
			return expensesRepository.save(expenses);
		}
		
		
		//Put method
		public Expenses updateExpensesById(int id, Expenses updateExpenses)
		{
			Expenses expenses = expensesRepository.findById(id).get();
			
			expenses.setId(updateExpenses.getId());
			expenses.setDate(updateExpenses.getDate());
			expenses.setDescription(updateExpenses.getDescription());
			expenses.setUser(updateExpenses.getUser());
			expenses.setClient(updateExpenses.getClient());
			expenses.setProject(updateExpenses.getProject());
			expenses.setAmount(updateExpenses.getAmount());
			expenses.setStatus(updateExpenses.getStatus());
			
			return expensesRepository.save(expenses);
			
		}
		
		
		//Delete method
		public void deleteExpensestById(int id) throws Exception
		{
			if(!expensesRepository.existsById(id))
			{
				throw new UserPrincipalNotFoundException("Progress not found with id: " + id);
			}
			 expensesRepository.deleteById(id);
		}
}
