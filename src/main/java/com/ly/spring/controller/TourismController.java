package com.ly.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ly.spring.entity.Category;
import com.ly.spring.entity.Fenye;
import com.ly.spring.entity.Images;
import com.ly.spring.entity.Scenery;
import com.ly.spring.service.CategoryService;
import com.ly.spring.service.ImagesService;
import com.ly.spring.service.SceneryService;


@CrossOrigin
@RestController
public class TourismController {
	@Autowired
	private ImagesService imagesService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private SceneryService sceneryService;
	@Autowired
	private Fenye fenye;

	@PostMapping("lb/getlunbo")
	public List<Images> getlunbo() {
		return imagesService.getlunbo();

	}

	// 无条件获取category数据
	@PostMapping("ly/vgetcategory")
	public List<Category> vgetcategoryandscenery() {
		return categoryService.getCategoryAll();
	}

	// 无条件获取scenery数据
	@PostMapping("ly/vgetSceneryAll")
	public List<Scenery> vgetScenery() {
		return sceneryService.getSceneryAll();
	}

//
	@PostMapping("ly/vgetSceneryByCid")
	public List<Scenery> vgetSceneryByCid(String cid) {
		return sceneryService.vgetSceneryByCid(cid);
	}

//前台  更多查询
	@PostMapping("ly/searchScenery")
	public List<Scenery> searchScenery(String name, String address, String month, String about) {
		fenye.setName(name);
		fenye.setAddress(address);
		fenye.setMonth(month);
		fenye.setHoliday(about);
		return sceneryService.vGetSceneryAll(fenye);
	}
}
