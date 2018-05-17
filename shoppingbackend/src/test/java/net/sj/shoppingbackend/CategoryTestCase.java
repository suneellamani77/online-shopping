package net.sj.shoppingbackend;


import static org.junit.Assert.assertEquals;

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
	
	@Test
	public void testAddCategory() {
		
		category=new Category();
		category.setName("Laptop");
		category.setDescription("This is some descriptions for Laptop!");
		category.setImageURL("CAT_2.png");
		
		Assert.assertEquals("Successfully added a category inside the table", true,cateogoryDao.add(category));
	}
	
}
