package com.mit.domain;

public class HistoryVO {
	private int historyNo;
	private String historyDate;
	private String historyContent;
	private int memberNo;
	private int rnum;
	
	public int getHistoryNo() {
		return historyNo;
	}
	public void setHistoryNo(int historyNo) {
		this.historyNo = historyNo;
	}
	public String getHistoryDate() {
		return historyDate;
	}
	public void setHistoryDate(String historyDate) {
		this.historyDate = historyDate;
	}
	public String getHistoryContent() {
		return historyContent;
	}
	public void setHistoryContent(String historyContent) {
		this.historyContent = historyContent;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	
	@Override
	public String toString() {
		return "HistoryVO [historyNo=" + historyNo + ", historyDate=" + historyDate + ", historyContent="
				+ historyContent + ", memberNo=" + memberNo + ", rnum=" + rnum + "]";
	}
}
