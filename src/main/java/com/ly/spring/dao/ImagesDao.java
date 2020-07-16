package com.ly.spring.dao;

import java.util.List;

import com.ly.spring.entity.Fenye;
import com.ly.spring.entity.Images;

public interface ImagesDao {
	/**
	 * 获取图片
	 * @param fenye
	 * @return
	 */
List<Images> getImgs(Fenye fenye);
/**
 * 查询总条数
 * @param fenye
 * @return
 */
Integer getImgsCount(Fenye fenye);
/**
 * 添加图片
 * @param imgurl
 * @param imgcode
 * @return
 */
Integer addImgs(Images images);
/**
 * 图片删除
 * @param id
 * @return
 */
Integer delImgByid(Integer id);
/**
 * 根据编码删除图片
 * @param selectImgcodeById
 * @return
 */
Integer delImgByImgCode(String imgcode);
/**
 * 设置为轮播图
 * @param images
 * @return
 */
Integer editImage(Images images);
/**
 * 获取轮播图
 * @return
 */
List<Images> getlunbo();
/**
 * 根据imgcode查询备用图片
 * @param imgcode
 * @return
 */
List<Images> findImgByImgCode(String imgcode);
/**
 * 根据id查询
 * @param id
 * @return
 */
Images findImgById(Integer id);
}
