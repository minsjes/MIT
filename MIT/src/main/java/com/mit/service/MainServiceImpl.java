package com.mit.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.mit.domain.NoticeVO;
import com.mit.persistence.NoticeDAO;

@Service
public class MainServiceImpl implements MainService {
	@Inject
	private NoticeDAO dao;

	@Override
	public List<NoticeVO> list() throws Exception {
		return dao.list();
	}
}
