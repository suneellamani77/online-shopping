package net.sj.onlineshopping.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.sj.onlineshopping.exception.ProductNotFoundException;
import net.sj.shoppingbackend.dao.CategoryDAO;
import net.sj.shoppingbackend.dao.ProductDAO;
import net.sj.shoppingbackend.dto.Category;
import net.sj.shoppingbackend.dto.Product;


@Controller
public class PageController {
	
	
	private static final Logger logger=LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO dao;
	
	@RequestMapping(value={"/","/home","/index"})
	public ModelAndView index(){
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "Home");
		mv.addObject("categories", categoryDAO.list());
		
		logger.info("inside pageController index method --INFO");
		logger.debug("inside pageController index method --DEBUG");
		
		mv.addObject("userClicksHome", true);
		return mv;
	}
	
	@RequestMapping(value={"/about"})
	public ModelAndView about(){
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("userClicksAbout", true);
		return mv;
	}
	
	@RequestMapping(value={"/contact"})
	public ModelAndView contact(){
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClicksContact", true);
		return mv;
	}
	
	/** methods to load all the products based on the category 
	 **/
	
	@RequestMapping(value="/show/all/products")
	public ModelAndView showAllProducts(){
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "All Products");
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClicksAllProducts", true);
		return mv;
	}
	
	@RequestMapping(value="/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id){
		// CategoryDao to fetch the single category
		Category category=null;
		
		category=categoryDAO.get(id);
		System.out.println("----"+category.getDescription());
		
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", category.getName());
		//passing list of all categoriese
		mv.addObject("categories", categoryDAO.list());
		
		//passing single categories
		mv.addObject("category", category);
		
		mv.addObject("userClicksCategoryProducts", true);
		return mv;
	}
	
	@RequestMapping(value="/show/{id}/product")
	public ModelAndView showProductByCategory(@PathVariable int id) throws ProductNotFoundException{
		
		ModelAndView mv= new ModelAndView("page");
		
		Product product=dao.get(id);
		
		if(product == null) throw new ProductNotFoundException();
		
		/* Update the views */
		product.setViews(product.getViews() +1);
		dao.update(product);
		
		mv.addObject("title", product.getName());
		mv.addObject("product", product);
		mv.addObject("userClickShowProduct", true);
		
		return mv;
	}
	
	/* having similar mapping to flow id */
	@RequestMapping(value={"/register"})
	public ModelAndView register(){
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "About Us");
		return mv;
	}
	
	
}
