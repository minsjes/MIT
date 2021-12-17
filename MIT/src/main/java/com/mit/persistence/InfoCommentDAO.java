package com.mit.persistence;

import java.util.List;

import com.mit.domain.InfoCommentVO;

public interface InfoCommentDAO {
	public void create(InfoCommentVO cvo) throws Exception;
		
	public void delete(int commentNo) throws Exception;
		
	public void deleteAll (int infoNo) throws Exception;
			
	public List<InfoCommentVO> list(int infoNo) throws Exception;
}
