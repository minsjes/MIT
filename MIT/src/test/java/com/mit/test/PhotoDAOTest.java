package com.mit.test;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mit.domain.PhotoVO;
import com.mit.persistence.PhotoDAO;

@RunWith (SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class PhotoDAOTest {

	@Inject
	private PhotoDAO dao;
	
	
	@Test
	public void testCreate() throws Exception{
		
		PhotoVO vo =  new PhotoVO();
		vo.setPhotoTitle("救成");
		vo.setPhotoContent("救成");
		vo.setMemberNo(20123456);
		dao.create(vo);
	}
	
	@Test
	public void testRead() throws Exception{
		
		System.out.println(dao.read(5));
	}
	
	@Test
    public void testUpdate() throws Exception{
		
		PhotoVO vo =  new PhotoVO();
		vo.setPhotoNo(2);
		vo.setPhotoTitle("居成");
		vo.setPhotoContent("救成");
		vo.setMemberNo(20123456);
		dao.update(vo);
	}
	
	@Test
	public void testDelete() throws Exception{
		dao.delete(3);
}

}
