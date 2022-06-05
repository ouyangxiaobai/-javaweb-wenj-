package com.survey.dto;
// default package

 
/**
 * Text entity.
 * 
 * @author MyEclipse Persistence Tools
 */
 
public class Text implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 271542403734906933L;
	private Long TId;
	private Long QId;
	private String TContent;

	// Constructors

	/** default constructor */
	public Text() {
	}

	/** minimal constructor */
	public Text(Long TId, Long QId) {
		this.TId = TId;
		this.QId = QId;
	}

	/** full constructor */
	public Text(Long TId, Long QId, String TContent) {
		this.TId = TId;
		this.QId = QId;
		this.TContent = TContent;
	}

	// Property accessors
	 
	public Long getTId() {
		return this.TId;
	}

	public void setTId(Long TId) {
		this.TId = TId;
	}

	
	public Long getQId() {
		return this.QId;
	}

	public void setQId(Long QId) {
		this.QId = QId;
	}

	
	public String getTContent() {
		return this.TContent;
	}

	public void setTContent(String TContent) {
		this.TContent = TContent;
	}

}