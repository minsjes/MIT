package com.mit.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mit.domain.StudyCommentVO;

@Repository
public class StudyCommentDAOImpl implements StudyCommentDAO {
	
	@Inject
	private SqlSession session;
	
	private static final String namespace = "com.mit.mapper.StudyCommentMapper";
	
	@Override
	public void create(StudyCommentVO cvo) throws Exception {
		session.insert(namespace + ".create", cvo);
	}

	@Override
	public void delete(int commentNo) throws Exception {
		session.delete(namespace + ".delete", commentNo);
	}

	@Override
	public void deleteAll(int studyNo) throws Exception {
		session.delete(namespace + ".deleteAll", studyNo);
	}

	@Override
	public List<StudyCommentVO> list(int studyNo) throws Exception {
		return session.selectList(namespace + ".list", studyNo);
	}
}
