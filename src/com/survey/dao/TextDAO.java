package com.survey.dao;

import java.util.List;

import com.survey.dto.Text;
import com.survey.pager.PageListener;

public interface TextDAO extends PageListener{
	boolean addText(Text text);
	boolean delText(Long sid);
	List<Text> listAllText(Long questionId);
	Text findText(Long textId);
}
