package net.sj.onlineshopping.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.sj.onlineshopping.util.FileUploadUtility;
import net.sj.onlineshopping.validator.ProductValidator;
import net.sj.shoppingbackend.dao.CategoryDAO;
import net.sj.shoppingbackend.dao.ProductDAO;
import net.sj.shoppingbackend.dto.Category;
import net.sj.shoppingbackend.dto.Product;

@Controller
@RequestMapping("/manage")
public class ManagementController {
	
	
	@Autowired
	private CategoryDAO cDao;
	
	@Autowired
	private ProductDAO pDao;
	
	@RequestMapping(value="/products" , method=RequestMethod.GET)
	public ModelAndView showManageProducts(@RequestParam(name="operation", required=false) String operation){
		
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "Manage Products");
		mv.addObject("userClickManageProducts",true);
		
		if(operation!=null){
			if(operation.equals("product")){
				mv.addObject("message","Product Submitted Successfully");
			}
			else if(operation.equals("category")){
				mv.addObject("message","Category Submitted Successfully");
			}
		}
		
		
		Product nproduct=new Product();
		nproduct.setSupplierId(1);
		nproduct.setActive(true);
		
		mv.addObject("product",nproduct);
		return mv;
		
	}
	
	//////////////////////////
	@RequestMapping(value="/products" , method=RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("product") Product mProduct , BindingResult result, Model model,
			HttpServletRequest request){
		
		if(mProduct.getId()==0){
		new ProductValidator().validate(mProduct, result);
		}
		else{
			if(!mProduct.getFile().getOriginalFilename().equals("")){
				new ProductValidator().validate(mProduct, result);
			}
		}
		
		if(result.hasErrors()){
			model.addAttribute("title", "Manage Products");
			model.addAttribute("userClickManageProducts",true);
			return "page";
		}
		
		if(mProduct.getId()==0){
			pDao.add(mProduct);
		}
		else{
			pDao.update(mProduct);
		}
		
		if(! mProduct.getFile().getOriginalFilename().equals("")){
			FileUploadUtility.uploadFile(request, mProduct.getFile() , mProduct.getCode());
		}
		
		return "redirect:/manage/products?operation=product";
		
	}
	
	@RequestMapping(value="/product/{id}/activation", method=RequestMethod.POST)
	@ResponseBody
	public String handleActivationProduct(@PathVariable("id") int id){
	
		Product product=pDao.get(id);
		boolean isActive=product.isActive();
		
		//activating and deactivating the product based on slider
		product.setActive(!product.isActive());
		
		//updating the product
		pDao.update(product);
		
		return (isActive) ? "You have successfully Deativated the Product with id "+id
						: "You have successfully Activated the Product with id "+id;
		
	}
	
	@RequestMapping(value="/{id}/product" , method=RequestMethod.GET)
	public ModelAndView EditProducts(@PathVariable("id") int id){
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "Manage Products");
		mv.addObject("userClickManageProducts",true);
		
		Product nproduct=pDao.get(id);
		
		mv.addObject("product",nproduct);
		return mv;
	}
	
	
	@ModelAttribute("categories")
	public List<Category> categoryList(){
		return cDao.list();
		
		
	}
	
	@ModelAttribute("category")
	public Category singleCategory(){
		return new Category();
	}
	
	@RequestMapping(value="category" , method=RequestMethod.POST)
	public String handleCategorySubmission(@ModelAttribute Category category){
		
		System.err.println("name: "+category.getName()+"/n" + "description: "+category.getDescription());
		
		cDao.add(category);
		return "redirect:/manage/products?operation=category";
	}
}
