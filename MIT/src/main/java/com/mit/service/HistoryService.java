package com.mit.service;

import java.util.List;


import com.mit.domain.HistoryVO;
import com.mit.domain.SearchCriteria;

public interface HistoryService {
	
	public void create(HistoryVO vo) throws Exception;

	public HistoryVO read(int historyNo) throws Exception;

	public void update(HistoryVO vo) throws Exception;

	public void delete(int historyNo) throws Exception;

	// ����¡ + �˻��� ó���Ͽ� ����Ʈ �������� ���
	public List<HistoryVO> listSearch(SearchCriteria cri) throws Exception;

	// ����¡ + �˻��� ���� ��ü �Խñ� �� �������� ���
	public int listSearchCount(SearchCriteria cri) throws Exception;
	



}