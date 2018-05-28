package net.sj.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import net.sj.shoppingbackend.dao.ProductDAO;
import net.sj.shoppingbackend.dto.Product;

@Repository("productDAO")
@Transactional(propagation=Propagation.REQUIRED , readOnly=false)
public class ProductDAOImpl implements ProductDAO{

	@Autowired
	private SessionFactory sf;
	
	@Override
	public boolean add(Product product) {
		
		try {
			sf.getCurrentSession().persist(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		
	}

	@Override
	public List<Product> list() {
		return sf.getCurrentSession().
				createQuery("FROM Product",Product.class).getResultList();
	}

	@Override
	public Product get(int productId) {
		return sf.getCurrentSession().get(Product.class, Integer.valueOf(productId));
	}

	@Override
	public boolean update(Product product) {
		try {
			sf.getCurrentSession().update(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean delete(Product product) {
		product.setActive(false);
		try {
			sf.getCurrentSession().update(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Product> listActiveProducts() {
		
		String selectActiveProduct="From Product WHERE active= :active";
		
		return sf.getCurrentSession().
				createQuery(selectActiveProduct,Product.class).setParameter("active", true)
				.getResultList();
	}

	@Override
	public List<Product> listActiveProductByCategory(int categoryId) {
		String listActiveProductByCategory="From Product WHERE active= :active AND categoryId= :categoryId";
		return sf.getCurrentSession().createQuery(listActiveProductByCategory , Product.class)
				.setParameter("active", true).setParameter("categoryId", categoryId).getResultList();
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {
		return sf.getCurrentSession().
				createQuery("FROM Product WHERE active = :active ORDER BY id",Product.class)
				.setParameter("active", true).setFirstResult(0).setMaxResults(count)
				.getResultList();
	}

}
