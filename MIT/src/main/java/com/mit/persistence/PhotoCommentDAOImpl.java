package com.mit.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mit.domain.PhotoCommentVO;

@Repository
public class PhotoCommentDAOImpl implements PhotoCommentDAO{
	@Inject
	private SqlSession session;
	
	private static final String namespace = "com.mit.mapper.PhotoCommentMapper";

	@Override
	public void create(PhotoCommentVO pcvo) throws Exception {
		session.insert(namespace + ".create", pcvo);
		
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
	public List<PhotoCommentVO> list(int photoNo) throws Exception {
		return session.selectList(namespace + ".list", photoNo);
	}
	
	

}
