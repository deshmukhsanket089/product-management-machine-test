package com.productmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productmanagement.entity.Product;
import com.productmanagement.repository.ProductRepository;

@Service
public class ProductService 
{
	@Autowired
	private ProductRepository productRepository;
	
	public String addProduct(Product product)
	{
		if(product!=null)
		{
			productRepository.save(product);
			return "product added ";
		}
		else
		{
			return "something went wrong";
		}
	}

	public List<Product> getAllProducts() {
		
		return productRepository.findAll();
	}

	public Object getProductById(int id) {
		
		Product Product=productRepository.getById(id);
		if(Product!=null)
		{
			return Product;
		}
		else
		{
			return "Product not found for the id : " + id;
		}
	}

	public Object updateProduct(Product product) 
	{
		
		if(product!=null)
		{
			Product updatedProduct=null;
			updatedProduct.setName(product.getName());
			updatedProduct.setQuantity(product.getQuantity());
			updatedProduct.setPrice(product.getPrice());
			if(updatedProduct!=null)
			{
				return productRepository.save(updatedProduct);
			}
			else
			{
				return productRepository.save(product);
			}
		}
		else
		{
			return "No Product found for id :" +product.getId();
		}
	}

	public String deleteProduct(int id) {
		Product product=productRepository.getById(id);
		if(product!=null)
		{
			productRepository.delete(product);
			return "Product deleted ";
		}
		return "Product not found for id : "+ id;
	}

}
