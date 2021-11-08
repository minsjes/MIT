package com.mit.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mit.domain.FreeFileVO;
import com.mit.domain.FreeVO;
import com.mit.domain.SearchCriteria;

@Repository
public class FreeDAOImpl implements FreeDAO {
	@Inject
	private SqlSession session;
	
	private static final String namespace = "com.mit.mapper.FreeMapper";
	
	@Override
	public int create(FreeVO vo) throws Exception {
		session.insert(namespace + ".create", vo);
		return vo.getFreeNo();
	}

	@Override
	public FreeVO read(int freeNo) throws Exception {
		return session.selectOne(namespace + ".read", freeNo);
	}

	@Override
	public void update(FreeVO vo) throws Exception {
		session.update(namespace + ".update", vo);
	}

	@Override
	public void delete(int freeNo) throws Exception {
		session.delete(namespace + ".delete", freeNo);
	}

	@Override
	public List<FreeVO> listSearch(SearchCriteria cri) throws Exception {
		return session.selectList(namespace + ".listSearch", cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return session.selectOne(namespace + ".listSearchCount", cri);
	}



	@Override
	public void insertFile(FreeFileVO fVo) throws Exception {
		session.insert(namespace+".insertFile", fVo);
		
	}

	@Override
	public void deleteFile(int freeNo) throws Exception {
		session.delete(namespace+".deleteFile", freeNo);
		
	}

	@Override
	public List<FreeFileVO> fileList(int freeNo) throws Exception {
		return session.selectList(namespace+".fileList", freeNo);
	}
}