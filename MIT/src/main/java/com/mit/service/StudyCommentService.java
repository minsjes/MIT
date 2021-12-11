package com.mit.service;

import java.util.List;

import com.mit.domain.StudyCommentVO;

public interface StudyCommentService {
	
	public void register(StudyCommentVO cvo) throws Exception;
	
	public void remove(int commentNo) throws Exception;
	
	public void removeAll(int studyNo) throws Exception;
	
	public List<StudyCommentVO> list(int studyNo) throws Exception;
}
