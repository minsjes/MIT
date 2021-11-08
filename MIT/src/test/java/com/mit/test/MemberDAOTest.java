package com.mit.test;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mit.domain.MemberVO;
import com.mit.domain.SearchCriteria;
import com.mit.persistence.MemberDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class MemberDAOTest {
	
	@Inject
	private MemberDAO dao;
	
	/*@Test
	public void testCreate() throws Exception{
		
		MemberVO member = new MemberVO();

		member.setMemberNo(20111234);
		member.setMemberPw("aaaa");
		member.setMemberName("홍길동");
		member.setMemberPhone("010-1234-5678");
		member.setMemberClass("회원");
		
		dao.create(member);
		
	}*/
	
	/*@Test
	public void testRead() throws Exception{
		
		System.out.println(dao.read(20111234));
	}*/
	
	@Test
	public void testUpdate() throws Exception{
		
		MemberVO member = new MemberVO();
		
		member.setMemberNo(20111234);
		
		member.setMemberPw("1234");
		member.setMemberName("홍수정");
		member.setMemberPhone("010-2222-3333");
		member.setMemberClass("조장");
		
		
		dao.update(member);
		
	}
	
	/*@Test
	public void testSearchList() throws Exception{
		
		SearchCriteria cri = new SearchCriteria();
		cri.setSearchType("n");
		cri.setKeyword("홍길동");
		
		List<MemberVO> list = dao.listSearch(cri);
		int totalCnt = dao.listSearchCount(cri);
		
		System.out.println("=========" + totalCnt);
		
		for (MemberVO vo : list) {
			System.out.println(vo);
		}
	}*/
	
	/*@Test
	public void testDelete() throws Exception{
		dao.delete(20111234);
	}*/

}
