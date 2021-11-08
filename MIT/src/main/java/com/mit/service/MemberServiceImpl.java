package com.mit.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.mit.domain.MemberVO;
import com.mit.domain.SearchCriteria;
import com.mit.dto.LoginDTO;
import com.mit.persistence.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Inject
	private MemberDAO dao;

	@Override
	public MemberVO login(LoginDTO dto) throws Exception {
		return dao.login(dto);
		//return dao.login(dto);
	}

	@Override
	public MemberVO read(int memberno) throws Exception {
		return dao.read(memberno);
	}

	@Override
	public void modify(MemberVO vo) throws Exception {
		dao.update(vo);
		
	}

	@Override
	public void remove(int memberno) throws Exception {
		dao.delete(memberno);
		
	}

	@Override
	public List<MemberVO> listSearch() throws Exception {
		return dao.listSearch();
	}

	@Override
	public int listSearchCount() throws Exception {
		return dao.listSearchCount();
	}

}
