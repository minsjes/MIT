package com.mit.persistence;

import java.util.List;

import com.mit.domain.QnaFileVO;
import com.mit.domain.QnaVO;
import com.mit.domain.SearchCriteria;

public interface QnaDAO {
	
	public int create(QnaVO vo) throws Exception;
	
	public QnaVO read(int qnaNo) throws Exception;
	
	public void update(QnaVO vo) throws Exception;
	
	public void delete(int qnaNo) throws Exception;
	
	public List<QnaVO> listSearch() throws Exception;
	
	public int listSearchCount() throws Exception;
	
	public void insertFile(QnaFileVO qVo) throws Exception;
	
	public void deleteFile(int qnaNo) throws Exception;

	public List<QnaFileVO> fileList(int qnaNo) throws Exception;
}
