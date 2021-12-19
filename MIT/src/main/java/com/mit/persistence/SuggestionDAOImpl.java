package com.mit.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mit.domain.SuggestionFileVO;
import com.mit.domain.SuggestionVO;

@Repository
public class SuggestionDAOImpl implements SuggestionDAO {
	
	@Inject
	private SqlSession session;
	
	private static final String namespace = "com.mit.mapper.SuggestionMapper";
	
	@Override
	public int create(SuggestionVO vo) throws Exception {
		session.insert(namespace + ".create", vo);
		return vo.getSuggestionNo();
	}

	@Override
	public SuggestionVO read(int suggestionNo) throws Exception {
		return session.selectOne(namespace + ".read", suggestionNo);
	}

	@Override
	public void update(SuggestionVO vo) throws Exception {
		session.update(namespace + ".update", vo);
	}

	@Override
	public void delete(int suggestionNo) throws Exception {
		session.delete(namespace + ".delete", suggestionNo);
	}

	@Override
	public List<SuggestionVO> list() throws Exception {
		return session.selectList(namespace + ".list");
	}

	@Override
	public void insertFile(SuggestionFileVO fVo) throws Exception {
		session.insert(namespace + ".insertFile", fVo);
	}

	@Override
	public void deleteFile(int suggestionNo) throws Exception {
		session.delete(namespace + ".deleteFile", suggestionNo);
	}

	@Override
	public List<SuggestionFileVO> fileList(int suggestionNo) throws Exception {
		return session.selectList(namespace + ".fileList", suggestionNo);
	}
}
