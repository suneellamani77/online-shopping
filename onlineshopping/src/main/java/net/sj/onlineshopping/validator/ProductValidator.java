package net.sj.onlineshopping.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import net.sj.shoppingbackend.dto.Product;

public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Product.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors error) {
		
		Product product=(Product) target;
		
		if(product.getFile()==null || product.getFile().getOriginalFilename().equals("")){
			error.rejectValue("file", null, "Please Select an image file to upload");
			return;
		}
		
		if(!(
				product.getFile().getContentType().equals("image/jpeg") ||
				product.getFile().getContentType().equals("image/jpg") ||
				product.getFile().getContentType().equals("image/gif") ||
				product.getFile().getContentType().equals("image/png") 
			)){
			
			error.rejectValue("file", null, "Please Use Only Image file For Upload");
			return;
			}
		
		
		}

	}

