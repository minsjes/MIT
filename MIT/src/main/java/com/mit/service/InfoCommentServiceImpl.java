package com.mit.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.mit.domain.InfoCommentVO;
import com.mit.persistence.InfoCommentDAO;

@Service
public class InfoCommentServiceImpl implements InfoCommentService{
	
	@Inject
	private InfoCommentDAO dao;

	@Override
	public void add(InfoCommentVO icvo) throws Exception {
		dao.create(icvo);
		
	}

	@Override
	public void remove(int commentNo) throws Exception {
		dao.delete(commentNo);
		
	}

	@Override
	public void removeAll(int infoNo) throws Exception {
		dao.deleteAll(infoNo);
		
	}

	@Override
	public List<InfoCommentVO> list(int infoNo) throws Exception {
		return dao.list(infoNo);
	}
	
	

}
