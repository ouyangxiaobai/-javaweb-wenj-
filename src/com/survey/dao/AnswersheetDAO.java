package com.survey.dao;

import java.util.List;

import com.survey.dto.Answersheet;
import com.survey.pager.PageListener;

public interface AnswersheetDAO extends PageListener {

	boolean addAnswersheet(Answersheet answersheet);
	//boolean updateAnswersheet(Answersheet answersheet);
	boolean delAnswersheet(Long answersheetId);
	boolean delAnswersheets(Long sid);
	List<Answersheet> listAllAnswersheet(Long surveyId);
	Answersheet findAnswersheet(Long answersheetId);
	boolean isIpRepeate(Long sid,String IP);
}
