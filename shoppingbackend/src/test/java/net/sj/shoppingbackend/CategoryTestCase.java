package net.sj.shoppingbackend;


import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.sj.shoppingbackend.dao.CategoryDAO;
import net.sj.shoppingbackend.dto.Category;

public class CategoryTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDAO cateogoryDao;
	
	private Category category;
	
	@BeforeClass
	public static void init() {
		
		context= new AnnotationConfigApplicationContext();
		context.scan("net.sj.shoppingbackend");
		context.refresh();
		
		cateogoryDao=(CategoryDAO) context.getBean("categoryDAO");
		
		
		
	}
	
	/*@Test
	public void testAddCategory() {
		
		category=new Category();
		category.setName("Mobile");
		category.setDescription("This is some descriptions for Mobile!");
		category.setImageURL("CAT_4.png");
		
		Assert.assertEquals("Swomething went wrong for category inside the table", true,cateogoryDao.add(category));
	}*/
	
	
	/*@Test
	public void testGetCategory() {
		
		category=cateogoryDao.get(22);
		
		Assert.assertEquals("Failed","Mobile",category.getName());
	}*/
	
	/*@Test
	public void testUpdateCategory() {
		category=cateogoryDao.get(3);
		category.setName("TV");
		Assert.assertEquals("Successfully updated a single category into the table",true,cateogoryDao.update(category));
	}*/
	
	/*@Test
	public void testDeleteCategory() {
		category=cateogoryDao.get(3);
		Assert.assertEquals("Successfully deleted a single category from the table",true,cateogoryDao.delete(category));
	}*/
	
	/*@Test
	public void testListCategory() {
		category=cateogoryDao.get(3);
		Assert.assertEquals("Successfully fetched all category from the table",2,cateogoryDao.list().size());
	}*/
	
	
	
	////////////////////// Crud Operation Using JUNIT TES //////////////////////
	
	@Test
	public void testCategoryCrud(){
		
		// Add a Category
		
		category=new Category();
		category.setName("Laptop");
		category.setDescription("This is some descriptions for Laptop!");
		category.setImageURL("CAT_1.png");
		
		Assert.assertEquals("Something went wrong while inserting category to the table",true,cateogoryDao.add(category));
		
		category=new Category();
		category.setName("Television");
		category.setDescription("This is some descriptions for Television!");
		category.setImageURL("CAT_2.png");
		Assert.assertEquals("Successfully added a  category to the table",true,cateogoryDao.add(category));
		
		category=new Category();
		category.setName("Mobile");
		category.setDescription("This is some descriptions for Mobile!");
		category.setImageURL("CAT_3.png");
		Assert.assertEquals("Successfully added a  category to the table",true,cateogoryDao.add(category));
		
		
		// get a single category
		category=cateogoryDao.get(21);
		Assert.assertEquals("Successfully fetched a single category from the table","Television",category.getName());
		
		// update a single Category
		category=cateogoryDao.get(21);
		category.setName("TV");
		Assert.assertEquals("Successfully updated a single category into the table",true,cateogoryDao.update(category));
		
		// delete a single category
		category=cateogoryDao.get(22);
		Assert.assertEquals("Successfully deleted a single category from the table",true,cateogoryDao.delete(category));
		
		//fetch all the list from category
		Assert.assertEquals("Successfully fetched all category from the table",2,cateogoryDao.list().size());
		
	}
	
	
	
}
