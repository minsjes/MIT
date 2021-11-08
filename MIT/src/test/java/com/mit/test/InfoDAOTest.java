package com.mit.test;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mit.domain.InfoVO;
import com.mit.persistence.InfoDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml" })
public class InfoDAOTest {

	@Inject
	private InfoDAO dao;

	@Test
	public void testCreate() throws Exception {

		InfoVO info = new InfoVO();
		info.setInfoTitle("새로운 제목을 넣습니다.");
		info.setInfoContent("새로운 글을 넣습니다.");
		info.setMemberNo(1000);

		dao.create(info);
	}

	@Test
	public void testRead() throws Exception {

		System.out.println(dao.read(1));

	}

	@Test
	public void testUpdate() throws Exception {

		InfoVO info = new InfoVO();
		info.setInfoNo(2);
		info.setInfoTitle("수정된 제목을 넣습니다.");
		info.setInfoContent("수정된 글을 넣습니다.");
		info.setMemberNo(1000);
		dao.update(info);
	}

	@Test
	public void testDelete() throws Exception {
		dao.delete(1);
	}

}
