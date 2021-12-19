package com.mit.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.mit.domain.SuggestionFileVO;
import com.mit.domain.SuggestionVO;
import com.mit.persistence.SuggestionCommentDAO;
import com.mit.persistence.SuggestionDAO;

@Service
public class SuggestionServiceImpl implements SuggestionService {
	
	@Inject
	private SuggestionDAO dao;
	
	@Inject
	private SuggestionCommentDAO commDao;
	
	@Override
	public void register(SuggestionVO vo) throws Exception {
		int suggestionNo = dao.create(vo);
		
		if (vo.getFiles() != null) {
			for (int i=0; i<vo.getFiles().length; i++) {
				SuggestionFileVO fVo = new SuggestionFileVO();
				fVo.setSuggestionNo(suggestionNo);
				fVo.setFileName(vo.getFiles()[i]);
				
				dao.insertFile(fVo);
			}
		}
	}

	@Override
	public SuggestionVO read(int suggestionNo) throws Exception {
		return dao.read(suggestionNo);
	}

	@Override
	public void modify(SuggestionVO vo) throws Exception {
		dao.update(vo);
		
		dao.deleteFile(vo.getSuggestionNo());
		
		if (vo.getFiles() != null) {
			for (int i=0; i<vo.getFiles().length; i++) {
				SuggestionFileVO fVo = new SuggestionFileVO();
				fVo.setSuggestionNo(vo.getSuggestionNo());
				fVo.setFileName(vo.getFiles()[i]);
				
				dao.insertFile(fVo);
			}
		}
	}

	@Override
	public void remove(int suggestionNo) throws Exception {
		dao.deleteFile(suggestionNo);
		
		commDao.deleteAll(suggestionNo);
		
		dao.delete(suggestionNo);
	}

	@Override
	public List<SuggestionVO> list() throws Exception {
		return dao.list();
	}

	@Override
	public List<SuggestionFileVO> fileList(int suggestionNo) throws Exception {
		return dao.fileList(suggestionNo);
	}
}
