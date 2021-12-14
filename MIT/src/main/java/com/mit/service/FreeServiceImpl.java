package com.mit.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.mit.domain.FreeFileVO;
import com.mit.domain.FreeVO;
import com.mit.domain.SearchCriteria;
import com.mit.persistence.FreeCommentDAO;
import com.mit.persistence.FreeDAO;

@Service
public class FreeServiceImpl implements FreeService {
	@Inject
	private FreeDAO dao;
	
	@Inject
	private FreeCommentDAO commDao;

	@Override
	public void create(FreeVO vo) throws Exception {
		vo.setFreeContent(vo.getFreeContent().replace("\\r\\n", "<br>"));

		// (2)  羞�   청          (         x) ->   溝    청       PK         
		int freeNo = dao.create(vo);

		// (3)  煞   譴              IF  
		if (vo.getFiles() != null) {

			// (4)  煞   譴         FOR  
			for (int i = 0; i < vo.getFiles().length; i++) {

				// (4-1)  煞   譴        

				FreeFileVO fVo = new FreeFileVO();
				fVo.setFreeNo(freeNo);
				fVo.setFileName(vo.getFiles()[i]);

				// (4-2)  煞   譴        
				dao.insertFile(fVo);
			}
		}

	}

	@Override
	public FreeVO read(int freeNo) throws Exception {
		dao.updateViewCount(freeNo);
		return dao.read(freeNo);
		
	}
	
	// 자유게시판 : 게시물 수정
	@Override
	public void update(FreeVO vo) throws Exception {
		
		// 텍스트에어리어 줄바꿈 적용
		vo.setFreeContent(vo.getFreeContent().replace("\\r\\n", "<br>"));

		// 자유게시판 : 게시글 수정
		dao.update(vo);

		// 자유게시판 : 포함된 첨부파일 삭제         
		dao.deleteFile(vo.getFreeNo());

		//  추가할 파일 존재시 if문 수행
		if (vo.getFiles() != null) {

			System.out.println("(if)추가파일 : " + vo.getFiles());
			
			// 추가 파일 저장 for문 수행
			for (int i = 0; i < vo.getFiles().length; i++) {

				FreeFileVO fVo = new FreeFileVO();
				
				fVo.setFreeNo(vo.getFreeNo());
				fVo.setFileName(vo.getFiles()[i]);

				// 추가 파일 저장    
				dao.insertFile(fVo);

			}
		}

	}

	@Override
	public void delete(int freeNo) throws Exception {
		// 첨     構 ,        獵     풉   

		// 1) 첨            
		dao.deleteFile(freeNo);

		// 2)         
		commDao.deleteAll(freeNo);
		
		// 3)  督챰      
		dao.delete(freeNo);

	}

	@Override
	public List<FreeVO> listSearch(SearchCriteria cri) throws Exception {
		return dao.listSearch(cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return dao.listSearchCount(cri);
	}

	// 첨부파일 목록
	@Override
	public List<FreeFileVO> fileList(int freeNo) throws Exception {
		return dao.fileList(freeNo);
	}


}