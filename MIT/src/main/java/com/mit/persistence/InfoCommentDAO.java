package com.mit.persistence;

import java.util.List;

import com.mit.domain.InfoCommentVO;

public interface InfoCommentDAO {
	// 1.댓글 생성
		public void create(InfoCommentVO icvo) throws Exception;
		
		// 2.댓글 삭제
		public void delete(int commentNo) throws Exception;
		
		// 3.댓글 전체 삭제
		public void deleteAll (int commentNo) throws Exception;
			
		// 4.댓글 전체 보기
		public List<InfoCommentVO> list(int infoNo) throws Exception;

}
