package com.mit.service;

import java.util.List;

import javax.inject.Inject;

import com.mit.domain.StudyCommentVO;
import com.mit.persistence.StudyCommentDAO;

public class StudyCommentServiceImpl implements StudyCommentService {
	
	@Inject
	private StudyCommentDAO dao;
	
	@Override
	public void register(StudyCommentVO cvo) throws Exception {
		dao.create(cvo);
	}

	@Override
	public void remove(int commentNo) throws Exception {
		dao.delete(commentNo);
	}

	@Override
	public void removeAll(int studyNo) throws Exception {
		dao.deleteAll(studyNo);
	}

	@Override
	public List<StudyCommentVO> list(int studyNo) throws Exception {
		return dao.list(studyNo);
	}
}
