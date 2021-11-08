package com.mit.service;

import java.util.List;

import com.mit.domain.QnaCommentVO;

public interface QnaCommentService {
	
	// 1. 관리자, 학생 :: QnA - 댓글 생성
		public void add(QnaCommentVO qcvo) throws Exception;

		//  2. 관리자, 학생 :: QnA - 댓글 삭제
		public void remove(int commentNo) throws Exception;

		// 3. 관리자, 학생 :: QnA - 댓글 전체 삭제
		public void removeAll(int qnaNo) throws Exception;
		
		// 4. 관리자, 학생 :: QnA - 댓글 전체 보기 
		List<QnaCommentVO> list(int qnaNo) throws Exception;

}
