package net.sj.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import net.sj.shoppingbackend.dao.userDAO;
import net.sj.shoppingbackend.dto.Address;
import net.sj.shoppingbackend.dto.Cart;
import net.sj.shoppingbackend.dto.User;

@Repository("userDAO")
@Transactional(propagation=Propagation.REQUIRED , readOnly=false)
public class userDAOImpl implements userDAO{

	@Autowired
	private SessionFactory sf;

	@Override
	public boolean addUser(User user) {
		try {
			sf.getCurrentSession().save(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean addAddress(Address address) {
		try {
			sf.getCurrentSession().save(address);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateCart(Cart cart) {
		try {
			sf.getCurrentSession().update(cart);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public User getByEmail(String email) {
		String selectQuery="FROM User where email= :email";
		try {
			return (User) sf.getCurrentSession().createQuery(selectQuery, User.class).
			setParameter("email",email).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public Address getBillingAddress(User user) {
		String selectQuery="FROM Address WHERE user= :user AND billing= :billing";
		try {
			return sf.getCurrentSession().createQuery(selectQuery , Address.class).
					setParameter("user",user).setParameter("billing", true).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Address> listShippingAddress(User user) {
		String selectQuery="FROM Address WHERE user= :user AND shipping= :shipping";
		try {
			return sf.getCurrentSession().createQuery(selectQuery , Address.class).
					setParameter("user",user).setParameter("shipping", true).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}	}
	
}
