package net.sj.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import net.sj.shoppingbackend.dao.CategoryDAO;
import net.sj.shoppingbackend.dto.Category;


@Repository("categoryDAO")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
@SuppressWarnings("unchecked")
public class CategoryDAOImpl implements CategoryDAO{
	
	@Autowired
	private SessionFactory sf;
	

	
	@Override
	public List<Category> list() {
		
		String selectActiveCategory="FROM Category where active= :active";
		return sf.getCurrentSession().createQuery(selectActiveCategory).setParameter("active",true).list();
	}

	@Override
	public Category get(int id) {
		return sf.getCurrentSession().get(Category.class, Integer.valueOf(id));
		}

	@Override
	public boolean add(Category category) {
		
		try {
			sf.getCurrentSession().save(category);
			
			return true;
		} catch (Exception e) {
			System.err.println("exception to store "+e);
			return false;		
			}
	}

	@Override
	public boolean update(Category category) {
		try {
			sf.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Category category) {
		category.setActive(false);
		
		try {
			sf.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}		
