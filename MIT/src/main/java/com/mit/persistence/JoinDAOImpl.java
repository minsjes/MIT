package com.mit.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mit.domain.JoinVO;
import com.mit.domain.SearchCriteria;

@Repository
public class JoinDAOImpl implements JoinDAO {
	@Inject
	private SqlSession session;
	
	private static String namespace = "com.mit.mapper.JoinMapper";

	@Override
	public void create(JoinVO vo) throws Exception {
		session.insert(namespace + ".create", vo);
	}

	@Override
	public JoinVO read(int joinNo) throws Exception {
		return session.selectOne(namespace + ".read", joinNo);
	}

	@Override
	public void update(JoinVO vo) throws Exception {
		session.update(namespace + ".update", vo);
	}

	@Override
	public void delete(JoinVO vo) throws Exception {
		session.delete(namespace + ".delete", vo);
	}

	@Override
	public List<JoinVO> listSearch() throws Exception {
		return session.selectList(namespace + ".listSearch");
	}

	@Override
	public int listSearchCount() throws Exception {
		return session.selectOne(namespace + ".listSearchCount");
	}

	@Override
	public int idCheck(int joinNo) throws Exception {
		return session.selectOne(namespace + ".idCheck", joinNo);
	}
}
