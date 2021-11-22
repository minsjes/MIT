package com.mit.domain;

import java.util.Date;

public class HistoryVO {
	private int rnum;
	private int historyNo;
	private Date historyDate;
	private String historyContent;
	private int memberNo;
	private String memberName;
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	public int getHistoryNo() {
		return historyNo;
	}
	public void setHistoryNo(int historyNo) {
		this.historyNo = historyNo;
	}
	public Date getHistoryDate() {
		return historyDate;
	}
	public void setHistoryDate(Date historyDate) {
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
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	@Override
	public String toString() {
		return "HistoryVO [rnum=" + rnum + ", historyNo=" + historyNo + ", historyDate=" + historyDate
				+ ", historyContent=" + historyContent + ", memberNo=" + memberNo + ", memberName=" + memberName + "]";
	}
	
}