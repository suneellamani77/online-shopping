package net.sj.shoppingbackend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.sj.shoppingbackend.dao.userDAO;
import net.sj.shoppingbackend.dto.Address;
import net.sj.shoppingbackend.dto.Cart;
import net.sj.shoppingbackend.dto.User;

public class UserTestCase {
	
	private static AnnotationConfigApplicationContext context;
	private static userDAO userDAO;
	private User user=null;
	private Address address=null;
	private Cart cart=null;
	
	@BeforeClass
	public static void init(){
		
		context = new AnnotationConfigApplicationContext();
		context.scan("net.sj.shoppingbackend");
		context.refresh();
		
		userDAO= (userDAO) context.getBean("userDAO");
		
	}
	
	/*@Test
	public void testAdd(){
		
		user= new User();
		user.setFirstName("Hrithik");
		user.setLastName("Roshan");
		user.setEmail("hr@gmail.com");
		user.setContactNumber("1234512345");
		user.setRole("USER");
		user.setPassword("123456");
		
		// add the user
		assertEquals("failed to add user!!", true,userDAO.addUser(user));
		
		address= new Address();
		address.setAddressLineOne("101/B Jadoo soceity, Krishh Nagar");
		address.setAddressLineTwo("Near kabali Store");
		address.setCity("Mumbai");
		address.setState("Maharastra");
		address.setCountry("India");
		address.setPostalCode("400001");
		address.setBilling(true);
		
		//link user with address
		address.setUserId(user.getId());
		
		//add the address
		assertEquals("failed to add address!!",true, userDAO.addAddress(address));
		
		if(user.getRole().equals("USER")){
			//create cart for this user
			cart= new Cart();
			cart.setUser(user);
			
			//add the cart
			assertEquals("failed to add cart!!", true,userDAO.addCart(cart));
			
			address= new Address();
			address.setAddressLineOne("101/B Jadoo soceity, Krishh Nagar");
			address.setAddressLineTwo("Near kabali Store");
			address.setCity("Mumbai");
			address.setState("Maharastra");
			address.setCountry("India");
			address.setPostalCode("400001");
			
			//set shipping 
			address.setShipping(true);
			
			//link user with address
			address.setUserId(user.getId());
			
			//add the address
			assertEquals("failed to add address!!",true, userDAO.addAddress(address));
			
			
		}
		
		
	}
*/
	
	/*@Test
	public void testAdd(){
		
		user= new User();
		user.setFirstName("Hrithik");
		user.setLastName("Roshan");
		user.setEmail("hr@gmail.com");
		user.setContactNumber("1234512345");
		user.setRole("USER");
		user.setPassword("123456");
		
		
		
		if(user.getRole().equals("USER")){
			//create cart for this user
			cart= new Cart();
			cart.setUser(user);
			
			//add the cart
			assertEquals("failed to add cart!!", true,userDAO.addCart(cart));
			
			//attach the cart with user
			user.setCart(cart);
			
			
		}
		
		
		// add the user
			assertEquals("failed to add user!!", true,userDAO.addUser(user));
		
	}*/
	
	/*@Test
	public void testUpdateCart(){
		
		user=userDAO.getByEmail("hr@gmail.com");
		cart=user.getCart();
		
		// set the values for cart
		
		cart.setGrandTotal(5555);
		cart.setCartLines(2);
		
		assertEquals("failed to Update the cart!!!",true ,userDAO.updateCart(cart));
		
	}*/
	
	
	/*@Test
	public void testAddress(){
		/// we need to add the user  
			user= new User();
			user.setFirstName("Hrithik");
			user.setLastName("Roshan");
			user.setEmail("hr@gmail.com");
			user.setContactNumber("1234512345");
			user.setRole("USER");
			user.setPassword("123456");
			
			// add the user
			assertEquals("failed to add user!!", true,userDAO.addUser(user));
		
		///  we need to add the address
			address= new Address();
			address.setAddressLineOne("101/B Jadoo soceity, Krishh Nagar");
			address.setAddressLineTwo("Near kabali Store");
			address.setCity("Mumbai");
			address.setState("Maharastra");
			address.setCountry("India");
			address.setPostalCode("400001");
			address.setBilling(true);
			
			//link user with address
			address.setUser(user);
			
			//add the address
			assertEquals("failed to add address!!",true, userDAO.addAddress(address));
		
		/// we need to add the address with the shipping
			address= new Address();
			address.setAddressLineOne("201/B Jadoo soceity, Krishh Nagar");
			address.setAddressLineTwo("Near kabali Store");
			address.setCity("Mumbai");
			address.setState("Maharastra");
			address.setCountry("India");
			address.setPostalCode("400001");
			
			//set shipping 
			address.setShipping(true);
			
			//link user with address
			address.setUser(user);
			
			//add the address
			assertEquals("failed to add address!!",true, userDAO.addAddress(address));
		
		
	}*/
	
	/*@Test
	public void testAddAdress(){
		
		user=userDAO.getByEmail("hr@gmail.com");
		
		/// we need to add the address with the shipping
		address= new Address();
		address.setAddressLineOne("301/B Jadoo soceity, Krishh Nagar");
		address.setAddressLineTwo("Near kabali Store");
		address.setCity("Bangalore");
		address.setState("Karnataka");
		address.setCountry("India");
		address.setPostalCode("400002");
		
		//set shipping 
		address.setShipping(true);
		
		//link user with address
		address.setUser(user);
		
		//add the address
		assertEquals("failed to add address!!",true, userDAO.addAddress(address));
		
	}*/
	
	@Test
	public void testGetAddresses(){
		
		user=userDAO.getByEmail("hr@gmail.com");
		
		assertEquals("failed to fetch list of shipping adress, size does not match", 2,userDAO.listShippingAddress(user).size());
		
		
		assertEquals("failed to fetch billing adress, size does not match", "Mumbai",userDAO.getBillingAddress(user).getCity());
	}

	
	
}
