package net.sj.onlineshopping.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

import net.sj.onlineshopping.model.RegisterModel;
import net.sj.shoppingbackend.dao.userDAO;
import net.sj.shoppingbackend.dto.Address;
import net.sj.shoppingbackend.dto.Cart;
import net.sj.shoppingbackend.dto.User;

@Component
public class RegisterHandler {
	
	@Autowired
	private userDAO uDao;

	public RegisterModel init(){
		return new RegisterModel();
	}
	
	public void addUser(RegisterModel model, User user){
		model.setUser(user);
	}
	
	
	public String validateUser(User user , MessageContext error){
		
		String transitionValue="success";
		
		// checking if password matches confirmPassword
		if((!user.getPassword().equals(user.getConfirmPassword()))){
			error.addMessage(new MessageBuilder()
					.error().source("confirmPassword")
					.defaultText("Password does not Match!!")
					.build());
			
			transitionValue="failure";
		}
		
		// check the uniqueness email id
		if(uDao.getByEmail(user.getEmail())!=null){
			
			error.addMessage(new MessageBuilder()
					.error().source("email")
					.defaultText("Email address is already used!!")
					.build());
			
			transitionValue="failure";
			
		}
		
		
		
		return transitionValue;
		
	}
	
	public void addBilling(RegisterModel model, Address billing){
		model.setBilling(billing);;
	}
	
	public String saveAll(RegisterModel model){
		String transitionValue="success";
		
		// fetch the user
		
		User user=model.getUser();
		
		if(user.getRole().equals("USER")){
			
			Cart cart=new Cart();
			cart.setUser(user);
			
			user.setCart(cart); 
		}
		
		// save the user
		uDao.addUser(user);
		
		
		// fetch the address
		
		Address billing=model.getBilling();
		billing.setUser(user);
		billing.setBilling(true);
		
		//save the address
		uDao.addAddress(billing);
		
		
		
		return transitionValue;
	}
	
}
