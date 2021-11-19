package com.mit.persistence;

import java.util.List;

import com.mit.domain.MemberVO;
import com.mit.dto.LoginDTO;

public interface MemberDAO {
	
	public MemberVO login(LoginDTO dto) throws Exception; 
	
	public void change(int joinNo) throws Exception;
	
	public void create(MemberVO vo) throws Exception;
	
	public MemberVO read(int memberNo) throws Exception;
	
	public void update(MemberVO vo) throws Exception;
	
	public List<MemberVO> listSearch() throws Exception;
	
	// 아이디 중복체크
	public int idCheck(int memberNo) throws Exception;
}
