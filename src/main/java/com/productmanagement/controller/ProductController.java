package com.productmanagement.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.productmanagement.entity.Product;
import com.productmanagement.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController 
{
	@Autowired
	private ProductService productService;
	
	@PostMapping("/addProduct")
	public String addProduct(@RequestBody Product Product)
	{		
		return productService.addProduct(Product);
	}
	
	@GetMapping("/getAllProducts")
	public List<Product> getAllProducts()
	{
		return productService.getAllProducts();
	}
	
	@GetMapping("/getProductById/{id}")
	public Object getProductById(@PathVariable int id)
	{
		return productService.getProductById(id);
	}
	
	@PutMapping("/updateProduct")
	public Object updateProduct(@RequestBody Product Product)
	{
		return productService.updateProduct(Product);
	}
	
	@DeleteMapping("deleteProduct/{id}")
	public String deleteProduct(@PathVariable int id)
	{
		return productService.deleteProduct(id);
	}

}
