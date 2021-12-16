package com.mit.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mit.domain.FreeCommentVO;

@Repository
public class FreeCommentDAOImpl implements FreeCommentDAO {
	
	@Inject
	private SqlSession session;
	
	private static final String namespace = "com.mit.mapper.FreeCommentMapper";
	
	@Override
	public void create(FreeCommentVO cvo) throws Exception {
		session.insert(namespace + ".create", cvo);
	}

	@Override
	public void delete(int commentNo) throws Exception {
		session.delete(namespace + ".delete", commentNo);
	}

	@Override
	public void deleteAll(int freeNo) throws Exception {
		session.delete(namespace + ".deleteAll", freeNo);
	}

	@Override
	public List<FreeCommentVO> list(int freeNo) throws Exception {
		return session.selectList(namespace + ".list", freeNo);
	}
}
