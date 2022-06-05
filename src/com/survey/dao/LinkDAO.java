package com.survey.dao;

import java.util.List;

import com.survey.dto.Link;
import com.survey.pager.PageListener;

public interface LinkDAO extends PageListener{
	boolean addLink(Link link);
	boolean updateLink(Link link);
	boolean delLink(Long linkId);
	List<Link> listAllLink();
	Link findLink(Long linkId);
}
