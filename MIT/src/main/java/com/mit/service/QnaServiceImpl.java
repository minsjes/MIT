package com.mit.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.mit.domain.QnaFileVO;
import com.mit.domain.QnaVO;
import com.mit.persistence.QnaCommentDAO;
import com.mit.persistence.QnaDAO;

@Service
public class QnaServiceImpl implements QnaService {

	@Inject
	private QnaDAO dao;

	@Inject
	private QnaCommentDAO commDao;

	@Override
	public void register(QnaVO vo) throws Exception {
		int qnaNo = dao.create(vo);

		if (vo.getFiles() != null) {
			for (int i=0; i<vo.getFiles().length; i++) {
				QnaFileVO fVo = new QnaFileVO();
				fVo.setQnaNo(qnaNo);
				fVo.setFileName(vo.getFiles()[i]);

				dao.insertFile(fVo);
			}
		}
	}

	@Override
	public QnaVO read(int qnaNo) throws Exception {
		dao.updateViewCount(qnaNo);
		return dao.read(qnaNo);
	}

	@Override
	public void modify(QnaVO vo) throws Exception {
		// 2)게시글 수정
		dao.update(vo);

		// 3)첨부파일 삭제
		dao.deleteFile(vo.getQnaNo());

		// 4)첨부파일 삭제
		if (vo.getFiles() != null) {
			// 5)첨부파일 저장 FOR문
			for (int i=0; i<vo.getFiles().length; i++) {
				// 5-1)첨부파일 저장
				QnaFileVO qVo = new QnaFileVO();
				qVo.setQnaNo(vo.getQnaNo());
				qVo.setFileName(vo.getFiles()[i]);
				
				// 5-2)첨부파일 저장
				dao.insertFile(qVo);
			}
		}
	}

	@Override
	public void remove(int qnaNo) throws Exception {
		// 1)첨부파일 삭제
		dao.deleteFile(qnaNo);
		
		// 2)댓글 삭제
		commDao.deleteAll(qnaNo);
		
		// 3)게시글 삭제
		dao.delete(qnaNo);
	}

	@Override
	public List<QnaVO> list() throws Exception {
		return dao.list();
	}

	@Override
	public List<QnaFileVO> fileList(int qnaNo) throws Exception {
		return dao.fileList(qnaNo);
	}
}
