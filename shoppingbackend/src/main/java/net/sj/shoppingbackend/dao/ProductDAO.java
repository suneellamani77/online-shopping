package net.sj.shoppingbackend.dao;

import java.util.List;

import net.sj.shoppingbackend.dto.Product;

public interface ProductDAO {

	boolean add(Product product);
	List<Product> list();
	Product get(int productId);
	boolean update(Product product);
	boolean delete(Product product);
	
	// Business Method
	
	List<Product> listActiveProducts();
	List<Product> listActiveProductByCategory(int categoryId);
	List<Product>getLatestActiveProducts(int count);
 
}
