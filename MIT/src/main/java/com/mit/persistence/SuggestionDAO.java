package com.mit.persistence;

import java.util.List;

import com.mit.domain.SuggestionFileVO;
import com.mit.domain.SuggestionVO;

public interface SuggestionDAO {
	
	public int create(SuggestionVO vo) throws Exception;
	
	public SuggestionVO read(int suggestionNo) throws Exception;
	
	public void update(SuggestionVO vo) throws Exception;

	public void delete(int suggestionNo) throws Exception;
	
	public List<SuggestionVO> list() throws Exception;
	
	public void insertFile(SuggestionFileVO fVo) throws Exception;
	
	public void deleteFile(int suggestionNo) throws Exception;
	
	public List<SuggestionFileVO> fileList(int suggestionNo) throws Exception;
}
