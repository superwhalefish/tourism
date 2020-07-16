package com.ly.spring.dao;

import java.util.List;

import com.ly.spring.entity.Fenye;
import com.ly.spring.entity.Scenery;

public interface SceneryDao {
	/**
	 * 获取数据信息
	 * @param fenye
	 * @return
	 */
List<Scenery> getScenery(Fenye fenye);
/**
 * 获取信息
 * @param fenye
 * @return
 */
Integer getSceneryCount(Fenye fenye);
/**
 * 更新信息
 * @param scenery
 * @return
 */
Integer editScenery(Scenery scenery);
/**
 * 添加信息
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
 * 查询该CID是否存在
 * @param cid
 * @return
 */
Integer selectIsExitByCid(String cid);
/**
 * 根据id查询图片码
 * @param id
 * @return
 */
String selectImgcodeById(Integer id);
/**
 * 查询所有
 * @return
 */
List<Scenery> getSceneryAll();
/**
 * 根据cid查询数据
 * @param cid
 * @return
 */
List<Scenery> vgetSceneryByCid(String cid);
/**
 * 多条件查询
 * @param fenye
 * @return
 */
List<Scenery> getSceneryByFenye(Fenye fenye);
/**
 * 查询scenery
 * @param id
 * @return
 */
Scenery selectSceneryById(Integer id);
}
