
package com.mit.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.mit.domain.InfoFileVO;
import com.mit.domain.InfoVO;
import com.mit.domain.SearchCriteria;
import com.mit.persistence.InfoCommentDAO;
import com.mit.persistence.InfoDAO;

@Service
public class InfoServiceImpl implements InfoService {

	@Inject
	private InfoDAO dao;

	@Inject
	private InfoCommentDAO commDao;

	@Override
	public void create(InfoVO vo) throws Exception {
		// (1) 텍스트에어리어 줄바꿈 적용
		vo.setInfoContent(vo.getInfoContent().replace("\\r\\n", "<br>"));

		// (2) 기본 신청 내역 등록 (파일 등록 x) -> 등록된 신청내역의 PK 가져오기
		int infoNo = dao.create(vo);

		// (3) 추가 이미지 존재 여부 IF문
		if (vo.getFiles() != null) {

			// (4) 추가 이미지 저장 FOR문
			for (int i = 0; i < vo.getFiles().length; i++) {

				// (4-1) 추가 이미지 저장

				InfoFileVO fVo = new InfoFileVO();
				fVo.setInfoNo(infoNo);
				fVo.setFileName(vo.getFiles()[i]);

				// (4-2) 추가 이미지 저장
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
	public void update(InfoVO vo) throws Exception {
		// (1) 텍스트에어리어 줄바꿈 적용
		vo.setInfoContent(vo.getInfoContent().replace("\\r\\n", "<br>"));

		// (2) 프로그램 게시글 수정
		dao.update(vo);

		// (3) 프로그램 소속된 첨부파일 삭제
		dao.deleteFile(vo.getInfoNo());

		// (4) 추가 이미지 존재 여부 IF문
		if (vo.getFiles() != null) {

			// (5) 추가 이미지 저장 FOR문
			for (int i = 0; i < vo.getFiles().length; i++) {

				// (5-1)추가 이미지 저장

				InfoFileVO fVo = new InfoFileVO();
				fVo.setInfoNo(vo.getInfoNo());
				fVo.setFileName(vo.getFiles()[i]);

				// (5-2)추가 이미지 저장
				dao.insertFile(fVo);

			}
		}

	}

	@Override
	public void delete(int infoNo) throws Exception {
		// 첨부파일과, 댓글이 있는 문의글은

		// 1) 첨부 파일 삭제
		dao.deleteFile(infoNo);

		// 2) 댓글 삭제
		commDao.deleteAll(infoNo);

		// 3) 게시글 삭제
		dao.delete(infoNo);

	}

	@Override
	public List<InfoVO> listSearch(SearchCriteria cri) throws Exception {

		return dao.listSearch(cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {

		return dao.listSearchCount(cri);
	}

	@Override
	public List<InfoFileVO> fileList(int infoNo) throws Exception {
		return dao.fileList(infoNo);
	}

}