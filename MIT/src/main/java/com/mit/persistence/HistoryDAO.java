package com.mit.persistence;

import java.util.List;

import com.mit.domain.HistoryVO;

public interface HistoryDAO {
	public void create(HistoryVO vo) throws Exception;

	public HistoryVO read(int historyNo) throws Exception;
	
	public void update(HistoryVO vo) throws Exception;

	public void delete(int historyNo) throws Exception;
	
	public List<HistoryVO> list() throws Exception;
}
