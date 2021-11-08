package com.mit.service;

import java.util.List;

import com.mit.domain.NoticeVO;
import com.mit.domain.PhotoVO;
import com.mit.domain.SearchCriteria;

public interface MainService {
	public List<NoticeVO> list() throws Exception;
	
	public List<PhotoVO> listSearch(SearchCriteria cri) throws Exception;
}