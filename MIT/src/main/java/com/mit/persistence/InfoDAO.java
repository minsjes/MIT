
package com.mit.persistence;

import java.util.List;

import com.mit.domain.InfoFileVO;
import com.mit.domain.InfoVO;
import com.mit.domain.SearchCriteria;

public interface InfoDAO {

	public int create(InfoVO vo) throws Exception;

	public InfoVO read(int infoNo) throws Exception;

	public void update(InfoVO vo) throws Exception;

	public void delete(int infoNo) throws Exception;

	// 페이징 + 검색을 처리하여 리스트 가져오는 기능
	public List<InfoVO> listSearch(SearchCriteria cri) throws Exception;

	// 페이징 + 검색을 위한 전체 게시글 수 가져오는 기능
	public int listSearchCount(SearchCriteria cri) throws Exception;

	public void insertFile(InfoFileVO fVo) throws Exception;

	// 8. 관리자 :: 파일 삭제
	public void deleteFile(int infoNo) throws Exception;

	// 9. 관리자 :: 파일 목록
	public List<InfoFileVO> fileList(int infoNo) throws Exception;

	// 게시글의 조회수 업데이트 기능
	public void updateViewCount(int infoNo) throws Exception;

}
