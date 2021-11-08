package com.mit.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.mit.domain.PhotoFileVO;
import com.mit.domain.PhotoVO;
import com.mit.domain.SearchCriteria;
import com.mit.persistence.PhotoCommentDAO;
import com.mit.persistence.PhotoDAO;

@Service
public class PhotoServiceImpl implements PhotoService{
	
	@Inject
	private PhotoDAO dao;
	
	@Inject
	private PhotoCommentDAO commDao;

	@Override
	public void create(PhotoVO vo) throws Exception {
		vo.setPhotoContent(vo.getPhotoContent().replace("\\r\\n", "<br>"));

		// (2) �⺻ ��û ���� ��� (���� ��� x) -> ��ϵ� ��û������ PK ��������
		int photoNo = dao.create(vo);

		// (3) �߰� �̹��� ���� ���� IF��
		if (vo.getFiles() != null) {

			// (4) �߰� �̹��� ���� FOR��
			for (int i = 0; i < vo.getFiles().length; i++) {

				// (4-1) �߰� �̹��� ����

				PhotoFileVO fVo = new PhotoFileVO();
				fVo.setPhotoNo(photoNo);
				fVo.setFileName(vo.getFiles()[i]);

				// (4-2) �߰� �̹��� ����
				dao.insertFile(fVo);
			}
		}
		
	}

	@Override
	public PhotoVO read(int photoNo) throws Exception {
		return dao.read(photoNo);
	}

	@Override
	public void update(PhotoVO vo) throws Exception {
		vo.setPhotoContent(vo.getPhotoContent().replace("\\r\\n", "<br>"));

		// (2) ���α׷� �Խñ� ����
		dao.update(vo);

		// (3) ���α׷� �Ҽӵ� ÷������ ����
		dao.deleteFile(vo.getPhotoNo());

		// (4) �߰� �̹��� ���� ���� IF��
		if (vo.getFiles() != null) {

			// (5) �߰� �̹��� ���� FOR��
			for (int i = 0; i < vo.getFiles().length; i++) {

				// (5-1)�߰� �̹��� ����

				PhotoFileVO fVo = new PhotoFileVO();
				fVo.setPhotoNo(vo.getPhotoNo());
				fVo.setFileName(vo.getFiles()[i]);

				// (5-2)�߰� �̹��� ����
				dao.insertFile(fVo);

			}
		}
		
	}

	@Override
	public void delete(int photoNo) throws Exception {

		// 1) ÷�� ���� ����
		dao.deleteFile(photoNo);

		// 2) ��� ����
		commDao.deleteAll(photoNo);
		
		// 3) �Խñ� ����
		dao.delete(photoNo);
		
	}

	@Override
	public List<PhotoVO> listSearch(SearchCriteria cri) throws Exception {
		return dao.listSearch(cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return dao.listSearchCount(cri);
	}

	@Override
	public List<PhotoFileVO> fileList(int photoNo) throws Exception {
		return dao.fileList(photoNo);
	}

	


}
