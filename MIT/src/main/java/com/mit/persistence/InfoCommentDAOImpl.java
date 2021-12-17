package com.mit.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mit.domain.InfoCommentVO;

@Repository
public class InfoCommentDAOImpl implements InfoCommentDAO {
	
	@Inject
	private SqlSession session;
	
	private static final String namespace = "com.mit.mapper.InfoCommentMapper";

	@Override
	public void create(InfoCommentVO cvo) throws Exception {
		session.insert(namespace + ".create", cvo);
	}

	@Override
	public void delete(int commentNo) throws Exception {
		session.delete(namespace + ".delete", commentNo);
	}

	@Override
	public void deleteAll(int infoNo) throws Exception {
		session.delete(namespace + ".deleteAll", infoNo);
	}

	@Override
	public List<InfoCommentVO> list(int infoNo) throws Exception {
		return session.selectList(namespace + ".list", infoNo);
	}
}
