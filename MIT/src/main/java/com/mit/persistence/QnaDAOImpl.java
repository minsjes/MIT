package com.mit.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mit.domain.QnaFileVO;
import com.mit.domain.QnaVO;
import com.mit.domain.SearchCriteria;

@Repository
public class QnaDAOImpl implements QnaDAO {
	
	@Inject
	private SqlSession session;
	
	private static final String namespace = "com.mit.mapper.QnaMapper";

	@Override
	public int create(QnaVO vo) throws Exception {
		session.insert(namespace + ".create", vo);
		return vo.getQnaNo();
		
	}

	@Override
	public QnaVO read(int qnaNo) throws Exception {
		return session.selectOne(namespace + ".read", qnaNo);
	}

	@Override
	public void update(QnaVO vo) throws Exception {
		session.update(namespace + ".update", vo);
		
	}

	@Override
	public void delete(int qnaNo) throws Exception {
		session.delete(namespace + ".delete", qnaNo);
		
	}

	@Override
	public List<QnaVO> list() throws Exception {
		return session.selectList(namespace + ".list");
	}

	
	@Override
	public void insertFile(QnaFileVO qVo) throws Exception {
		session.insert(namespace+".insertFile", qVo);
		
	}

	@Override
	public void deleteFile(int qnaNo) throws Exception {
		session.delete(namespace+".deleteFile", qnaNo);
		
	}

	@Override
	public List<QnaFileVO> fileList(int qnaNo) throws Exception {
		return session.selectList(namespace+".fileList", qnaNo);
	}

	@Override
	public void updateViewCount(int qnaNo) throws Exception {
		session.update(namespace + ".updateViewCount", qnaNo);
		
	}

}