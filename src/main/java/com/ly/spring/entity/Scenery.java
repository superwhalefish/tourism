package com.ly.spring.entity;

import org.springframework.stereotype.Component;


@Component
public class Scenery {
private Integer id;
private String name;
private String content;
private String simg;
private String imgcode;
private String cid;
private String address;
private String month;
private String holiday;
private String uptime;
private String publishtime;
private String unpublishtime;
private String publishstate;
private String linkman;
private String tel;
private String car;
private String bus;

private Category category;
public Scenery() {
	super();
	// TODO Auto-generated constructor stub
}


public Scenery(Integer id, String name, String content, String simg, String imgcode, String cid, String address,
		String month, String holiday, String uptime, String publishtime, String unpublishtime, String publishstate,
		String linkman, String tel, String car, String bus, Category category) {
	super();
	this.id = id;
	this.name = name;
	this.content = content;
	this.simg = simg;
	this.imgcode = imgcode;
	this.cid = cid;
	this.address = address;
	this.month = month;
	this.holiday = holiday;
	this.uptime = uptime;
	this.publishtime = publishtime;
	this.unpublishtime = unpublishtime;
	this.publishstate = publishstate;
	this.linkman = linkman;
	this.tel = tel;
	this.car = car;
	this.bus = bus;
	this.category = category;
}


public String getLinkman() {
	return linkman;
}


public void setLinkman(String linkman) {
	this.linkman = linkman;
}


public String getTel() {
	return tel;
}


public void setTel(String tel) {
	this.tel = tel;
}


public String getCar() {
	return car;
}


public void setCar(String car) {
	this.car = car;
}


public String getBus() {
	return bus;
}


public void setBus(String bus) {
	this.bus = bus;
}


public String getUptime() {
	return uptime;
}
public void setUptime(String uptime) {
	this.uptime = uptime;
}
public String getPublishtime() {
	return publishtime;
}
public void setPublishtime(String publishtime) {
	this.publishtime = publishtime;
}
public String getUnpublishtime() {
	return unpublishtime;
}
public void setUnpublishtime(String unpublishtime) {
	this.unpublishtime = unpublishtime;
}
public String getPublishstate() {
	return publishstate;
}
public void setPublishstate(String publishstate) {
	this.publishstate = publishstate;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public String getSimg() {
	return simg;
}
public void setSimg(String simg) {
	this.simg = simg;
}
public String getImgcode() {
	return imgcode;
}
public void setImgcode(String imgcode) {
	this.imgcode = imgcode;
}
public String getCid() {
	return cid;
}
public void setCid(String cid) {
	this.cid = cid;
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
public Category getCategory() {
	return category;
}

public void setCategory(Category category) {
	this.category = category;
}


@Override
public String toString() {
	return "Scenery [id=" + id + ", name=" + name + ", content=" + content + ", simg=" + simg + ", imgcode=" + imgcode
			+ ", cid=" + cid + ", address=" + address + ", month=" + month + ", holiday=" + holiday + ", uptime="
			+ uptime + ", publishtime=" + publishtime + ", unpublishtime=" + unpublishtime + ", publishstate="
			+ publishstate + ", linkman=" + linkman + ", tel=" + tel + ", car=" + car + ", bus=" + bus + ", category="
			+ category + "]";
}


}
