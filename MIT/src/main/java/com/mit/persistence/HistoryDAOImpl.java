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
	
	// 1) 동아리 소개 목록
	@Override
	public List<HistoryVO> listSearch(SearchCriteria cri) throws Exception {
		
		return session.selectList(namespace + ".listSearch", cri);
	}
	// 1) 동아리 소개 목록
	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		
		return session.selectOne(namespace + ".listSearchCount", cri);
	}

	// 2) 동아리 소개 상세화면
	@Override
	public HistoryVO read(int historyNo) throws Exception {
		return session.selectOne(namespace+".read", historyNo);
	}

	// 3) 동아리 소개 수정
	@Override
	public void update(HistoryVO vo) throws Exception {
		session.update(namespace+".update", vo);
		
	}

	@Override
	public void delete(int historyNo) throws Exception {
		session.delete(namespace+".delete", historyNo);
		
	}



}
