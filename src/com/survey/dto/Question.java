package com.survey.dto;
// default package



/**
 * Question entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class Question implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4179328348522550986L;
	// Fields

	private Long QId;
	private Long survey;
	private Long QType;
	private String QHead;
	private String QBody;
	private String QResult;
	private String QImg;
	private String QJdtz;
	private Long QOrder;

	// Constructors

	/** default constructor */
	public Question() {
	}

	/** minimal constructor */
	public Question(Long QId, Long survey) {
		this.QId = QId;
		this.survey = survey;
	}

	/** full constructor */
	public Question(Long QId, Long survey, Long QType, String QHead,
			String QBody, String QResult, String QImg, String QJdtz, Long QOrder) {
		this.QId = QId;
		this.survey = survey;
		this.QType = QType;
		this.QHead = QHead;
		this.QBody = QBody;
		this.QResult = QResult;
		this.QImg = QImg;
		this.QJdtz = QJdtz;
		this.QOrder = QOrder;
	}

	// Property accessors

	public Long getQId() {
		return this.QId;
	}

	public void setQId(Long QId) {
		this.QId = QId;
	}

	public Long getSurvey() {
		return this.survey;
	}

	public void setSurvey(Long survey) {
		this.survey = survey;
	}

	
	public Long getQType() {
		return this.QType;
	}

	public void setQType(Long QType) {
		this.QType = QType;
	}


	public String getQHead() {
		return this.QHead;
	}

	public void setQHead(String QHead) {
		this.QHead = QHead;
	}
	
	public String getQBody() {
		return this.QBody;
	}

	public void setQBody(String QBody) {
		this.QBody = QBody;
	}

	
	public String getQResult() {
		return this.QResult;
	}

	public void setQResult(String QResult) {
		this.QResult = QResult;
	}

	
	public String getQImg() {
		return this.QImg;
	}

	public void setQImg(String QImg) {
		this.QImg = QImg;
	}

	
	public String getQJdtz() {
		return this.QJdtz;
	}

	public void setQJdtz(String QJdtz) {
		this.QJdtz = QJdtz;
	}

	
	public Long getQOrder() {
		return this.QOrder;
	}

	public void setQOrder(Long QOrder) {
		this.QOrder = QOrder;
	}

}