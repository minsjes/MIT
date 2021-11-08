package com.mit.service;

import java.util.List;

import com.mit.domain.InfoCommentVO;

public interface InfoCommentService {
		// 1. 관리자, 학생:: 댓글 생성
		public void add(InfoCommentVO icvo) throws Exception;

		// 2. 관리자, 학생 :: 댓글 삭제
		public void remove(int commentNo) throws Exception;

		// 3. 관리자, 학생 :: 댓글 전체 삭제
		public void removeAll(int infoNo) throws Exception;

		// 4. 관리자, 학생 :: 댓글 전체 보기
		List<InfoCommentVO> list(int infoNo) throws Exception;

}
