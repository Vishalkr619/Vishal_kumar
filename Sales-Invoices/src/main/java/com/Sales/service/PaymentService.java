package com.Sales.service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

import javax.management.relation.RoleNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Sales.model.Payment;
import com.Sales.repository.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;
	
	public PaymentService(PaymentRepository paymentRepository) {
		this.paymentRepository = paymentRepository;
	}
	
	//Get method
	public List<Payment> getAllPayments()
	{
		return paymentRepository.findAll();
	}
	
	//Get By Id
	public Payment getPaymentById(int id) throws RoleNotFoundException
	{
		return paymentRepository.findById(id)
								.orElseThrow(() -> new RoleNotFoundException("Progress not found with id: " + id));
	}
	
	//Post method
	public Payment createPayment(Payment payment)
	{
		return paymentRepository.save(payment);
	}
	
	//put method
	public Payment updatePaymentById(int id, Payment updatePayment)
	{
		Payment payment = paymentRepository.findById(id).get();
		
		payment.setId(updatePayment.getId());
		payment.setDate(updatePayment.getDate());
		payment.setInvoice(updatePayment.getInvoice());
		payment.setAmount(updatePayment.getAmount());
		payment.setClient(updatePayment.getClient());
		payment.setProject(updatePayment.getProject());
		payment.setMethod(updatePayment.getMethod());
		
		return paymentRepository.save(payment);
	}
	
	//Delete By Id
	public void deletepPaymentById(int id) throws Exception
	{
		if(!paymentRepository.existsById(id))
		{
			throw new UserPrincipalNotFoundException("Progress not found with id: " + id);
		}
		 paymentRepository.deleteById(id);
	}
}
