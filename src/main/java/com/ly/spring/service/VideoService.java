package com.ly.spring.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.ly.spring.entity.Fenye;
import com.ly.spring.entity.Video;

public interface VideoService {
	/**
	 * 获取音频
	 * @param fenye
	 * @return
	 */
Map<String,Object> getVideo(Fenye fenye);
/**
 * 更新音频信息
 * @param video
 * @return
 */
	Integer editVideoState(Video video);
	/**
	 * 上传视频
	 * @param file
	 * @param v_content
	 * @return
	 */
Map<String, Object> uploadVideo(MultipartFile file, String v_content);
/**
 * 添加音频信息
 * @param video
 * @return
 */
Integer addVideo(Video video);
/**
 * 根据编号删除音频信息
 * @param v_code
 * @return
 */
Integer delViddeoByV_code(String v_code);
}
