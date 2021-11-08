package com.mit.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.mit.domain.NoticeVO;
import com.mit.domain.PhotoVO;
import com.mit.domain.SearchCriteria;
import com.mit.persistence.NoticeDAO;
import com.mit.persistence.PhotoDAO;

@Service
public class MainServiceImpl implements MainService {
	@Inject
	private NoticeDAO dao;

	@Inject
	private PhotoDAO pdao;
	
	@Override
	public List<NoticeVO> list() throws Exception {
		return dao.list();
	}

	@Override
	public List<PhotoVO> listSearch(SearchCriteria cri) throws Exception {
		return pdao.listSearch(cri);
	}
}
