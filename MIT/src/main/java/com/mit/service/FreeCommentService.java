package com.mit.service;

import java.util.List;

import com.mit.domain.FreeCommentVO;

public interface FreeCommentService {
	
	public void register(FreeCommentVO cvo) throws Exception;

	public void remove(int commentNo) throws Exception;

	public void removeAll(int freeNo) throws Exception;

	public List<FreeCommentVO> list(int freeNo) throws Exception;
}
