package com.mit.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.mit.domain.PhotoCommentVO;
import com.mit.persistence.PhotoCommentDAO;

@Service
public class PhotoCommentServiceImpl implements PhotoCommentService {
	@Inject
	private PhotoCommentDAO dao;

	@Override
	public void add(PhotoCommentVO pcvo) throws Exception {
		dao.create(pcvo);
		
	}

	@Override
	public void remove(int commentNo) throws Exception {
		dao.delete(commentNo);
		
	}

	@Override
	public void removeAll(int photoNo) throws Exception {
		dao.deleteAll(photoNo);
		
	}

	@Override
	public List<PhotoCommentVO> list(int photoNo) throws Exception {
		return dao.list(photoNo);
	}
	
	

}
