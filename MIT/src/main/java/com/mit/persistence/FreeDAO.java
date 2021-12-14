package com.mit.persistence;

import java.util.List;

import com.mit.domain.FreeFileVO;
import com.mit.domain.FreeVO;
import com.mit.domain.SearchCriteria;

public interface FreeDAO {
	   // 1. Free -  踰묉에 
	   public int create(FreeVO vo) throws Exception;
	   // 2. Free - 鈺곌퀬�돳
	   public FreeVO read(int freeNo) throws Exception;
	   
	   // 자유게시판 : 게시물 수정
	   public void update(FreeVO vo) throws Exception;
	   // 자유게시판 : 포함된 첨부파일 삭제   
	   public void deleteFile(int freeNo) throws Exception;
	   // 자유게시판 : 추가된 첨부파일 저장
	   public void insertFile(FreeFileVO fVo) throws Exception;
	   
	   // 4. Free -  沅� �젫
	   public void delete(int freeNo) throws Exception;
	   // 5. Free  沅� 肉� 獄�  野�  源� �뵳�딅뮞 �뱜
		public void updateViewCount(int freeNo) throws Exception;
	   
	   public List<FreeVO> listSearch(SearchCriteria cri) throws Exception;
	   
	   public int listSearchCount(SearchCriteria cri) throws Exception;

	   
	   // 첨부파일 목록
	   public List<FreeFileVO> fileList(int freeNo) throws Exception;

}
