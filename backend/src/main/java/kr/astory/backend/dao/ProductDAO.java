package kr.astory.backend.dao;

import java.util.List;

import kr.astory.backend.dto.Product;

public interface ProductDAO {
	
	
	Product get(int productId);
	List<Product> list();
	boolean add(Product product);
	boolean update(Product product);
	boolean delete(Product product);
	
	// business methods
	List<Product> listActiveProducts();
	List<Product> listActiveProductsByCategory(int categoryId);
	List<Product> getLastestActiveProducts(int count);
	
	

}
