package com.survey.dto;
// default package

import java.util.Date;

/**
 * Guestbook entity.
 * 
 * @author MyEclipse Persistence Tools
 */
public class Guestbook implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5943310635229298222L;
	// Fields

	/**
	 * 
	 */
	
	private Long gbId;
	private String gbUser;
	private String gbContent;
	private String gbPhone;
	private String gbQq;
	private String gbEmail;
	private Date gbPostdate;

	// Constructors

	/** default constructor */
	public Guestbook() {
	}

	/** minimal constructor */
	public Guestbook(Long gbId) {
		this.gbId = gbId;
	}

	/** full constructor */
	public Guestbook(Long gbId, String gbUser, String gbContent,
			String gbPhone, String gbQq, String gbEmail, Date gbPostdate) {
		this.gbId = gbId;
		this.gbUser = gbUser;
		this.gbContent = gbContent;
		this.gbPhone = gbPhone;
		this.gbQq = gbQq;
		this.gbEmail = gbEmail;
		this.gbPostdate = gbPostdate;
	}

	// Property accessors
	
	public Long getGbId() {
		return this.gbId;
	}

	public void setGbId(Long gbId) {
		this.gbId = gbId;
	}

	
	public String getGbUser() {
		return this.gbUser;
	}

	public void setGbUser(String gbUser) {
		this.gbUser = gbUser;
	}

	
	public String getGbContent() {
		return this.gbContent;
	}

	public void setGbContent(String gbContent) {
		this.gbContent = gbContent;
	}

	
	public String getGbPhone() {
		return this.gbPhone;
	}

	public void setGbPhone(String gbPhone) {
		this.gbPhone = gbPhone;
	}

	
	public String getGbQq() {
		return this.gbQq;
	}

	public void setGbQq(String gbQq) {
		this.gbQq = gbQq;
	}

	
	public String getGbEmail() {
		return this.gbEmail;
	}

	public void setGbEmail(String gbEmail) {
		this.gbEmail = gbEmail;
	}

	
	public Date getGbPostdate() {
		return this.gbPostdate;
	}

	public void setGbPostdate(Date gbPostdate) {
		this.gbPostdate = gbPostdate;
	}

}