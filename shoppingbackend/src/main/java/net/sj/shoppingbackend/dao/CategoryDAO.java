package net.sj.shoppingbackend.dao;

import java.util.List;

import net.sj.shoppingbackend.dto.Category;

public interface CategoryDAO {
	
	boolean add(Category category);
	
	List<Category> list();

	Category get(int id);

}
