package com.ly.spring.service;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ly.spring.entity.Fenye;
import com.ly.spring.entity.Video;
import com.ly.spring.dao.VideoMapper;
import com.ly.spring.utils.RandomUtil;
import com.ly.spring.utils.UploadFileUtil;

@Service
public class VideoServiceImp implements VideoService {
	@Autowired
	private VideoMapper videoMapper;
	@Autowired
	private UploadFileUtil uploadFileUtil;
	@Autowired
	private RandomUtil randomUtil;

	@Override
	public Map<String, Object> getVideo(Fenye fenye) {
		// TODO Auto-generated method stub
		List<Video> video = videoMapper.getVideo(fenye);
		Integer videoCount = videoMapper.getVideoCount(fenye);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("data", video);
		map.put("count", videoCount);
		return map;
	}

	@Override
	public Integer editVideoState(Video video) {
		// TODO Auto-generated method stub
		return videoMapper.editVideoState(video);
	}

	@Override
	@Transactional
	public Map<String, Object> uploadVideo(MultipartFile file, String v_content) {
		// TODO Auto-generated method stub
		Map<String, Object> uploadFile = uploadFileUtil.uploadFile(file);
		String newTime = randomUtil.getRand();
		String newTime2 = randomUtil.getNewTime();
		String y_url = (String) uploadFile.get("getUrl");
		Video video = new Video();
		video.setV_code(newTime);
		video.setV_state("2");
		video.setV_img(y_url);
		video.setV_time(newTime2);
		video.setV_content(v_content);
		addVideo(video);
		return uploadFile;
	}

	@Override
	@Async
	public Integer addVideo(Video video) {
		// TODO Auto-generated method stub
		return videoMapper.addVideo(video);
	}

	@Override
	public Integer delViddeoByV_code(String v_code) {
		// TODO Auto-generated method stub
		 Video video= videoMapper.findVideoByV_code(v_code);
		 File file = new File("E:\\expert\\mp4\\"+video.getV_img());
		 uploadFileUtil.delFile(file);
		return videoMapper.delViddeoByV_code(v_code);
	}


}
