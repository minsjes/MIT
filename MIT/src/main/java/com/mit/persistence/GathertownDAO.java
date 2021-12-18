package com.mit.persistence;

import java.util.List;

import com.mit.domain.GathertownVO;

public interface GathertownDAO {
	public void create(GathertownVO vo) throws Exception;
	
	public GathertownVO read(int gathertownNo) throws Exception;
	
	public void update(GathertownVO vo) throws Exception;
	
	public void delete(int gathertownNo) throws Exception;
	
	public List<GathertownVO> list() throws Exception;
}
