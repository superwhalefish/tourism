package com.ly.spring.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ly.spring.entity.Category;
import com.ly.spring.entity.Fenye;
import com.ly.spring.service.CategoryService;

@RestController
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private Fenye fenye;

	/**
	 * 获取类别信息
	 * 
	 * @param page
	 * @param limit
	 * @param cname
	 * @return
	 */
	@PostMapping("getCategory")
	public Map<String, Object> getCategory(Integer page, Integer limit, String cname) {
		fenye.setPage((page - 1) * limit);
		fenye.setLimit(limit);
		fenye.setCname(cname);
		System.out.println(fenye);
		return categoryService.getCategory(fenye);

	}

	/**
	 * 查询类别
	 * 
	 * @return
	 */
	@PostMapping("getCategoryAll")
	public List<Category> getCategoryAll() {
		return categoryService.getCategoryAll();

	}

	/**
	 * 更新类别信息
	 * 
	 * @param category
	 * @return
	 */
	@PostMapping("editCategory")
	public Integer editCategory(Category category) {
		return categoryService.editCategory(category);

	};

	/**
	 * 删除类别
	 * 
	 * @param id
	 * @return
	 */
	@PostMapping("delCategory")
	public Integer delCategory(Integer id) {

		return categoryService.delCategory(id);

	}

	@PostMapping("addCategory")
	public Integer addCategory(Category category) {

		return categoryService.addCategory(category);

	}
}
