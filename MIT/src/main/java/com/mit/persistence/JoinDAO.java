package com.mit.persistence;

import java.util.List;

import com.mit.domain.JoinVO;
import com.mit.domain.SearchCriteria;

public interface JoinDAO {
	public void create(JoinVO vo) throws Exception;
	
	public JoinVO read(int joinNo) throws Exception;
	
	public void update(JoinVO vo) throws Exception;
	
	public void delete(JoinVO vo) throws Exception;
	
	public List<JoinVO> listSearch() throws Exception;
	
	public int listSearchCount() throws Exception;
	
	// 아이디 중복체크
	public int idCheck(int joinNo) throws Exception;
}
