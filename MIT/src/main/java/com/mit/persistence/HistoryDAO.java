package com.mit.persistence;

import java.util.List;

import com.mit.domain.HistoryVO;
import com.mit.domain.SearchCriteria;


public interface HistoryDAO {
	
	public int create(HistoryVO vo) throws Exception;

	public HistoryVO read(int HistoryNo) throws Exception;

	public void update(HistoryVO vo) throws Exception;

	public void delete(int HistoryNo) throws Exception;
	

	//페이징 + 검색을 처리하여 리스트 가져오는 기능
	public List<HistoryVO> listSearch(SearchCriteria cri) throws Exception;
	
	//페이징 + 검색을 위한 전체 게시글 수 가져오는 기능
	public int listSearchCount(SearchCriteria cri) throws Exception;
	

}
