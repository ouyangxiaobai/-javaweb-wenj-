package com.survey.dao;

import com.survey.dao.mssqlimpl.*;
 

public class DAOFactory {

	private DAOFactory(){
		
	}
	public static SurveyDAO getSurveyDAO(){
		return new SurveyDAOimpl();
	}
	public static TempletDAO getTempletDAO(){
		return new TempletDAOimpl();
	}
	public static QuestionDAO getQuestionDAO(){
		return new QuestionDAOimpl();
	}
	public static TextDAO getTextDAO(){
		return new TextDAOimpl();
	}
	public static ConfigDAO getConfigDAO(){
		return new ConfigDAOimpl();
	}
	public static AnswersheetDAO getAnswersheetDAO(){
		return new AnswersheetDAOimpl();
	}
	public static AdminDAO getAdminDAO(){
		return new AdminDAOimpl();
	}
	public static LinkDAO getLinkDAO(){
		return new LinkDAOimpl();
	}
}
