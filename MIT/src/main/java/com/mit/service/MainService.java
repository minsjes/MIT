package com.mit.service;

import java.util.List;

import com.mit.domain.NoticeVO;

public interface MainService {
	public List<NoticeVO> list() throws Exception;
}