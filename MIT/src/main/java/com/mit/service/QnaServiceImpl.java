package com.mit.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.mit.domain.QnaFileVO;
import com.mit.domain.QnaVO;
import com.mit.domain.SearchCriteria;
import com.mit.persistence.QnaCommentDAO;
import com.mit.persistence.QnaDAO;

@Service
public class QnaServiceImpl implements QnaService{
	
	@Inject
	private QnaDAO dao;
	
	@Inject
	private QnaCommentDAO commDao;

	@Override
	public void create(QnaVO vo) throws Exception {
		vo.setQnaContent(vo.getQnaContent().replace("\\r\\n", "<br>"));
		
		int qnaNo = dao.create(vo);
		
		if (vo.getFiles() != null) {
			
			for (int i = 0; i < vo.getFiles().length; i ++) {
				
				QnaFileVO qVo = new QnaFileVO();
				qVo.setQnaNo(qnaNo);
				qVo.setFileName(vo.getFiles()[i]);
				
				dao.insertFile(qVo);
			}
		}

		
	}

	@Override
	public QnaVO read(int qnaNo) throws Exception {
		return dao.read(qnaNo);
	}

	@Override
	public void update(QnaVO vo) throws Exception {
		vo.setQnaContent(vo.getQnaContent().replace("\\r\\n", "<br>"));
		
		dao.update(vo);
		
		dao.deleteFile(vo.getQnaNo());
		
		if (vo.getFiles() != null) {
			
			for (int i = 0; i < vo.getFiles().length; i++) {
				
				QnaFileVO qVo = new QnaFileVO();
				qVo.setQnaNo(vo.getQnaNo());
				qVo.setFileName(vo.getFiles()[i]);
				
				dao.insertFile(qVo);
			}
		}
		
	}

	@Override
	public void delete(int qnaNo) throws Exception {
		
		dao.deleteFile(qnaNo);
		
		commDao.deleteAll(qnaNo);
		
		dao.delete(qnaNo);
		
		
	}

	@Override
	public List<QnaVO> listSearch() throws Exception {
		return dao.listSearch();
	}

	@Override
	public int listSearchCount() throws Exception {
		return dao.listSearchCount();
	}
	
	@Override
	public List<QnaFileVO> fileList(int qnaNo) throws Exception {
		return dao.fileList(qnaNo);
	}

}
