package com.ly.spring.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.ly.spring.entity.Fenye;
import com.ly.spring.entity.Scenery;

public interface SceneryService {
	/**
	 * 获取景点数据
	 * 
	 * @param fenye
	 * @return
	 */
	Map<String, Object> getScenery(Fenye fenye);

	/**
	 * 编辑信息
	 * 
	 * @param scenery
	 * @return
	 */
	Integer editScenery(Scenery scenery);

	/**
	 * 添加信息 
	 * 
	 * @param scenery
	 * @return
	 */
	Integer addScenery(Scenery scenery);
/**
 * 删除
 * @param id
 * @return
 */
	Integer delScenery(Integer id);
/**
 * 上传图片
 * @param file
 * @param id
 * @return
 */
Map<String, Object> uploadSceneryImages(MultipartFile file, Integer id);

/**
 * 查询所有
 * @return
 */
List<Scenery> getSceneryAll();
/**
 * 根据编码获取景点信息
 * @param cid
 * @return
 */
List<Scenery> vgetSceneryByCid(String cid);
/**
 * 前台/更多查询
 * @param fenye
 * @return
 */
List<Scenery> vGetSceneryAll(Fenye fenye);

}
