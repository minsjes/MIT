package com.mit.persistence;

import java.util.List;

import com.mit.domain.InfoFileVO;
import com.mit.domain.InfoVO;

public interface InfoDAO {

	public int create(InfoVO vo) throws Exception;

	public InfoVO read(int infoNo) throws Exception;

	public void update(InfoVO vo) throws Exception;

	public void delete(int infoNo) throws Exception;
	
	public List<InfoVO> list() throws Exception;
	
	// 파일 등록
	public void insertFile(InfoFileVO fVo) throws Exception;

	// 파일 삭제
	public void deleteFile(int infoNo) throws Exception;

	// 파일 목록
	public List<InfoFileVO> fileList(int infoNo) throws Exception;

	// 게시글의 조회수 업데이트 기능
	public void updateViewCount(int infoNo) throws Exception;
}
