package com.mit.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mit.domain.SuggestionCommentVO;

@Repository
public class SuggestionCommentDAOImpl implements SuggestionCommentDAO {
	
	@Inject
	private SqlSession session;
	
	private static final String namespace = "com.mit.mapper.SuggestionCommentMapper";
	
	@Override
	public void create(SuggestionCommentVO cvo) throws Exception {
		session.insert(namespace + ".create", cvo);
	}

	@Override
	public void delete(int commentNo) throws Exception {
		session.delete(namespace + ".delete", commentNo);
	}

	@Override
	public void deleteAll(int suggestionNo) throws Exception {
		session.delete(namespace + ".deleteAll", suggestionNo);
	}

	@Override
	public List<SuggestionCommentVO> list(int suggestionNo) throws Exception {
		return session.selectList(namespace + ".list", suggestionNo);
	}
}
