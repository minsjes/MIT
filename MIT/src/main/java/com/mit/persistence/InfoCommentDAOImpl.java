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
	public void create(InfoCommentVO icvo) throws Exception {
		session.insert(namespace + ".create", icvo);
		
	}

	@Override
	public void delete(int commentNo) throws Exception {
		session.delete(namespace + ".delete", commentNo);
		
	}

	@Override
	public void deleteAll(int commentNo) throws Exception {
		session.delete(namespace + ".deleteAll", commentNo);
		
	}

	@Override
	public List<InfoCommentVO> list(int infoNo) throws Exception {
		return session.selectList(namespace + ".list", infoNo);
	}
	
	

}
