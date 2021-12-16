package com.mit.service;

import java.util.List;

import com.mit.domain.FreeFileVO;
import com.mit.domain.FreeVO;

public interface FreeService {
	
	public void register(FreeVO vo) throws Exception;
	
	public FreeVO read(int freeNo) throws Exception;
	
	// 자유게시판 : 게시물 수정
	public void modify(FreeVO vo) throws Exception;
	
	public void remove(int freeNo) throws Exception;
	
	public List<FreeVO> list() throws Exception;
	
	// 첨부파일 목록
	public List<FreeFileVO> fileList(int freeNo) throws Exception;
}
