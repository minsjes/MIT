package com.mit.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;


import com.mit.domain.HistoryVO;
import com.mit.domain.SearchCriteria;

import com.mit.persistence.HistoryDAO;

@Service
public class HistoryServiceImpl implements HistoryService {
	
	@Inject
	private HistoryDAO dao;
	

	@Override
	public void create(HistoryVO vo) throws Exception {
		 // (1) �ؽ�Ʈ����� �ٹٲ� ����
	      vo.setHistoryContent(vo.getHistoryContent().replace("\\r\\n", "<br>"));
	      
	      // (2) �⺻ ��û ���� ��� (���� ��� x) -> ��ϵ� ��û������ PK ��������
	      int historyNo = dao.create(vo);
	     
	 
	         }


	@Override
	public HistoryVO read(int HistoryNo) throws Exception {
		return dao.read(HistoryNo);
	}

	@Override
	public void update(HistoryVO vo) throws Exception {
		 // (1) �ؽ�Ʈ����� �ٹٲ� ����
	      vo.setHistoryContent(vo.getHistoryContent().replace("\\r\\n", "<br>"));
	      
	      // (2) ���α׷� �Խñ� ����
	      dao.update(vo);

	      

	}

	@Override
	public void delete(int HistoryNo) throws Exception {
		// ÷�����ϰ�, ����� �ִ� ���Ǳ���
		
		// 3) �Խñ� ����
		dao.delete(HistoryNo);

	}

	@Override
	public List<HistoryVO> listSearch(SearchCriteria cri) throws Exception {
		
		return dao.listSearch(cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		
		return dao.listSearchCount(cri);
	}

}


