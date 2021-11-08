package com.mit.service;

import java.util.List;

import com.mit.domain.MemberVO;
import com.mit.domain.SearchCriteria;
import com.mit.dto.LoginDTO;

public interface MemberService {
	
	public MemberVO login(LoginDTO dto) throws Exception; 

	public MemberVO read(int memberno) throws Exception;
	
	public void modify(MemberVO vo) throws Exception;
	
	public void remove(int memberno) throws Exception;
	
	//페이징, 검색 기능을 제공하는 list
	public List<MemberVO> listSearch() throws Exception;
	
	//페이징, 검색 기능 게시물 수 가져오는 기능
	public int listSearchCount() throws Exception;

}
