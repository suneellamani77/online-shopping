package net.sj.shoppingbackend.dao;

import java.util.List;

import net.sj.shoppingbackend.dto.Address;
import net.sj.shoppingbackend.dto.Cart;
import net.sj.shoppingbackend.dto.User;

public interface userDAO {
	
	boolean addUser(User user);
	
	boolean addAddress(Address address);
	Address getBillingAddress(User user);
	List<Address> listShippingAddress(User user);
	
	boolean updateCart(Cart cart);
	
	User getByEmail(String email);
}
