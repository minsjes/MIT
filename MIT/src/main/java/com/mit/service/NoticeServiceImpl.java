package com.mit.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.mit.domain.NoticeVO;
import com.mit.persistence.NoticeDAO;

@Service
public class NoticeServiceImpl implements NoticeService{
	
	@Inject
	private NoticeDAO dao;

	@Override
	public void create(NoticeVO vo) throws Exception {
		dao.create(vo);
		
	}

	@Override
	public NoticeVO read(int noticeNo) throws Exception {
		return dao.read(noticeNo);
	}

	@Override
	public void update(NoticeVO vo) throws Exception {
		dao.update(vo);
		
	}

	@Override
	public void delete(int noticeNo) throws Exception {
		dao.delete(noticeNo);
		
	}

	@Override
	public List<NoticeVO> listSearch() throws Exception {
		return dao.listSearch();
	}

	@Override
	public int listSearchCount() throws Exception {
		return dao.listSearchCount();
	}
}
