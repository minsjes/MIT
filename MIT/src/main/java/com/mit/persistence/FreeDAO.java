package com.mit.persistence;

import java.util.List;

import com.mit.domain.FreeFileVO;
import com.mit.domain.FreeVO;
import com.mit.domain.SearchCriteria;

public interface FreeDAO {
	   // 1. Free -  벑濡 
	   public int create(FreeVO vo) throws Exception;
	   // 2. Free - 議고쉶
	   public FreeVO read(int freeNo) throws Exception;
	   // 3. Free -  닔 젙
	   public void update(FreeVO vo) throws Exception;
	   // 4. Free -  궘 젣
	   public void delete(int freeNo) throws Exception;
	   // 5. Free  궡 뿭 諛  寃  깋 由ъ뒪 듃
		public void updateViewCount(int freeNo) throws Exception;
	   
	   public List<FreeVO> listSearch(SearchCriteria cri) throws Exception;
	   
	   public int listSearchCount(SearchCriteria cri) throws Exception;
	   
	   public void insertFile(FreeFileVO fVo) throws Exception;
	   
	    // 8. 관리자 :: 파일 삭제
	    public void deleteFile(int freeNo) throws Exception;
	   
	   // 9. 관리자 :: 파일 목록
	   public List<FreeFileVO> fileList(int freeNo) throws Exception;

}
