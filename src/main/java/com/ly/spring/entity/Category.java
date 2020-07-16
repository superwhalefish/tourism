package com.ly.spring.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
public class Category {
	private Integer id;
	private String cid;
	private String cname;
//private List<Scenery> scenery;
	private Scenery scenery;

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(Integer id, String cid, String cname, Scenery scenery) {
		super();
		this.id = id;
		this.cid = cid;
		this.cname = cname;
		this.scenery = scenery;
	}

	/*
	 * public Category(Integer id, String cid, String cname, List<Scenery> scenery)
	 * { super(); this.id = id; this.cid = cid; this.cname = cname; this.scenery =
	 * scenery; }
	 */
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCid() {
		return cid;
	}

	public Scenery getScenery() {
		return scenery;
	}

	public void setScenery(Scenery scenery) {
		this.scenery = scenery;
	}

	/*
	 * public List<Scenery> getScenery() { return scenery; }
	 * 
	 * public void setScenery(List<Scenery> scenery) { this.scenery = scenery; }
	 */
	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", cid=" + cid + ", cname=" + cname + ", scenery=" + scenery + "]";
	}


}
