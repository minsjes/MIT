package com.mit.service;

import java.util.List;

import com.mit.domain.JoinVO;
import com.mit.domain.SearchCriteria;

public interface JoinService {
	public void create(JoinVO vo) throws Exception;
	
	public JoinVO read(int joinNo) throws Exception;
	
	public void update(JoinVO vo) throws Exception;
	
	public void delete(JoinVO vo) throws Exception;
	
	public List<JoinVO> listSearch() throws Exception;
	
	public int listSearchCount() throws Exception;
	
	public int idChk(int joinNo) throws Exception;
}
