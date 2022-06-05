package com.survey.dao;

import java.util.List;

import com.survey.dto.Guestbook;
import com.survey.pager.PageListener;

public interface GusetbookDAO extends PageListener {
	boolean addGusetbook(Guestbook guestbook);
	boolean updateGuestbook(Guestbook guestbook);
	boolean delGuestbook(Long guestbookId);
	List<Guestbook> listAllGuestbook();
	Guestbook findGuestbook(Long guestbookId);
}
