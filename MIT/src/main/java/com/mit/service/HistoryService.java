package com.mit.service;

import java.util.List;

import com.mit.domain.HistoryVO;

public interface HistoryService {
	
	public void register(HistoryVO vo) throws Exception;
	
	public HistoryVO read(int historyNo) throws Exception;
	
	public void modify(HistoryVO vo) throws Exception;
	
	public void remove(int historyNo) throws Exception;
	
	public List<HistoryVO> list() throws Exception;
}