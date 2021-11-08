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

		// (2)  ⺻   û          (         x) ->   ϵ    û       PK         
		int freeNo = dao.create(vo);

		// (3)  ߰   ̹              IF  
		if (vo.getFiles() != null) {

			// (4)  ߰   ̹         FOR  
			for (int i = 0; i < vo.getFiles().length; i++) {

				// (4-1)  ߰   ̹        

				FreeFileVO fVo = new FreeFileVO();
				fVo.setFreeNo(freeNo);
				fVo.setFileName(vo.getFiles()[i]);

				// (4-2)  ߰   ̹        
				dao.insertFile(fVo);
			}
		}

	}

	@Override
	public FreeVO read(int freeNo) throws Exception {
		return dao.read(freeNo);
	}

	@Override
	public void update(FreeVO vo) throws Exception {
		vo.setFreeContent(vo.getFreeContent().replace("\\r\\n", "<br>"));

		// (2)    α׷   Խñ      
		dao.update(vo);

		// (3)    α׷   Ҽӵ  ÷           
		dao.deleteFile(vo.getFreeNo());

		// (4)  ߰   ̹              IF  
		if (vo.getFiles() != null) {

			// (5)  ߰   ̹         FOR  
			for (int i = 0; i < vo.getFiles().length; i++) {

				// (5-1) ߰   ̹        

				FreeFileVO fVo = new FreeFileVO();
				fVo.setFreeNo(vo.getFreeNo());
				fVo.setFileName(vo.getFiles()[i]);

				// (5-2) ߰   ̹        
				dao.insertFile(fVo);

			}
		}

	}

	@Override
	public void delete(int freeNo) throws Exception {
		// ÷     ϰ ,        ִ     Ǳ   

		// 1) ÷            
		dao.deleteFile(freeNo);

		// 2)         
		commDao.deleteAll(freeNo);
		
		// 3)  Խñ      
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

	@Override
	public List<FreeFileVO> fileList(int freeNo) throws Exception {
		return dao.fileList(freeNo);
	}

}