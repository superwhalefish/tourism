 package com.ly.spring.entity;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
public class Fenye {
private Integer page;
private Integer limit;

//类别名称category
private String cname;

//景点 scenery id
private Integer id;
//景点 scenery名字
private String name;
//景点scenery地区
private String address;
//景点scenery月份
private String month;
//景点scenery备注
private String holiday;
//景点scenery上传时间
private String upstarttime;
//景点scenery上传时间
private String upendtime;
//景点scenery发布时间
private String publishstarttime;
//景点scenery发布时间
private String publishendtime;
//景点scenery下架时间
private String unpublishstarttime;
//景点scenery下架时间
private String unpublishendtime;
//景点scenery发布状态
private String publishstate;

//图片images码
private String imgcode;
private Integer istuijian;



public Integer getIstuijian() {
	return istuijian;
}

public void setIstuijian(Integer istuijian) {
	this.istuijian = istuijian;
}

public String getPublishstate() {
	return publishstate;
}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public void setPublishstate(String publishstate) {
	this.publishstate = publishstate;
}

public String getUpstarttime() {
	return upstarttime;
}

public void setUpstarttime(String upstarttime) {
	this.upstarttime = upstarttime;
}

public String getUpendtime() {
	return upendtime;
}

public void setUpendtime(String upendtime) {
	this.upendtime = upendtime;
}

public String getPublishstarttime() {
	return publishstarttime;
}

public void setPublishstarttime(String publishstarttime) {
	this.publishstarttime = publishstarttime;
}

public String getPublishendtime() {
	return publishendtime;
}

public void setPublishendtime(String publishendtime) {
	this.publishendtime = publishendtime;
}

public String getUnpublishstarttime() {
	return unpublishstarttime;
}

public void setUnpublishstarttime(String unpublishstarttime) {
	this.unpublishstarttime = unpublishstarttime;
}

public String getUnpublishendtime() {
	return unpublishendtime;
}

public void setUnpublishendtime(String unpublishendtime) {
	this.unpublishendtime = unpublishendtime;
}

public String getImgcode() {
	return imgcode;
}

public void setImgcode(String imgcode) {
	this.imgcode = imgcode;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getMonth() {
	return month;
}

public void setMonth(String month) {
	this.month = month;
}

public String getHoliday() {
	return holiday;
}

public void setHoliday(String holiday) {
	this.holiday = holiday;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public Integer getPage() {
	return page;
}

public void setPage(Integer page) {
	this.page = page;
}

public Integer getLimit() {
	return limit;
}

public void setLimit(Integer limit) {
	this.limit = limit;
}

public String getCname() {
	return cname;
}

public void setCname(String cname) {
	this.cname = cname;
}

}
