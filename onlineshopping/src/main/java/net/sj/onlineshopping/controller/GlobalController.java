package net.sj.onlineshopping.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import net.sj.onlineshopping.model.UserModel;
import net.sj.shoppingbackend.dao.userDAO;
import net.sj.shoppingbackend.dto.User;

@ControllerAdvice
public class GlobalController {
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private userDAO uDao;
	
	private UserModel userModel=null;
	
	@ModelAttribute("userModel")
	public UserModel getUserModel(){
			
		if(session.getAttribute("userModel")== null){
			
			Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
			
			System.err.println("------"+authentication.getName());
			User user= uDao.getByEmail(authentication.getName());
			
			if(user!=null){
				userModel = new UserModel();
				
				userModel.setId(user.getId());
				userModel.setFullName(user.getFirstName()+"-"+user.getLastName());
				userModel.setEmail(user.getEmail());
				userModel.setRole(user.getRole());
				
				if(userModel.getRole().equals("USER")){
					userModel.setCart(user.getCart());
				}
				
				session.setAttribute("userModel",userModel);
				return userModel;
			}
			
		}
		
		return (UserModel) session.getAttribute("userModel");
		
	}
	
}
