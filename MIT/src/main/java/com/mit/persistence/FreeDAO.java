package com.mit.persistence;

import java.util.List;

import com.mit.domain.FreeFileVO;
import com.mit.domain.FreeVO;

public interface FreeDAO {
	   // 1. Free -  甕곕쵇�뿉 
	   public int create(FreeVO vo) throws Exception;
	   // 2. Free - �댖怨뚰�э옙�뤂
	   public FreeVO read(int freeNo) throws Exception;
	   
	   // �옄�쑀寃뚯떆�뙋 : 寃뚯떆臾� �닔�젙
	   public void update(FreeVO vo) throws Exception;
	   // �옄�쑀寃뚯떆�뙋 : �룷�븿�맂 泥⑤��뙆�씪 �궘�젣   
	   public void deleteFile(int freeNo) throws Exception;
	   // �옄�쑀寃뚯떆�뙋 : 異붽��맂 泥⑤��뙆�씪 ���옣
	   public void insertFile(FreeFileVO fVo) throws Exception;
	   
	   // 4. Free -  亦낉옙 占쎌젷
	   public void delete(int freeNo) throws Exception;
	   // 5. Free  亦낉옙 �굢占� �뛾占�  �뇦占�  繹먲옙 占쎈뎨占쎈봾裕� 占쎈콦
	   public void updateViewCount(int freeNo) throws Exception;
	   
	   public List<FreeVO> list() throws Exception;
	   
	   // 泥⑤��뙆�씪 紐⑸줉
	   public List<FreeFileVO> fileList(int freeNo) throws Exception;
}
