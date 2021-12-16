package com.mit.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.mit.domain.FreeFileVO;
import com.mit.domain.FreeVO;
import com.mit.persistence.FreeCommentDAO;
import com.mit.persistence.FreeDAO;

@Service
public class FreeServiceImpl implements FreeService {
	
	@Inject
	private FreeDAO dao;
	
	@Inject
	private FreeCommentDAO commDao;

	@Override
	public void register(FreeVO vo) throws Exception {
		int freeNo = dao.create(vo);

		if (vo.getFiles() != null) {
			for (int i=0; i<vo.getFiles().length; i++) {
				FreeFileVO fVo = new FreeFileVO();
				fVo.setFreeNo(freeNo);
				fVo.setFileName(vo.getFiles()[i]);

				dao.insertFile(fVo);
			}
		}
	}

	@Override
	public FreeVO read(int freeNo) throws Exception {
		dao.updateViewCount(freeNo);
		return dao.read(freeNo);		
	}
	
	@Override
	public void modify(FreeVO vo) throws Exception {
		// 2)게시글 수정
		dao.update(vo);

		// 3)첨부파일 삭제
		dao.deleteFile(vo.getFreeNo());

		// 4)첨부파일 존재 여부 IF문
		if (vo.getFiles() != null) {
			// 5)첨부파일 저장 FOR문
			for (int i=0; i<vo.getFiles().length; i++) {
				// 5-1)첨부파일 저장
				FreeFileVO fVo = new FreeFileVO();
				fVo.setFreeNo(vo.getFreeNo());
				fVo.setFileName(vo.getFiles()[i]);

				// 5-2)첨부파일 저장
				dao.insertFile(fVo);
			}
		}
	}

	@Override
	public void remove(int freeNo) throws Exception {
		// 1)첨부파일 삭제         
		dao.deleteFile(freeNo);

		// 2)댓글 삭제         
		commDao.deleteAll(freeNo);
		
		// 3)게시글 삭제     
		dao.delete(freeNo);

	}

	@Override
	public List<FreeVO> list() throws Exception {
		return dao.list();
	}

	@Override
	public List<FreeFileVO> fileList(int freeNo) throws Exception {
		return dao.fileList(freeNo);
	}
}
