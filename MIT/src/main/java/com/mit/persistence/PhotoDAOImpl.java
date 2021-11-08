package com.mit.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mit.domain.PhotoFileVO;
import com.mit.domain.PhotoVO;
import com.mit.domain.SearchCriteria;

@Repository
public class PhotoDAOImpl implements PhotoDAO {

	@Inject
	private SqlSession session;
	
	private static final String namespace = "com.mit.mapper.PhotoMapper";
	
	@Override
	public int create(PhotoVO vo) throws Exception {
		session.insert(namespace+".create", vo);
		return vo.getPhotoNo();
		
	}

	@Override
	public PhotoVO read(int photoNo) throws Exception {
		return session.selectOne(namespace+".read", photoNo);
	}

	@Override
	public void update(PhotoVO vo) throws Exception {
		session.update(namespace+".update", vo);
		
	}

	@Override
	public void delete(int photoNo) throws Exception {
		session.delete(namespace+".delete", photoNo);
		
	}

	@Override
	public List<PhotoVO> listSearch(SearchCriteria cri) throws Exception {
		return session.selectList(namespace+".listSearch", cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return session.selectOne(namespace+".listSearchCount", cri);
	}

	@Override
	public void insertFile(PhotoFileVO fVo) throws Exception {
		session.insert(namespace+".insertFile", fVo);
		
	}

	@Override
	public void deleteFile(int photoNo) throws Exception {
		session.delete(namespace+".deleteFile", photoNo);
		
	}

	@Override
	public List<PhotoFileVO> fileList(int photoNo) throws Exception {
		return session.selectList(namespace+".fileList", photoNo);
	}

}
