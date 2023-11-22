package com.Sales.service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

import javax.management.relation.RoleNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Sales.model.Products;
import com.Sales.repository.ProductsRepository;

@Service
public class ProductsService {

	@Autowired
	private ProductsRepository productsRepository;

	public ProductsService(ProductsRepository productsRepository)
	{
		this.productsRepository = productsRepository;
	}
	
	//Get method
	public List<Products> getAllProducts()
	{
		return productsRepository.findAll(); 
	}
	
	//Get By Id
	public Products getProductsById(int id) throws RoleNotFoundException
	{
		return productsRepository.findById(id)
								 .orElseThrow(()-> new RoleNotFoundException("Progress not found with id: " + id));
	}
	
	//Post method
	public Products createProducts(Products products)
	{
		return productsRepository.save(products);
	}
	
	
	//Put method
	public Products updateProductsById(int id, Products updateProducts)
	{
		Products products = productsRepository.findById(id).get();
		
		products.setId(updateProducts.getId());
		products.setDescrription(updateProducts.getDescrription());
		products.setUnit(updateProducts.getUnit());
		products.setCetegory(updateProducts.getCetegory());
		
		return productsRepository.save(products);
	}
	
	
	
	//Delete By Id
	public void deletepProductstById(int id) throws Exception
	{
		if(!productsRepository.existsById(id))
		{
			throw new UserPrincipalNotFoundException("Progress not found with id: " + id);
		}
		 productsRepository.deleteById(id);
	}
	
}
