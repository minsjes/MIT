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
			for (int i = 0; i < vo.getFiles().length; i++) {
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
		
		vo.setQnaContent(vo.getQnaContent().replace("\\r\\n", "<br>"));
		// 2)�Խñ� ����
		dao.update(vo);

		// 3)÷������ ����
		dao.deleteFile(vo.getQnaNo());

		// 4)÷������ ���� ���� IF��
		if (vo.getFiles() != null) {
			// 5)÷������ ���� FOR��
			for (int i=0; i<vo.getFiles().length; i++) {
				// 5-1)÷������ ����
				QnaFileVO qVo = new QnaFileVO();
				qVo.setQnaNo(vo.getQnaNo());
				qVo.setFileName(vo.getFiles()[i]);
				
				// 5-2)÷������ ����
				dao.insertFile(qVo);
			}
		}
	}

	@Override
	public void remove(int qnaNo) throws Exception {
		// 1)÷�� ���� ����
		dao.deleteFile(qnaNo);
		
		// 2) ��� ����
		commDao.deleteAll(qnaNo);
		
		// 3) �Խñ� ����
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