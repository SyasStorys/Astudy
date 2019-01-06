package kr.astory.backend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.astory.backend.dao.CategoryDAO;
import kr.astory.backend.dao.ProductDAO;
import kr.astory.backend.dto.Category;
import kr.astory.backend.dto.Product;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDAO categoryDAO;
	
	private Category category;
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("kr.astory.backend");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
		
	}
	
/*	@Test
	public void testAddCategory() {
		
		category = new Category();
		
		category.setName("Laptop");
		category.setDescription("This is some description for laptop!");
		category.setImageURL("CAT_105.png");
		
		assertEquals("SuccessFully added a category inside the table", true, categoryDAO.add(category));
		
	}*/
	
	
	/*@Test
	public void testGetCategory() {
		category = categoryDAO.get(3);
		assertEquals("SuccessFully fetched a single category from the table!", "Television", category.getName());
	}*/
	
	/*@Test
	public void testUpdateCategory() {
		
		category = categoryDAO.get(3);
		
		category.setName("TV");
		
		assertEquals("Successfully updated a single category in the table!",true,categoryDAO.update(category));
		
	}
	*/
	
	/*@Test
	public void testDeleteCategory() {
		
		category = categoryDAO.get(4);
		assertEquals("Successfully deleted a single category in the table!",true,categoryDAO.delete(category));
		
	}
	*/
	
/*	@Test
	public void testListCategory() {
		assertEquals("Successfully fetched the lis tof table!",3,categoryDAO.list().size());
		
	}
	*/
	
	@Test
	public void testCRUDCategory() {
		
		// add operation
		category = new Category();
		
		category.setName("Laptop");
		category.setDescription("This is some description for laptop!");
		category.setImageURL("CAT_1.png");
		
		assertEquals("Successfully added a category inside the table!",true,categoryDAO.add(category));
		
		
		category = new Category();
		
		category.setName("Television");
		category.setDescription("This is some description for television!");
		category.setImageURL("CAT_2.png");
		
		assertEquals("Successfully added a category inside the table!",true,categoryDAO.add(category));

		
		// fetching and updating the category
		category = categoryDAO.get(2);
		
		category.setName("TV");
		
		assertEquals("Successfully updated a single category in the table!",true,categoryDAO.update(category));
		
		
		// delete the category
		assertEquals("Successfully deleted a single category in the table!",true,categoryDAO.delete(category));
		
		
		//fetching the list
		assertEquals("Successfully fetched the list of categories from the table!",1,categoryDAO.list().size());		

	}
}
