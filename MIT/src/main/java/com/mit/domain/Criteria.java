package com.mit.domain;

public class Criteria {
	private int page; // 실행 시, 시작할 페이지
	private int perPageNum; // 화면에 보여줄 게시글 수
	
	private int startPage;// MyBatis(DB쿼리)에서 사용할 시작 페이지 
	
	public Criteria() { // 생성자로 페이징 초기화
		this.page = 1;
		this.perPageNum = 6;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if(page <= 0) { // 페이징에 대한 예외 사항 처리; 0보다 작거나 같을 경우
			this.page = 1;
			return;
		}
		
		this.page = page;
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		this.perPageNum = perPageNum;
	}
	
	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	// method for MyBatis SQL Mapper
	public int getPageEnd() {
		return this.startPage +5;
	}
	
	public int getPageStart() {
		this.startPage = (this.page * this.perPageNum)-5;
		return this.startPage;
	}

	@Override
	public String toString() {
		return "Criteria [page=" + page + ", perPageNum=" + perPageNum + ", startPage=" + startPage + "]";
	}
}
