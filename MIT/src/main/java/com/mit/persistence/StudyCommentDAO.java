package com.mit.persistence;

import java.util.List;

import com.mit.domain.StudyCommentVO;

public interface StudyCommentDAO {
	public void create(StudyCommentVO cvo) throws Exception;
	
	public void delete(int commentNo) throws Exception;
	
	public void deleteAll(int studyNo) throws Exception;
	
	public List<StudyCommentVO> list(int studyNo) throws Exception;
}
