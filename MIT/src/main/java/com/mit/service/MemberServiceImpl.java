package com.mit.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.mit.domain.MemberVO;
import com.mit.dto.LoginDTO;
import com.mit.persistence.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Inject
	private MemberDAO dao;

	@Override
	public MemberVO login(LoginDTO dto) throws Exception {
		return dao.login(dto);
	}
	
	@Override
	public void register(MemberVO vo) throws Exception {
		dao.create(vo);
	}
	
	@Override
	public MemberVO read(int memberNo) throws Exception {
		return dao.read(memberNo);
	}

	@Override
	public void modifyUser(MemberVO vo) throws Exception {
		dao.updateUser(vo);
		
	}
	
	@Override
	public void modifyAdmin(MemberVO vo) throws Exception {
		dao.updateAdmin(vo);
		
	}

	@Override
	public List<MemberVO> listSearch() throws Exception {
		return dao.listSearch();
	}

	@Override
	public int idCheck(int memberNo) throws Exception {
		return dao.idCheck(memberNo);
	}
}
