package com.ly.spring.service;

import java.util.List;
import java.util.Map;

import com.ly.spring.entity.Category;
import com.ly.spring.entity.Fenye;

public interface CategoryService {
	/**
	 * 获取类别数据
	 * 
	 * @return
	 */
	public Map<String, Object> getCategory(Fenye fenye);

	/**
	 * 修改信息
	 * 
	 * @param category
	 * @return
	 */
	public Integer editCategory(Category category);

	/**
	 * 删除类别信息
	 * 
	 * @param id
	 * @return
	 */
	public Integer delCategory(Integer id);

	/**
	 * 添加信息
	 * 
	 * @param category
	 * @return
	 */
	public Integer addCategory(Category category);
/**
 * 查询数据
 * @return
 */
	public List<Category> getCategoryAll();
}
