package com.mit.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.mit.domain.JoinVO;
import com.mit.domain.SearchCriteria;
import com.mit.persistence.JoinDAO;
import com.mit.persistence.MemberDAO;

@Service
public class JoinServiceImpl implements JoinService {
	@Inject
	private JoinDAO dao;
	
	@Inject
	private MemberDAO mDao;
	
	@Override
	public void create(JoinVO vo) throws Exception {
		dao.create(vo);
	}

	@Override
	public JoinVO read(int joinNo) throws Exception {
		return dao.read(joinNo);
	}

	@Override
	public void update(JoinVO vo) throws Exception {
		// 승인 또는 거절 상태로 바꾸기
		dao.update(vo);
		
		// 승인 시, 회원 목록에 추가
		String allowStatus = vo.getAllowStatus();
		int joinNo = vo.getJoinNo();
		
		if(allowStatus == "1") {
			mDao.change(joinNo);
		}
	}

	@Override
	public void delete(JoinVO vo) throws Exception {
		dao.delete(vo);
	}

	@Override
	public List<JoinVO> listSearch() throws Exception {
		return dao.listSearch();
	}

	@Override
	public int listSearchCount() throws Exception {
		return dao.listSearchCount();
	}

	@Override
	public int idChk(int joinNo) throws Exception {
		return dao.idCheck(joinNo);
	}

}
