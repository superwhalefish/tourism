package com.ly.spring.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ly.spring.entity.Fenye;
import com.ly.spring.entity.Video;
import com.ly.spring.service.VideoService;

@RestController
public class VideoController {
	@Autowired
	private VideoService videoService;
	@Autowired
	private Fenye fenye;

	@PostMapping("/admin/getVideo")
	public Map<String, Object> getVideo(Integer page, Integer limit, String state, String v_code, String v_time) {
		fenye.setPage((page - 1) * limit);
		fenye.setLimit(limit);
		fenye.setV_code(v_code);
		fenye.setV_time(v_time);
		fenye.setState(state);
		return videoService.getVideo(fenye);

	}

	@PostMapping("/admin/editVideoState")
	public Integer editVideoState(Video video) {
		return videoService.editVideoState(video);

	}  

	@PostMapping("/admin/addVideo")
	public Map<String, Object> uploadVideo(MultipartFile file, String v_content) {
		return videoService.uploadVideo(file, v_content);
	}

	@PostMapping("/admin/updateV_contentByV_code")
	public Integer updateV_contentByV_code(Video video) {
		return videoService.editVideoState(video);

	}
@PostMapping("/admin/delViddeoByV_code")
	public Integer delViddeoByV_code(String v_code) {
	
	
		return videoService.delViddeoByV_code(v_code);
		
	}
}
