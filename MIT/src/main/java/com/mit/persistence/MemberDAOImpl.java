package com.mit.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mit.domain.MemberVO;
import com.mit.domain.SearchCriteria;
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
	public void create(int joinNo) throws Exception {
		session.insert(namespace + ".create", joinNo);
	}

	@Override
	public MemberVO read(int memberNo) throws Exception {
		return session.selectOne(namespace + ".read", memberNo);
	}

	@Override
	public void update(MemberVO vo) throws Exception {
		session.update(namespace + ".update", vo);
	}

	@Override
	public void delete(int memberNo) throws Exception {
		session.delete(namespace + ".delete", memberNo);
	}

	@Override
	public List<MemberVO> listSearch() throws Exception {
		return session.selectList(namespace + ".listSearch");
	}

	@Override
	public int listSearchCount() throws Exception {
		return session.selectOne(namespace + ".listSearchCount");
	}

}
