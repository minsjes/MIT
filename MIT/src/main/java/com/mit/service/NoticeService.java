package com.mit.service;

import java.util.List;

import com.mit.domain.NoticeVO;

public interface NoticeService {

	public void create(NoticeVO vo) throws Exception;

	public NoticeVO read(int noticeNo) throws Exception;

	public void update(NoticeVO vo) throws Exception;

	public void delete(int noticeNo) throws Exception;

	public List<NoticeVO> listSearch() throws Exception;

	public int listSearchCount() throws Exception;

}
