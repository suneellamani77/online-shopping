package net.sj.shoppingbackend.dao;

import java.util.List;

import net.sj.shoppingbackend.dto.Category;

public interface CategoryDAO {
	
	List<Category> list();

	Category get(int id);

}
