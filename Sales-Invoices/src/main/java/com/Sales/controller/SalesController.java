package com.Sales.controller;

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

import com.Sales.model.Estimates;
import com.Sales.model.Expenses;
import com.Sales.model.Invoices;
import com.Sales.model.Payment;
import com.Sales.model.Products;
import com.Sales.model.Subscriptions;
import com.Sales.service.EstimatesService;
import com.Sales.service.ExpensesService;
import com.Sales.service.InvoicesService;
import com.Sales.service.PaymentService;
import com.Sales.service.ProductsService;
import com.Sales.service.SubscriptionService;

@RestController
@RequestMapping("/api/test")
public class SalesController {

	@Autowired
	private InvoicesService invoicesService;
	
	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private EstimatesService estimatesService;
	
	@Autowired
	private SubscriptionService subscriptionService;
	
	@Autowired
	private ProductsService productsService;
	
	@Autowired
	private ExpensesService expensesService;
	
	
	////////////////// GET METHOD //////////////////
	
	@GetMapping("/getInvoice")
	public List<Invoices> getAllInvoices()
	{
		return invoicesService.getAllInvoices();
	}
	
	@GetMapping("/getPayment")
	public List<Payment> getAllPayments()
	{
		return paymentService.getAllPayments();
	}
	
	@GetMapping("/getEstimate")
	public List<Estimates> getAllEstimates()
	{
		return estimatesService.getAllEstimates();
	}
	
	@GetMapping("/getSubscription")
	public List<Subscriptions> getAllSubscriptions()
	{
		return subscriptionService.getAllSubscriptions();
	}
	
	@GetMapping("/getProduct")
	public List<Products> getAllProducts()
	{
		return productsService.getAllProducts();
	}
	
	@GetMapping("/getExpense")
	public List<Expenses> getAllExpenses()
	{
		return expensesService.getAllExpenses();
	}
	
	
	////////////////// GET BY ID //////////////////
	
	@GetMapping("/invoce/{id}")
	public Invoices getInvoicesById(@PathVariable int id) throws RoleNotFoundException
	{
		return invoicesService.getInvoicesById(id);
	}
	
	@GetMapping("/payment/{id}")
	public Payment getPaymentById(@PathVariable int id) throws RoleNotFoundException
	{
		return paymentService.getPaymentById(id);
	}
	
	@GetMapping("/estimated/{id}")
	public Estimates getEstimatesById(@PathVariable int id) throws RoleNotFoundException
	{
		return estimatesService.getEstimatesById(id);
	}
	
	@GetMapping("/sub/{id}")
	public Subscriptions getSubscriptionsById(@PathVariable int id) throws RoleNotFoundException
	{
		return subscriptionService.getSubscriptionsById(id);
	}
	
	@GetMapping("/pro/{id}")
	public Products getProductsById(@PathVariable int id) throws RoleNotFoundException
	{
		return productsService.getProductsById(id);
	}
	
	@GetMapping("/expense/{id}")
	public Expenses getExpensesById(@PathVariable int id) throws RoleNotFoundException
	{
		return expensesService.getExpensesById(id);
	}
	
	
	////////////////// CREATE METHOD //////////////////

	@PostMapping("/addInvoice")
	public Invoices createInvoices(@RequestBody Invoices invoices)
	{
		return invoicesService.createInvoices(invoices);
	}
	
	@PostMapping("/addPayment")
	public Payment createPayment(@RequestBody Payment payment)
	{
		return paymentService.createPayment(payment);
	}
	
	@PostMapping("/addEstimate")
	public Estimates createEstimates(@RequestBody Estimates estimates)
	{
		return estimatesService.createEstimates(estimates);
	}
	
	@PostMapping("/addSubscription")
	public Subscriptions createSubscriptions(@RequestBody Subscriptions subscriptions)
	{
		return subscriptionService.createSubscriptions(subscriptions);
	}
	
	@PostMapping("/addProduct")
	public Products createProducts(@RequestBody Products product)
	{
		return productsService.createProducts(product);
	}
	
	@PostMapping("/addExpenses")
	public Expenses createExpenses(@RequestBody Expenses expenses)
	{
		return expensesService.createExpenses(expenses);
	}
	
	
	////////////////// UPDATE METHOD //////////////////
	
	 @PutMapping("/updateinvoice/{id}")
	    public ResponseEntity<String> updateInvoices(@PathVariable int id,@RequestBody Invoices updateInvoices ){
		 invoicesService.updateInvoices(id, updateInvoices);
	    	 return ResponseEntity.ok("updated Successfull");
	    }
	 
	 @PutMapping("/updatepay/{id}")
	    public ResponseEntity<String> updatePayment(@PathVariable int id,@RequestBody Payment updatePayment ){
		 paymentService.updatePaymentById(id, updatePayment);
	    	 return ResponseEntity.ok("updated Successfull");
	    }
	 
	 @PutMapping("/updateest/{id}")
	    public ResponseEntity<String> updateEstimates(@PathVariable int id,@RequestBody Estimates updateEstimates ){
		 estimatesService.updateEstimatesById(id, updateEstimates);
	    	 return ResponseEntity.ok("updated Successfull");
	    }
	 
	 @PutMapping("/updatesub/{id}")
	    public ResponseEntity<String> updateSubscriptions(@PathVariable int id,@RequestBody Subscriptions updateSubscriptions ){
		 subscriptionService.updateSubscriptionsById(id, updateSubscriptions);
	    	 return ResponseEntity.ok("updated Successfull");
	    }
	 
	 @PutMapping("/updatepro/{id}")
	    public ResponseEntity<String> updateProducts(@PathVariable int id,@RequestBody Products updateProducts ){
		 productsService.updateProductsById(id, updateProducts);
	    	 return ResponseEntity.ok("updated Successfull");
	    }
	 
	 @PutMapping("/updateexp/{id}")
	    public ResponseEntity<String> updateExpenses(@PathVariable int id,@RequestBody Expenses updateExpenses ){
		 expensesService.updateExpensesById(id, updateExpenses);
	    	 return ResponseEntity.ok("updated Successfull");
	    }
	 
	 
		///////////////// DELETE METHOD //////////////////

	 @DeleteMapping("/invoice/{id}")
	    public ResponseEntity<?> deleteInvoices(@PathVariable int id) throws Exception {
	      invoicesService.deleteInvoices(id);
	        return ResponseEntity.ok().build();
	  }
	 
	 @DeleteMapping("/pay/{id}")
	    public ResponseEntity<?> deletePayment(@PathVariable int id) throws Exception {
      paymentService.deletepPaymentById(id);
	        return ResponseEntity.ok().build();
	  }
	 
	 @DeleteMapping("/est/{id}")
	    public ResponseEntity<?> deleteEstimates(@PathVariable int id) throws Exception {
	      estimatesService.deleteEstimatesById(id);
	        return ResponseEntity.ok().build();
	  }
	 
	 @DeleteMapping("/sub/{id}")
	    public ResponseEntity<?> deleteSubscriptions(@PathVariable int id) throws Exception {
	      subscriptionService.deletepSubscriptionstById(id);
	        return ResponseEntity.ok().build();
	  }
	 
	 @DeleteMapping("/pro/{id}")
	    public ResponseEntity<?> deleteProducts(@PathVariable int id) throws Exception {
	      productsService.deletepProductstById(id);
	        return ResponseEntity.ok().build();
	  }

	 @DeleteMapping("/exp/{id}")
	    public ResponseEntity<?> deleteExpenses(@PathVariable int id) throws Exception {
	      expensesService.deleteExpensestById(id);
	        return ResponseEntity.ok().build();
	  }
}
