package com.mit.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.mit.domain.InfoFileVO;
import com.mit.domain.InfoVO;
import com.mit.persistence.InfoCommentDAO;
import com.mit.persistence.InfoDAO;

@Service
public class InfoServiceImpl implements InfoService {

	@Inject
	private InfoDAO dao;

	@Inject
	private InfoCommentDAO commDao;

	@Override
	public void register(InfoVO vo) throws Exception {
		// 2)기본 신청 내역 등록 (파일 등록 x) → 등록된 신청내역의 PK 가져오기
		int infoNo = dao.create(vo);

		// 3)추가 이미지 존재 여부 IF문
		if (vo.getFiles() != null) {
			// 4)추가 이미지 저장 FOR문
			for (int i=0; i<vo.getFiles().length; i++) {
				// 4-1)추가 이미지 저장
				InfoFileVO fVo = new InfoFileVO();
				fVo.setInfoNo(infoNo);
				fVo.setFileName(vo.getFiles()[i]);

				// 4-2)추가 이미지 저장
				dao.insertFile(fVo);
			}
		}
	}

	@Override
	public InfoVO read(int infoNo) throws Exception {
		dao.updateViewCount(infoNo);
		return dao.read(infoNo);
	}

	@Override
	public void modify(InfoVO vo) throws Exception {
		// 2)게시글 수정
		dao.update(vo);

		// 3)첨부파일 삭제
		dao.deleteFile(vo.getInfoNo());

		// 4)첨부파일 존재 여부 IF문
		if (vo.getFiles() != null) {
			// 5)첨부파일 저장 FOR문
			for (int i=0; i<vo.getFiles().length; i++) {
				// 5-1)첨부파일 저장
				InfoFileVO fVo = new InfoFileVO();
				fVo.setInfoNo(vo.getInfoNo());
				fVo.setFileName(vo.getFiles()[i]);

				// 5-2)첨부파일 저장
				dao.insertFile(fVo);
			}
		}
	}

	@Override
	public void remove(int infoNo) throws Exception {
		// 1) 첨부파일 삭제
		dao.deleteFile(infoNo);

		// 2) 댓글 삭제
		commDao.deleteAll(infoNo);

		// 3) 게시글 삭제
		dao.delete(infoNo);
	}

	@Override
	public List<InfoVO> list() throws Exception {
		return dao.list();
	}

	@Override
	public List<InfoFileVO> fileList(int infoNo) throws Exception {
		return dao.fileList(infoNo);
	}
}
