package com.mit.service;

import java.util.List;

import com.mit.domain.StudyFileVO;
import com.mit.domain.StudyVO;

public interface StudyService {

	public void register(StudyVO vo) throws Exception;

	public StudyVO read(int studyNo) throws Exception;
	
	public void modify(StudyVO vo) throws Exception;

	public void remove(int studyNo) throws Exception;
	
	public List<StudyVO> list() throws Exception;
	
	public List<StudyFileVO> fileList(int studyNo) throws Exception;
}
