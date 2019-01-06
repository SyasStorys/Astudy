package kr.astory.backend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.astory.backend.dao.ProductDAO;
import kr.astory.backend.dto.Product;

public class ProductTestCase {

	private static AnnotationConfigApplicationContext context;
	
	private static ProductDAO productDAO;
	
	private Product product;
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("kr.astory.backend");
		context.refresh();
		productDAO = (ProductDAO) context.getBean("productDAO");
		
	}
	
	/*@Test
	public void testCRUDProduct() {
		
		// crewate operation
		product = new Product();
		
		product.setName("Opo Selfie S53");
		product.setBrand("Oppo");
		product.setDescription("this is some description for oppo mobile phones!");
		product.setUnitPrice(25000);
		product.setActive(true);
		product.setCategoryId(3);
		product.setSupplierId(3);
		
		assertEquals("Someting went wrong while inserting a new product!", true, productDAO.add(product));
		
		
		// reading and updating the category
		product = productDAO.get(2);
		product.setName("Samsung Galaxy S7");
		assertEquals("Someting went wrong while updating the existing record!", true, productDAO.update(product));
		
		assertEquals("Someting went wrong while deleting the existing record!", true, productDAO.delete(product));
		
		assertEquals("Someting went wrong while fetching the list of products!", 6, productDAO.list().size());
	}*/
	
/*	@Test
	public void testListActiveProducts() {
		assertEquals("Someting went wrong while fetching the list of products!", 5, productDAO.listActiveProducts().size());
	}
	
	@Test
	public void testListActiveProductByCategory() {
		assertEquals("Someting went wrong while fetching the list of products!", 3, productDAO.listActiveProductsByCategory(3).size());
		assertEquals("Someting went wrong while fetching the list of products!", 2, productDAO.listActiveProductsByCategory(1).size());
	}

	@Test
	public void testGetLatestActiveProduct() {
		assertEquals("Someting went wrong while fetching the list of products!", 3, productDAO.getLastestActiveProducts(3).size());
	}*/

}
