package com.mit.service;

import java.util.List;

import com.mit.domain.InfoFileVO;
import com.mit.domain.InfoVO;

public interface InfoService {
	
	public void register(InfoVO vo) throws Exception;

	public InfoVO read(int infoNo) throws Exception;

	public void modify(InfoVO vo) throws Exception;

	public void remove(int infoNo) throws Exception;

	public List<InfoVO> list() throws Exception;

	public List<InfoFileVO> fileList(int infoNo) throws Exception;
}
