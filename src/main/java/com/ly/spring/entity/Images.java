package com.ly.spring.entity;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
public class Images {
private Integer id;
private String imgcode;
private String imgurl;
private Integer istuijian;
private Scenery scenery;
public Images() {
	super();
	// TODO Auto-generated constructor stub
}

public Images(Integer id, String imgcode, String imgurl, Integer istuijian, Scenery scenery) {
	super();
	this.id = id;
	this.imgcode = imgcode;
	this.imgurl = imgurl;
	this.istuijian = istuijian;
	this.scenery = scenery;
}

public Scenery getScenery() {
	return scenery;
}
public void setScenery(Scenery scenery) {
	this.scenery = scenery;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getImgcode() {
	return imgcode;
}
public void setImgcode(String imgcode) {
	this.imgcode = imgcode;
}
public String getImgurl() {
	return imgurl;
}
public void setImgurl(String imgurl) {
	this.imgurl = imgurl;
}

public Integer getIstuijian() {
	return istuijian;
}

public void setIstuijian(Integer istuijian) {
	this.istuijian = istuijian;
}

@Override
public String toString() {
	return "Images [id=" + id + ", imgcode=" + imgcode + ", imgurl=" + imgurl + ", istuijian=" + istuijian
			+ ", scenery=" + scenery + "]";
}

}
