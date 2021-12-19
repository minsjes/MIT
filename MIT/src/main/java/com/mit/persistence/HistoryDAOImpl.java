package com.mit.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mit.domain.HistoryVO;

@Repository
public class HistoryDAOImpl implements HistoryDAO {
	
	@Inject
	private SqlSession session;
	
	private static final String namespace = "com.mit.mapper.HistoryMapper";
	
	@Override
	public void create(HistoryVO vo) throws Exception {
		session.insert(namespace+".create", vo);
	}

	@Override
	public HistoryVO read(int historyNo) throws Exception {
		return session.selectOne(namespace + ".read", historyNo);
	}

	@Override
	public void update(HistoryVO vo) throws Exception {
		session.update(namespace + ".update", vo);
	}

	@Override
	public void delete(int historyNo) throws Exception {
		session.delete(namespace + ".delete", historyNo);
	}

	@Override
	public List<HistoryVO> list() throws Exception {
		return session.selectList(namespace + ".list");
	}
}
