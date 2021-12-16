package com.mit.persistence;

import java.util.List;

import com.mit.domain.FreeCommentVO;

public interface FreeCommentDAO {
	public void create(FreeCommentVO cvo) throws Exception;
	
	public void delete(int commentNo) throws Exception;
	
	public void deleteAll (int freeNo) throws Exception;
		
	public List<FreeCommentVO> list(int freeNo) throws Exception;
}
