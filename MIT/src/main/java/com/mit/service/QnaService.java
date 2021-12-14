package com.mit.service;

import java.util.List;

import com.mit.domain.QnaFileVO;
import com.mit.domain.QnaVO;

public interface QnaService {
	
	public void register(QnaVO vo) throws Exception;

	public QnaVO read(int qnaNo) throws Exception;
	
	public void modify(QnaVO vo) throws Exception;

	public void remove(int qnaNo) throws Exception;
	
	public List<QnaVO> list() throws Exception;
	
	public List<QnaFileVO> fileList(int qnaNo) throws Exception;

}
