package com.ly.spring.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ly.spring.entity.Fenye;
import com.ly.spring.entity.Scenery;
import com.ly.spring.service.SceneryService;

@RestController
public class SceneryController {
	@Autowired
	private SceneryService sceneryService;
	@Autowired
	private Fenye fenye;

	@PostMapping("getScenery")
	public Map<String, Object> getScenery(Integer page, Integer limit,Fenye fenye) {
		fenye.setPage((page-1)*limit);
		fenye.setLimit(limit);
		return sceneryService.getScenery(fenye);
	}
	@PostMapping("getSceneryAll")
	public List<Scenery> getSceneryAll(){
		return sceneryService.getSceneryAll();
		
	}
	@PostMapping("editScenery")
	public Integer editScenery(Scenery scenery) {
		return sceneryService.editScenery(scenery);
		
	}
	@PostMapping("addScenery")
	public Integer addScenery(Scenery scenery) {
		return sceneryService.addScenery(scenery);
		
	}
	@PostMapping("delScenery")
	public Integer delScenery(Integer id) {
		return sceneryService.delScenery(id);
		
	}
	@PostMapping("uploadSceneryImages")
	public Map<String,Object> uploadSceneryImages(MultipartFile file,Integer id){
		
		return sceneryService.uploadSceneryImages(file,id);
		
	}
}
