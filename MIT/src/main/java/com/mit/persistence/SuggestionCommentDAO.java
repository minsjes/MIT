package com.mit.persistence;

import java.util.List;

import com.mit.domain.SuggestionCommentVO;

public interface SuggestionCommentDAO {
	
	public void create(SuggestionCommentVO cvo) throws Exception;
	
	public void delete(int commentNo) throws Exception;
	
	public void deleteAll(int suggestionNo) throws Exception;
	
	public List<SuggestionCommentVO> list(int suggestionNo) throws Exception;
}
