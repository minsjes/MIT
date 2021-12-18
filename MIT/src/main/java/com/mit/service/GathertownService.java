package com.mit.service;

import java.util.List;

import com.mit.domain.GathertownVO;

public interface GathertownService {
	
	public void register(GathertownVO vo) throws Exception;
	
	public GathertownVO read(int gathertownNo) throws Exception;
	
	public void modify(GathertownVO vo) throws Exception;
	
	public void remove(int gathertownNo) throws Exception;
	
	public List<GathertownVO> list() throws Exception;
}
