package com.mit.test;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mit.domain.QnaVO;
import com.mit.domain.SearchCriteria;
import com.mit.persistence.QnaDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class QnaDAOTest {
	
	@Inject
	private QnaDAO dao;
	
	/*@Test
	public void testCreate() throws Exception {
		QnaVO qna = new QnaVO();
		qna.setQnaTitle("궁금합니다.");
		qna.setQnaContent("코딩 어떻게 잘해요?");
		qna.setMemberNo(20136677); 
		
		dao.create(qna);
	}*/
	
	@Test
	public void testRead() throws Exception {
		System.out.println(dao.read(2));
	}
	
	
	/*@Test
	public void testUpdate() throws Exception {
		QnaVO vo = new QnaVO();
		vo.setQnaNo(2);
		vo.setQnaTitle("[수정]궁급합니다.");
		vo.setQnaContent("수정입니다.");
		
		dao.update(vo);
	}*/
	
	
	/*@Test
	public void testDelete() throws Exception {
		dao.delete(1);
	}*/
	
	
	/*@Test
	public void testListSearch() throws Exception {
		SearchCriteria cri = new SearchCriteria();
		cri.setSearchType("c");
		cri.setKeyword("코딩");
		
		List<QnaVO> list = dao.listSearch(cri);
		int totalCnt = dao.listSearchCount(cri);
		
		System.out.println("=====" + totalCnt);
		
		for (QnaVO vo : list) {
			System.out.println(vo);
		}
	}*/
	
	/*@Test
	public void testUpdateViewCount() throws Exception {
		dao.updateViewCount(1);
	}*/
}
