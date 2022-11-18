package com.productmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.productmanagement.entity.Category;
import com.productmanagement.repository.CategoryRepository;

@Service
public class CategoryService 
{
	@Autowired
	private CategoryRepository catRepo;
	
	public String addCategory(Category catagory)
	{
		if(catagory!=null)
		{
			catRepo.save(catagory);
			return "Catagory added ";
		}
		else
		{
			return "something went wrong";
		}
	}

	public List<Category> getAllCategories() {
		
		return catRepo.findAll();
	}

	public Object getCategoryById(int id) {
		
		Category category=catRepo.getById(id);
		if(category!=null)
		{
			return category;
		}
		else
		{
			return "Category not found for the id : " + id;
		}
	}

	public Object updateCategory(Category category) 
	{
		
		if(category!=null)
		{
			Category updatedCategory=null;
			updatedCategory.setName(category.getName());
			updatedCategory.setProducts(category.getProducts());
			if(updatedCategory!=null)
			{
				return catRepo.save(updatedCategory);
			}
			else
			{
				return catRepo.save(category);
			}
		}
		else
		{
			return "No Category found for id :" +category.getId();
		}
	}

	public String deleteCategory(int id) {
		Category category=catRepo.getById(id);
		if(category!=null)
		{
			catRepo.delete(category);
			return "category deleted ";
		}
		return "Category not found for id : "+ id;
	}


	
		
}
