package com.ly.spring.dao;

import java.util.List;

import com.ly.spring.entity.Category;
import com.ly.spring.entity.Fenye;

public interface CategoryDao {
	/**
	 * 条件查询
	 * @param cname
	 * @return
	 */
List<Category> getCategory(Fenye fenye);
/**
 * 查询总数
 * @param fenye
 * @return
 */
Integer getCategoryCount(Fenye fenye);
/**
 * 编辑类别信息
 * @param category
 * @return
 */
Integer editCategory(Category category);
/**
 * 刪除
 * @param id
 * @return
 */
Integer delCategory(Integer id);
/**
 * 添加
 * @param category
 * @return
 */
Integer addCategory(Category category);
/**
 * 查询种类
 * @return
 */
List<Category> getCategoryAll();
/**
 * 查询CID
 * @param id
 * @return
 */
String selectCidById(Integer id);
}
