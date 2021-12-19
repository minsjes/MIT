package com.mit.service;

import java.util.List;

import com.mit.domain.SuggestionCommentVO;

public interface SuggestionCommentService {
	
	public void register(SuggestionCommentVO cvo) throws Exception;
	
	public void remove(int commentNo) throws Exception;
	
	public void removeAll(int suggestionNo) throws Exception;
	
	public List<SuggestionCommentVO> list(int suggestionNo) throws Exception;
}
