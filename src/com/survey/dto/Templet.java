package com.survey.dto;
// default package




/**
 * Templet entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Templet implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9073674919535520998L;
	// Fields

	private Long templetId;
	private String templetName;
	private String templetTop;
	private String templetBody;
	private String templetBottom;
	private boolean templetDefault;
	

	// Constructors

	/** default constructor */
	public Templet() {
	}

	/** minimal constructor */
	public Templet(Long templetId) {
		this.templetId = templetId;
	}

	 
	 

	// Property accessors
	
	public Long getTempletId() {
		return this.templetId;
	}

	public void setTempletId(Long templetId) {
		this.templetId = templetId;
	}

	public String getTempletName() {
		return this.templetName;
	}

	public void setTempletName(String templetName) {
		this.templetName = templetName;
	}

	public String getTempletTop() {
		return this.templetTop;
	}

	public void setTempletTop(String templetTop) {
		this.templetTop = templetTop;
	}

	public String getTempletBody() {
		return this.templetBody;
	}

	public void setTempletBody(String templetBody) {
		this.templetBody = templetBody;
	}

	public String getTempletBottom() {
		return this.templetBottom;
	}

	public void setTempletBottom(String templetBottom) {
		this.templetBottom = templetBottom;
	}


	public boolean getTempletDefault() {
		return this.templetDefault;
	}

	public void setTempletDefault(boolean templetDefault) {
		this.templetDefault = templetDefault;
	}



}