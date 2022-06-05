package com.survey.dao;
import java.util.List;

import com.survey.dto.Question;
import com.survey.pager.PageListener;
public interface QuestionDAO extends PageListener {
	/**
	 * 添加问题
	 * @param question
	 * @return
	 */
	boolean addQuestion(Question question);
	/**
	 * 更新问题
	 * @param question
	 * @return
	 */
	boolean updateQuestion(Question question);
	/**
	 * 删除问题
	 * @param question
	 * @return
	 */
	boolean delQuestion(Long questionId);
	/**
	 * 删除问题
	 * @param question
	 * @return
	 */
	boolean delQuestions(Long surveyId);
	/**
	 * 查询问题
	 * @return
	 */
	List<Question> listQuestions(String WhereClause);
	List<Question> listAllQuestion(Long surveyId);
	List<Question> listAllQuestion(Long surveyId,String ascORdesc);
	/**
	 * 查询问题
	 * @param question
	 * @return
	 */
	Question findQuestion(Long questionId);
}
