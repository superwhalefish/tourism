package com.ly.spring.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ly.spring.dao.CategoryDao;
import com.ly.spring.dao.SceneryDao;
import com.ly.spring.entity.Category;
import com.ly.spring.entity.Fenye;
import com.ly.spring.entity.Scenery;
import com.ly.spring.utils.RandomUtil;

@Service
public class CategoryServiceImp implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private RandomUtil randomUtil;
	@Autowired
	private SceneryDao sceneryDao;

	/**
	 * 获取
	 */
	@Override
	public Map<String, Object> getCategory(Fenye fenye) { // TODO Auto-generated method stub
		List<Category> category = categoryDao.getCategory(fenye);
		Integer categoryCount = categoryDao.getCategoryCount(fenye);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", categoryCount);
		map.put("data", category);
		return map;
	}

	/**
	 * 编辑
	 */
	@Override
	public Integer editCategory(Category category) {
		// TODO Auto-generated method stub
		return categoryDao.editCategory(category);
	}

	/**
	 * 刪除
	 */
	@Override
	@Transactional
	public Integer delCategory(Integer id) {
		// TODO Auto-generated method stub
		 String cid = categoryDao.selectCidById(id);
		Integer slist=sceneryDao.selectIsExitByCid(cid);
		Integer i=null;
		if(slist>0) {
			i=0;
		}else {
			i = categoryDao.delCategory(id);
		}
		return i;
	}

	/**
	 * 添加
	 */
	@Override
	public Integer addCategory(Category category) {
		// TODO Auto-generated method stub
		category.setCid(randomUtil.getRand());
		return categoryDao.addCategory(category);
	}

	@Override
	public List<Category> getCategoryAll() {
		// TODO Auto-generated method stub
		return categoryDao.getCategoryAll();
	}


}
