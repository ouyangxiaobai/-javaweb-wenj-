package com.survey.dao;
import java.util.List;

import com.survey.dto.Survey;
import com.survey.pager.PageListener;
public interface SurveyDAO extends PageListener{
	/**
	 * create a survey
	 * @param survey
	 * @return
	 */
	boolean addSurvey(Survey survey);
	
	/**
	 * modify a survey's setting
	 * @param survey
	 * @return
	 */
	boolean updateSurvey(Survey survey);
	/**
	 * delete a survey
	 * @param survey
	 * @return
	 */
	boolean delSurvey(Long surveyId);
	/**
	 * list all surveys
	 * @return
	 */
	List<Survey> listAllSurvey();
	List<Survey> listAllSurvey(String order);
	
	/**
	 * find a survey by survey id
	 * @param surveyId
	 * @return
	 */
	Survey findSurvey(Long surveyId); 
	
	/**
	 * list surveys which can be visited by clients.
	 * @return
	 */
	List<Survey> listVisitableSurvey();
	List<Survey> listVisitableSurvey(String order);
}
