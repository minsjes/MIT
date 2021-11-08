package com.mit.persistence;

import java.util.List;

import com.mit.domain.QnaCommentVO;

public interface QnaCommentDAO {
	
	// 1. qna - 댓글 생성
	public void create(QnaCommentVO qcvo) throws Exception;
	
	// 2. qna - 댓글 삭제
	public void delete(int commentNo) throws Exception;
	
	// 3. qna - 댓글 전체 삭제
	public void deleteAll (int qnaNo) throws Exception;
	
	// 4. qna - 댓글 전체 보기
	public List<QnaCommentVO> list(int qnaNo) throws Exception;

}
