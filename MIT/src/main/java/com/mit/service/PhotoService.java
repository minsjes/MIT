package com.mit.service;

import java.util.List;

import com.mit.domain.PhotoFileVO;
import com.mit.domain.PhotoVO;
import com.mit.domain.SearchCriteria;

public interface PhotoService {

	public void create(PhotoVO vo) throws Exception;

	public PhotoVO read(int photoNo) throws Exception;

	public void update(PhotoVO vo) throws Exception;

	public void delete(int photoNo) throws Exception;

	// 페이징 + 검색을 처리하여 리스트 가져오는 기능
	public List<PhotoVO> listSearch(SearchCriteria cri) throws Exception;

	// 페이징 + 검색을 위한 전체 게시글 수 가져오는 기능
	public int listSearchCount(SearchCriteria cri) throws Exception;
	
	public List<PhotoFileVO> fileList(int photoNo) throws Exception;

}
