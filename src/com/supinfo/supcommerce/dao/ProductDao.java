package com.supinfo.supcommerce.dao;

import java.util.List;

import com.supinfo.supcommerce.entity.Product;

public interface ProductDao {

	public List<Product> getCheaperProducts(float f);
	public List<Product> getAllProducts();
	public Product getProductById(long productId);
	public void deleteProduct(long productId);
	public void addProduct(Product p);
}
