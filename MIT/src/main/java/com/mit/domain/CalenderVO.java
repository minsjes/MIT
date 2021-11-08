package com.mit.domain;

import java.util.Date;

public class CalenderVO {
	
	private Date startDate;
	private String calenderTitle;
	private String calenderContent;
	private int calenderNo;
	private Date endDate;
	private int memberNo;
	
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public String getCalenderTitle() {
		return calenderTitle;
	}
	public void setCalenderTitle(String calenderTitle) {
		this.calenderTitle = calenderTitle;
	}
	public String getCalenderContent() {
		return calenderContent;
	}
	public void setCalenderContent(String calenderContent) {
		this.calenderContent = calenderContent;
	}
	public int getCalenderNo() {
		return calenderNo;
	}
	public void setCalenderNo(int calenderNo) {
		this.calenderNo = calenderNo;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	
	@Override
	public String toString() {
		return "CalenderVO [startDate=" + startDate + ", calenderTitle=" + calenderTitle + ", calenderContent="
				+ calenderContent + ", calenderNo=" + calenderNo + ", endDate=" + endDate + ", memberNo=" + memberNo
				+ "]";
	}
	
	
	
	
	
	
	
}
