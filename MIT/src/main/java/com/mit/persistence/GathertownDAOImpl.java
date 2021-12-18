package com.mit.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mit.domain.GathertownVO;

@Repository
public class GathertownDAOImpl implements GathertownDAO {
	
	@Inject
	private SqlSession session;
	
	private static final String namespace = "com.mit.mapper.GathertownMapper";
	
	@Override
	public void create(GathertownVO vo) throws Exception {
		session.insert(namespace + ".create", vo);
	}

	@Override
	public GathertownVO read(int gathertownNo) throws Exception {
		return session.selectOne(namespace + ".read", gathertownNo);
	}

	@Override
	public void update(GathertownVO vo) throws Exception {
		session.update(namespace + ".update", vo);
	}

	@Override
	public void delete(int gathertownNo) throws Exception {
		session.delete(namespace + ".delete", gathertownNo);
	}

	@Override
	public List<GathertownVO> list() throws Exception {
		return session.selectList(namespace + ".list");
	}
}
