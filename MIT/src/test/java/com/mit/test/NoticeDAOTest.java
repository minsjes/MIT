package com.mit.test;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mit.domain.NoticeVO;
import com.mit.persistence.NoticeDAO;

@RunWith (SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class NoticeDAOTest {

	@Inject
	private NoticeDAO dao;
	
	
	/*@Test
	public void testCreate() throws Exception{
		
		NoticeVO vo =  new NoticeVO();
		vo.setNoticeTitle("���ο� ������ �ֽ��ϴ�.");
		vo.setNoticeContent("���ο� ���� �ֽ��ϴ�.");
		vo.setMemberNo(20999999);
		dao.create(vo);
	}*/
	
		@Test
	public void testRead() throws Exception{
		
		System.out.println(dao.read(2));
	}
	/*
	@Test
    public void testUpdate() throws Exception{
		
		NoticeVO vo =  new NoticeVO();
		vo.setNoticeNo(1);
		vo.setNoticeTitle("������ ������ �ֽ��ϴ�.");
		vo.setNoticeContent("������ ���� �ֽ��ϴ�.");
		vo.setMemberNo(20999999);
		dao.update(vo);
	}
	
	@Test
	public void testDelete() throws Exception{
		dao.delete(1);
}  
*/
}
