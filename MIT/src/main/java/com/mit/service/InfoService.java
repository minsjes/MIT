
package com.mit.service;

import java.util.List;

import com.mit.domain.InfoFileVO;
import com.mit.domain.InfoVO;
import com.mit.domain.SearchCriteria;



public interface InfoService {
	
	public void create(InfoVO vo) throws Exception;

	public InfoVO read(int infoNo) throws Exception;

	public void update(InfoVO vo) throws Exception;

	public void delete(int infoNo) throws Exception;

	// 페이징 + 검색을 처리하여 리스트 가져오는 기능
	public List<InfoVO> listSearch(SearchCriteria cri) throws Exception;

	// 페이징 + 검색을 위한 전체 게시글 수 가져오는 기능
	public int listSearchCount(SearchCriteria cri) throws Exception;
	
	public List<InfoFileVO> fileList(int infoNo) throws Exception;


}
