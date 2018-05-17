package net.sj.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import net.sj.shoppingbackend.dao.CategoryDAO;
import net.sj.shoppingbackend.dto.Category;


@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO{
	
	@Autowired
	private SessionFactory sf;
	
	
	private static List<Category> categories=new ArrayList<Category>();
	
	static{
		
		Category category=new Category();
		category.setId(1);
		category.setName("Televison");
		category.setDescription("This is some descriptions for Televisions!");
		category.setImageURL("CAT_1.png");
		
		categories.add(category);
		
		category=new Category();
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("This is some descriptions for Mobile!");
		category.setImageURL("CAT_2.png");
		
		categories.add(category);
		
		category=new Category();
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("This is some descriptions for Laptop!");
		category.setImageURL("CAT_2.png");
		
		categories.add(category);
		
	}

	@Override
	public List<Category> list() {
		return categories;
	}

	@Override
	public Category get(int id) {
		
for (Category category : categories) {
			if(category.getId()==id) return category;
		}
		return null;}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public boolean add(Category category) {
		
		try {
			sf.getCurrentSession().save(category);
			
			return true;
		} catch (Exception e) {
			System.err.println("exception to store "+e);
			return false;		
			}
	}

}		
