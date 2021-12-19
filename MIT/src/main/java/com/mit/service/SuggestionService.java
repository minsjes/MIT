package com.mit.service;

import java.util.List;

import com.mit.domain.SuggestionFileVO;
import com.mit.domain.SuggestionVO;

public interface SuggestionService {
	
	public void register(SuggestionVO vo) throws Exception;

	public SuggestionVO read(int suggestionNo) throws Exception;
	
	public void modify(SuggestionVO vo) throws Exception;

	public void remove(int suggestionNo) throws Exception;
	
	public List<SuggestionVO> list() throws Exception;
	
	public List<SuggestionFileVO> fileList(int suggestionNo) throws Exception;
}
