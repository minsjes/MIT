package com.mit.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mit.domain.QnaCommentVO;

@Repository
public class QnaCommentDAOImpl implements QnaCommentDAO{
	
	@Inject
	private SqlSession session;
	
	private static final String namespace = "com.mit.mapper.QnaCommentMapper";

	@Override
	public void create(QnaCommentVO cvo) throws Exception {
		session.insert(namespace + ".create", cvo);
		
	}

	@Override
	public void delete(int commentNo) throws Exception {
		session.delete(namespace + ".delete", commentNo);
		
	}

	@Override
	public void deleteAll(int qnaNo) throws Exception {
		session.delete(namespace + ".deleteAll", qnaNo);
		
	}

	@Override
	public List<QnaCommentVO> list(int qnaNo) throws Exception {
		return session.selectList(namespace + ".list", qnaNo);
	}
	
	

}