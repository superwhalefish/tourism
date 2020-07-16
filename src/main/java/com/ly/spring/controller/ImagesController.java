package com.ly.spring.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ly.spring.entity.Fenye;
import com.ly.spring.entity.Images;
import com.ly.spring.service.ImagesService;

@RestController
public class ImagesController {
	@Autowired
	private Fenye fenye;
	@Autowired
	private ImagesService imagesService;

	@PostMapping("getImages")
	public Map<String, Object> getImages(Integer page, Integer limit, String name, String imgcode,Integer istuijian) {
		fenye.setPage((page - 1) * limit);
		fenye.setLimit(limit);
		fenye.setName(name);
		fenye.setIstuijian(istuijian);
		fenye.setImgcode(imgcode);
		return imagesService.getImages(fenye);

	}

	@PostMapping("addImgs")
	public Map<String,Object> addImgs(MultipartFile file,String imgcode) {
		return imagesService.addImgs(file,imgcode);

	}

	@PostMapping("delImgByid")
	public Integer delImgByid(Integer id) {
		return imagesService.delImgByid(id);

	}
	@PostMapping("editImage")
	public Integer editImage(Images images) {
		
		return imagesService.editImage(images);
		
	}
}
