package com.ly.spring.dao;

import java.util.List;

import com.ly.spring.entity.Fenye;
import com.ly.spring.entity.Video;

public interface VideoMapper {
/**
 * 获取音频
 * @param fenye
 * @return
 */
	List<Video> getVideo(Fenye fenye);
	/**
	 * 获取音频数量
	 * @param fenye
	 * @return
	 */
	Integer getVideoCount(Fenye fenye);
	/**
	 * 更新音频信息
	 * @param video
	 * @return
	 */
	Integer editVideoState(Video video);
	/**
	 * 添加音频信息
	 * @param video
	 * @return
	 */
	Integer addVideo(Video video);
	/**
	 * 根据v_vode删除音频信息
	 * @param v_code
	 * @return
	 */
	Integer delViddeoByV_code(String v_code);
	/**
	 * 根据v_code查询
	 * @param v_code
	 * @return
	 */
	Video findVideoByV_code(String v_code);
}
