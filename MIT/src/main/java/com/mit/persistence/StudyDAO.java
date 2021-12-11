package com.mit.persistence;

import java.util.List;

import com.mit.domain.StudyFileVO;
import com.mit.domain.StudyVO;

public interface StudyDAO {

	public int create(StudyVO vo) throws Exception;
	
	public StudyVO read(int studyNo) throws Exception;
	
	public void update(StudyVO vo) throws Exception;

	public void delete(int studyNo) throws Exception;
	
	public List<StudyVO> list() throws Exception;
	
	public void insertFile(StudyFileVO fVo) throws Exception;
	
	public void deleteFile(int studyNo) throws Exception;
	
	public List<StudyFileVO> fileList(int studyNo) throws Exception;
	
	public void updateViewCount(int studyNo) throws Exception;
}
