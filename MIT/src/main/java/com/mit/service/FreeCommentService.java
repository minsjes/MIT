package com.mit.service;

import java.util.List;

import com.mit.domain.FreeCommentVO;

public interface FreeCommentService {
	// 1. 관리자, 학생:: 댓글 생성
	public void add(FreeCommentVO fcvo) throws Exception;

	// 2. 관리자, 학생 :: 댓글 삭제
	public void remove(int commentNo) throws Exception;

	// 3. 관리자, 학생 :: 댓글 전체 삭제
	public void removeAll(int freeNo) throws Exception;

	// 4. 관리자, 학생 :: 댓글 전체 보기
	List<FreeCommentVO> list(int freeNo) throws Exception;
}
