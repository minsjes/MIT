package com.mit.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.mit.domain.SuggestionCommentVO;
import com.mit.persistence.SuggestionCommentDAO;

@Service
public class SuggestionCommentServiceImpl implements SuggestionCommentService {
	
	@Inject
	private SuggestionCommentDAO dao;
	
	@Override
	public void register(SuggestionCommentVO cvo) throws Exception {
		dao.create(cvo);
	}

	@Override
	public void remove(int commentNo) throws Exception {
		dao.delete(commentNo);
	}

	@Override
	public void removeAll(int suggestionNo) throws Exception {
		dao.deleteAll(suggestionNo);
	}

	@Override
	public List<SuggestionCommentVO> list(int suggestionNo) throws Exception {
		return dao.list(suggestionNo);
	}
}
