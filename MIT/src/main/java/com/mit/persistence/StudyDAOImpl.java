package com.mit.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mit.domain.StudyFileVO;
import com.mit.domain.StudyVO;

@Repository
public class StudyDAOImpl implements StudyDAO {
	
	@Inject
	private SqlSession session;
	
	private static final String namespace = "com.mit.mapper.StudyMapper";
	
	@Override
	public int create(StudyVO vo) throws Exception {
		session.insert(namespace + ".create", vo);
		return vo.getStudyNo();
	}

	@Override
	public StudyVO read(int studyNo) throws Exception {
		return session.selectOne(namespace + ".read", studyNo);
	}
	
	@Override
	public void update(StudyVO vo) throws Exception {
		session.update(namespace + ".update", vo);
	}

	@Override
	public void delete(int studyNo) throws Exception {
		session.delete(namespace + ".delete", studyNo);

	}

	@Override
	public List<StudyVO> list() throws Exception {
		return session.selectList(namespace + ".list");
	}

	@Override
	public void insertFile(StudyFileVO fVo) throws Exception {
		session.insert(namespace+".insertFile", fVo);
	}

	@Override
	public void deleteFile(int studyNo) throws Exception {
		session.delete(namespace+".deleteFile", studyNo);
	}

	@Override
	public List<StudyFileVO> fileList(int studyNo) throws Exception {
		return session.selectList(namespace+".fileList", studyNo);
	}

	@Override
	public void updateViewCount(int studyNo) throws Exception {
		session.update(namespace + ".updateViewCount", studyNo);
	}
}
