package com.mit.persistence;

import java.util.List;

import com.mit.domain.MemberVO;
import com.mit.domain.SearchCriteria;
import com.mit.dto.LoginDTO;

public interface MemberDAO {
	
	public MemberVO login(LoginDTO dto) throws Exception; 
	
	public void create(int joinNo) throws Exception;
	
	public MemberVO read(int memberNo) throws Exception;
	
	public void update(MemberVO vo) throws Exception;
	
	public void delete(int memberNo) throws Exception;
	
	//페이징, 검색 할 수 있는 list
	public List<MemberVO> listSearch() throws Exception;
	
	//페이징, 검색 하기 위한 게시물 수 반환
	public int listSearchCount() throws Exception;

}
