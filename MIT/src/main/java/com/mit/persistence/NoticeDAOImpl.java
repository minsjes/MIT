package com.mit.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mit.domain.NoticeVO;

@Repository
public class NoticeDAOImpl implements NoticeDAO {
	
	@Inject
	private SqlSession session;
	
	private static final String namespace = "com.mit.mapper.NoticeMapper";

	@Override
	public void create(NoticeVO vo) throws Exception {
		session.insert(namespace+".create", vo);
		
	}

	@Override
	public NoticeVO read(int noticeNo) throws Exception {
		return session.selectOne(namespace + ".read", noticeNo);
	}

	@Override
	public void update(NoticeVO vo) throws Exception {
		session.update(namespace+".update", vo);
		
	}

	@Override
	public void delete(int noticeNo) throws Exception {
		session.delete(namespace + ".delete", noticeNo);
		
	}

	@Override
	public List<NoticeVO> listSearch() throws Exception {
		return session.selectList(namespace+".listSearch");
	}

	@Override
	public int listSearchCount() throws Exception {
		return session.selectOne(namespace+".listSearchCount");
	}

	@Override
	public List<NoticeVO> list() throws Exception {
		return session.selectList(namespace + ".list");
	}

}
