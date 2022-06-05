package com.survey.dto;
// default package

import java.util.Date;


/**
 * Survey entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Survey implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5612405124894422928L;
	// Fields

	private Long SId;
	private Long templet;
	private String SName;
	private String SDesc;
	private String SAuthor;
	private String SImg;
	private Boolean SIpRepeat;
	private Date SCreateDate;
	private String SIpLimitType;
	private String SIpRange;
	private String SPassword;
	private Boolean SIsOpen;
	private Date SExpireDate;
	private Boolean SIsAudited;
	private Long SHits;
	private Long SUsehits;



	
	public Long getSId() {
		return this.SId;
	}

	public void setSId(Long SId) {
		this.SId = SId;
	}

	public Long getTemplet() {
		return this.templet;
	}

	public void setTemplet(Long templet) {
		this.templet = templet;
	}

	public String getSName() {
		return this.SName;
	}

	public void setSName(String SName) {
		this.SName = SName;
	}

	public String getSDesc() {
		return this.SDesc;
	}

	public void setSDesc(String SDesc) {
		this.SDesc = SDesc;
	}

	public String getSAuthor() {
		return this.SAuthor;
	}

	public void setSAuthor(String SAuthor) {
		this.SAuthor = SAuthor;
	}

	public String getSImg() {
		return this.SImg;
	}

	public void setSImg(String SImg) {
		this.SImg = SImg;
	}

	public Boolean getSIpRepeat() {
		return this.SIpRepeat;
	}

	public void setSIpRepeat(Boolean SIpRepeat) {
		this.SIpRepeat = SIpRepeat;
	}

	public Date getSCreateDate() {
		return this.SCreateDate;
	}

	public void setSCreateDate(Date SCreateDate) {
		this.SCreateDate = SCreateDate;
	}

	public String getSIpLimitType() {
		return this.SIpLimitType;
	}

	public void setSIpLimitType(String SIpLimitType) {
		this.SIpLimitType = SIpLimitType;
	}

	public String getSIpRange() {
		return this.SIpRange;
	}

	public void setSIpRange(String SIpRange) {
		this.SIpRange = SIpRange;
	}

 

	public String getSPassword() {
		return this.SPassword;
	}

	public void setSPassword(String SPassword) {
		this.SPassword = SPassword;
	}

	public Boolean getSIsOpen() {
		return this.SIsOpen;
	}

	public void setSIsOpen(Boolean SIsOpen) {
		this.SIsOpen = SIsOpen;
	}

	public Date getSExpireDate() {
		return this.SExpireDate;
	}

	public void setSExpireDate(Date SExpireDate) {
		this.SExpireDate = SExpireDate;
	}

	public Boolean getSIsAudited() {
		return this.SIsAudited;
	}

	public void setSIsAudited(Boolean SIsAudited) {
		this.SIsAudited = SIsAudited;
	}

	public Long getSHits() {
		return this.SHits;
	}

	public void setSHits(Long SHits) {
		this.SHits = SHits;
	}

	public Long getSUsehits() {
		return this.SUsehits;
	}

	public void setSUsehits(Long SUsehits) {
		this.SUsehits = SUsehits;
	}


   public static void main(String args[]){
	   Survey s=new Survey();
	   System.out.println(s.SIpRepeat);
   }

}