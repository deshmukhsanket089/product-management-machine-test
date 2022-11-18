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
import com.productmanagement.entity.Category;
import com.productmanagement.service.CategoryService;

@RestController
@RequestMapping("/api")
public class CategoryController 
{
	@Autowired
	private CategoryService catService;
	
	@PostMapping("/addCategory")
	public String addCategory(@RequestBody Category Category)
	{		
		return catService.addCategory(Category);
	}
	
	@GetMapping("/getAllCategories")
	public List<Category> getAllCategories()
	{
		return catService.getAllCategories();
	}
	
	@GetMapping("/getCategoryById/{id}")
	public Object getCategoryById(@PathVariable int id)
	{
		return catService.getCategoryById(id);
	}
	
	@PutMapping("/updateCategory")
	public Object updateCategory(@RequestBody Category category)
	{
		return catService.updateCategory(category);
	}
	
	@DeleteMapping("deleteCategory/{id}")
	public String deleteCategory(@PathVariable int id)
	{
		return catService.deleteCategory(id);
	}

}

/*
 * {
 * 	"Category":{
 * 		"name":"Fashion",
 * 		  },
 *  "products":[
 *  	{
 *  		"name":"shoe",
 *  		"quantity":100,
 *  		"price":1560.50
 *  	},
 *  	{
 *  		"name":"watch",
 *  		"quantity":150,
 *  		"price":2560.50
 *  	}
 *  
 *  ]
 * }
 * 
 */

