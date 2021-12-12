package com.mit.persistence;

import java.util.List;

import com.mit.domain.QnaCommentVO;

public interface QnaCommentDAO {
	
		public void create(QnaCommentVO cvo) throws Exception;
		
		public void delete(int commentNo) throws Exception;
		
		public void deleteAll(int qnaNo) throws Exception;
		
		public List<QnaCommentVO> list(int qnaNo) throws Exception;
	}