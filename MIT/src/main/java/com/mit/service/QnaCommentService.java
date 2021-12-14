package com.mit.service;

import java.util.List;

import com.mit.domain.QnaCommentVO;

public interface QnaCommentService {
	
	
	public void register(QnaCommentVO qcvo) throws Exception;
	
	public void remove(int commentNo) throws Exception;
	
	public void removeAll(int qnaNo) throws Exception;
	
	public List<QnaCommentVO> list(int qnaNo) throws Exception;
	
}