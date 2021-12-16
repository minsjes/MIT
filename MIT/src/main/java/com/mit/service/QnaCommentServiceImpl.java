package com.mit.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.mit.domain.QnaCommentVO;
import com.mit.persistence.QnaCommentDAO;

@Service
public class QnaCommentServiceImpl implements QnaCommentService{
	
	@Inject
	private QnaCommentDAO dao;
	
	@Override
	public void register(QnaCommentVO cvo) throws Exception {
		dao.create(cvo);
	}

	@Override
	public void remove(int commentNo) throws Exception {
		dao.delete(commentNo);
	}

	@Override
	public void removeAll(int qnaNo) throws Exception {
		dao.deleteAll(qnaNo);
	}

	@Override
	public List<QnaCommentVO> list(int qnaNo) throws Exception {
		return dao.list(qnaNo);
	}
}
