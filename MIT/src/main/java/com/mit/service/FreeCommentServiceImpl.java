package com.mit.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.mit.domain.FreeCommentVO;
import com.mit.persistence.FreeCommentDAO;

@Service
public class FreeCommentServiceImpl implements FreeCommentService {
	@Inject
	private FreeCommentDAO dao;

	@Override
	public void register(FreeCommentVO fcvo) throws Exception {
		dao.create(fcvo);
	}

	@Override
	public void remove(int commentNo) throws Exception {
		dao.delete(commentNo);
	}

	@Override
	public void removeAll(int freeNo) throws Exception {
		dao.deleteAll(freeNo);
	}

	@Override
	public List<FreeCommentVO> list(int freeNo) throws Exception {
		return dao.list(freeNo);
	}

	
}
