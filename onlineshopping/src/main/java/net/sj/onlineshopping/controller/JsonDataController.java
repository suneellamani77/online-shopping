package net.sj.onlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sj.shoppingbackend.dao.ProductDAO;
import net.sj.shoppingbackend.dto.Product;

@Controller
@RequestMapping("/json/data")
public class JsonDataController {

	@Autowired
	private ProductDAO dao;
	
	@RequestMapping(value="/all/products")
	@ResponseBody
	public List<Product> listActiveProducts(){
		return dao.listActiveProducts();
	}
	
	@RequestMapping(value="/admin/all/products")
	@ResponseBody
	public List<Product> getAllProductsForAdmin(){
		return dao.list();
	}
	
	@RequestMapping(value="/category/{id}/products")
	@ResponseBody
	public List<Product> listActiveProductByCategory(@PathVariable int id){
		return dao.listActiveProductByCategory(id);
	}
	
}
