package com.mit.persistence;

import java.util.List;

import com.mit.domain.PhotoFileVO;
import com.mit.domain.PhotoVO;
import com.mit.domain.SearchCriteria;

public interface PhotoDAO {
	
	public int create(PhotoVO vo) throws Exception;

	public PhotoVO read(int photoNo) throws Exception;

	public void update(PhotoVO vo) throws Exception;

	public void delete(int photoNo) throws Exception;

	public List<PhotoVO> listSearch(SearchCriteria cri) throws Exception;

	public int listSearchCount(SearchCriteria cri) throws Exception;
	
	public void insertFile(PhotoFileVO fVo) throws Exception;
	
    // 8. 包府磊 :: 颇老 昏力
    public void deleteFile(int photoNo) throws Exception;
	
	// 9. 包府磊 :: 颇老 格废
	public List<PhotoFileVO> fileList(int photoNo) throws Exception;
}

