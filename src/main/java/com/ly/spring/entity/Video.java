package com.ly.spring.entity;

import org.springframework.stereotype.Component;

@Component
public class Video {

	private Integer id;
	private String v_code;
	private String v_time;
	private String v_content;
	private String v_img;
	private String v_state;

	public Video(Integer id, String v_code, String v_time, String v_content, String v_img, String v_state) {
		super();
		this.id = id;
		this.v_code = v_code;
		this.v_time = v_time;
		this.v_content = v_content;
		this.v_img = v_img;
		this.v_state = v_state;
	}
	public Video() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getV_state() {
		return v_state;
	}
	public void setV_state(String v_state) {
		this.v_state = v_state;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getV_code() {
		return v_code;
	}
	public void setV_code(String v_code) {
		this.v_code = v_code;
	}
	public String getV_time() {
		return v_time;
	}
	public void setV_time(String v_time) {
		this.v_time = v_time;
	}
	public String getV_content() {
		return v_content;
	}
	public void setV_content(String v_content) {
		this.v_content = v_content;
	}
	public String getV_img() {
		return v_img;
	}
	public void setV_img(String v_img) {
		this.v_img = v_img;
	}
	@Override
	public String toString() {
		return "Video [id=" + id + ", v_code=" + v_code + ", v_time=" + v_time + ", v_content=" + v_content + ", v_img="
				+ v_img + ", v_state=" + v_state + "]";
	}
	
	
}
