package net.sj.shoppingbackend;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.sj.shoppingbackend.dao.ProductDAO;
import net.sj.shoppingbackend.dto.Product;

public class ProductTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	private static ProductDAO productDAO;
	
	private Product product;
	
	
	@BeforeClass
	public static void init() {
		
		context= new AnnotationConfigApplicationContext();
		context.scan("net.sj.shoppingbackend");
		context.refresh();
		
		productDAO = (ProductDAO) context.getBean("productDAO");
		
	}
	
	@Test
	public void testAddProduct(){
		
		// Add Product 
		/*product=new Product();
		
		product.setName("RedMi Note5 PRO");
		product.setBrand("MI");
		product.setDescription("This is one of the best Mobile series from MI that can be used!");
		product.setUnitPrice(15000.00);
		product.setQuantity(2);
		product.setCategoryId(1);
		product.setSupplierId(3);
		product.setPurchases(0);
		product.setViews(0);
		
		Assert.assertEquals("Something went wrong while insert product into table", true, productDAO.add(product));*/
		
		// Get Product
		product=productDAO.get(3);
		Assert.assertEquals("Something went wrong while fetching single product from table", "Google", product.getName());
	
		
		// Update Product
		product=productDAO.get(3);
		product.setName("Google");
		Assert.assertEquals("Something went wrong while updating single product into table",true,productDAO.update(product));
		
		
		// Delete Product
		product=productDAO.get(3);
		Assert.assertEquals("Something Went Wrong while delete single product from table", true, productDAO.delete(product));
		
		// List Of Product
		Assert.assertEquals("Something went wrong while fetching all products from table",7,productDAO.list().size());
		
		//list of Active Products
		Assert.assertEquals("Something went wrong while fetching all active products from table",5,productDAO.listActiveProducts().size());
	
		
		//list Active Product By CategoryId
		Assert.assertEquals("Something went wrong while fetching all active products based on categoryId from table",2,productDAO.listActiveProductByCategory(3).size());
		
		
		// get Latest Active Products
		Assert.assertEquals("Something went wrong while fetching all active products based on latest product from table", 2, productDAO.getLatestActiveProducts(2).size());
		
	}

}
