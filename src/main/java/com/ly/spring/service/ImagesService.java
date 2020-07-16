package com.ly.spring.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.ly.spring.entity.Fenye;
import com.ly.spring.entity.Images;

public interface ImagesService {
	/**
	 * 获取图片数据
	 * 
	 * @param fenye
	 * @return
	 */
	public Map<String, Object> getImages(Fenye fenye);

	/**
	 * 图片删除
	 * 
	 * @param id
	 * @return
	 */
	Integer delImgByid(Integer id);

	/**
	 * 添加图片
	 * 
	 * @param file
	 * @param imgcode
	 * @return
	 */
	public Map<String, Object> addImgs(MultipartFile file, String imgcode);

	/**
	 * 设置轮播图
	 * 
	 * @param images
	 * @return
	 */
	public Integer editImage(Images images);

	/**
	 * 前端/获取轮播图
	 * 
	 * @return
	 */
	public List<Images> getlunbo();
/**
 * 删除图片
 * @param imgcode
 * @return
 */
	public Integer delImgByImgCode(String imgcode);
}
