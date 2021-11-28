package com.mit.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mit.domain.MemberVO;
import com.mit.dto.LoginDTO;

	@Repository
	public class MemberDAOImpl implements MemberDAO{
	
	@Inject
	private SqlSession session;
	
	private static final String namespace = "com.mit.mapper.MemberMapper";

	@Override
	public MemberVO login(LoginDTO dto) throws Exception {
		return session.selectOne(namespace+".login", dto);
	}
	
	@Override
	public void change(int joinNo) throws Exception {
		session.insert(namespace + ".change", joinNo);
	}

	@Override
	public void create(MemberVO vo) throws Exception {
		session.insert(namespace + ".create", vo);
	}

	@Override
	public MemberVO read(int memberNo) throws Exception {
		return session.selectOne(namespace + ".read", memberNo);
	}

	@Override
	public void updateUser(MemberVO vo) throws Exception {
		session.update(namespace + ".updateUser", vo);
	}
	
	@Override
	public void updateAdmin(MemberVO vo) throws Exception {
		session.update(namespace + ".updateAdmin", vo);
	}

	@Override
	public List<MemberVO> listSearch() throws Exception {
		return session.selectList(namespace + ".listSearch");
	}

	@Override
	public int idCheck(int memberNo) throws Exception {
		return session.selectOne(namespace + ".idCheck", memberNo);
	}
}
