package com.mit.service;

import java.util.List;

import com.mit.domain.InfoCommentVO;

public interface InfoCommentService {
		
		public void register(InfoCommentVO cvo) throws Exception;
		
		public void remove(int commentNo) throws Exception;

		public void removeAll(int infoNo) throws Exception;

		public List<InfoCommentVO> list(int infoNo) throws Exception;
}
