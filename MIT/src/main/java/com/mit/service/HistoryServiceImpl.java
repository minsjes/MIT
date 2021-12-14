package com.mit.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;


import com.mit.domain.HistoryVO;
import com.mit.domain.SearchCriteria;

import com.mit.persistence.HistoryDAO;

@Service
public class HistoryServiceImpl implements HistoryService {
	
	@Inject
	private HistoryDAO dao;
	

	// 1) 동아리 소개 목록
	@Override
	public List<HistoryVO> listSearch(SearchCriteria cri) throws Exception {
		
		return dao.listSearch(cri);
	}
	// 1) 동아리 소개 목록
	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		
		return dao.listSearchCount(cri);
	}
	
	// 2) 동아리 소개 상세화면
	@Override
	public HistoryVO read(int historyNo) throws Exception {
		return dao.read(historyNo);
	}

	// 3) 동아리 소개 수정
	@Override
	public void update(HistoryVO vo) throws Exception {
		
	      vo.setHistoryContent(vo.getHistoryContent().replace("\\r\\n", "<br>"));
	      dao.update(vo);

	}
	
	@Override
	public void create(HistoryVO vo) throws Exception {
		
	      vo.setHistoryContent(vo.getHistoryContent().replace("\\r\\n", "<br>"));
	      int historyNo = dao.create(vo);
	     
	 
	         }

	@Override
	public void delete(int HistoryNo) throws Exception {
		
		dao.delete(HistoryNo);

	}
	
}


