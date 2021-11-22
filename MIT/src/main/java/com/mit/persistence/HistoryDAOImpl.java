package com.mit.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mit.domain.HistoryVO;
import com.mit.domain.SearchCriteria;



@Repository
public class HistoryDAOImpl implements HistoryDAO {
	
	
	@Inject
	private SqlSession session;
	
	private static final String namespace = "com.mit.mapper.HistoryMapper";
	

	@Override
	public int create(HistoryVO vo) throws Exception {
		session.insert(namespace+".create", vo);
		return vo.getHistoryNo();
		
	}

	@Override
	public HistoryVO read(int HistoryNo) throws Exception {
		return session.selectOne(namespace+".read", HistoryNo);
	}

	@Override
	public void update(HistoryVO vo) throws Exception {
		session.update(namespace+".update", vo);
		
	}

	@Override
	public void delete(int HistoryNo) throws Exception {
		session.delete(namespace+".delete", HistoryNo);
		
	}

	@Override
	public List<HistoryVO> listSearch(SearchCriteria cri) throws Exception {
		
		return session.selectList(namespace + ".listSearch", cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		
		return session.selectOne(namespace + ".listSearchCount", cri);
	}


}
