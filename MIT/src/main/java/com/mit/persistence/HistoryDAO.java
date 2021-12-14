package com.mit.persistence;

import java.util.List;

import com.mit.domain.HistoryVO;
import com.mit.domain.SearchCriteria;


public interface HistoryDAO {
	
	public int create(HistoryVO vo) throws Exception;

	// 1) 동아리 소개 목록
	public List<HistoryVO> listSearch(SearchCriteria cri) throws Exception;
	// 1) 동아리 소개 목록
	public int listSearchCount(SearchCriteria cri) throws Exception;
	
	// 2) 동아리 소개 상세화면
	public HistoryVO read(int historyNo) throws Exception;
	
	// 3) 동아리 소개 수정
	public void update(HistoryVO vo) throws Exception;

	public void delete(int historyNo) throws Exception;
	

	

}
