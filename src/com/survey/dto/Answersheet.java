package com.survey.dto;
// default package

import java.util.Date;


/**
 * Answersheet entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Answersheet implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -6674115427028303102L;
	private Long asId;
	private Long survey;
	private String asResult;
	private Date asPostdate;
	private String asUserIp;

	// Constructors

	/** default constructor */
	public Answersheet() {
	}

	/** minimal constructor */
	public Answersheet(Long asId, Long survey) {
		this.asId = asId;
		this.survey = survey;
	}

	/** full constructor */
	public Answersheet(Long asId, Long survey, String asResult,
			Date asPostdate, String asUserIp) {
		this.asId = asId;
		this.survey = survey;
		this.asResult = asResult;
		this.asPostdate = asPostdate;
		this.asUserIp = asUserIp;
	}

	// Property accessors

	public Long getAsId() {
		return this.asId;
	}

	public void setAsId(Long asId) {
		this.asId = asId;
	}

	public Long getSurvey() {
		return this.survey;
	}

	public void setSurvey(Long survey) {
		this.survey = survey;
	}


	public String getAsResult() {
		return this.asResult;
	}

	public void setAsResult(String asResult) {
		this.asResult = asResult;
	}

	
	public Date getAsPostdate() {
		return this.asPostdate;
	}

	public void setAsPostdate(Date asPostdate) {
		this.asPostdate = asPostdate;
	}

	
	public String getAsUserIp() {
		return this.asUserIp;
	}

	public void setAsUserIp(String asUserIp) {
		this.asUserIp = asUserIp;
	}

}