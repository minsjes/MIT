package com.mit.domain;

import java.util.Date;

public class JoinVO {
	
	private int joinNo;
	private String joinPw;
	private String joinName;
	private String joinPhone;
	private String joinText;
	private String allowStatus;
	private Date joinDate;
	private Date allowDate;
	private int memberNo;
	
	public int getJoinNo() {
		return joinNo;
	}
	public void setJoinNo(int joinNo) {
		this.joinNo = joinNo;
	}
	public String getJoinPw() {
		return joinPw;
	}
	public void setJoinPw(String joinPw) {
		this.joinPw = joinPw;
	}
	public String getJoinName() {
		return joinName;
	}
	public void setJoinName(String joinName) {
		this.joinName = joinName;
	}
	public String getJoinPhone() {
		return joinPhone;
	}
	public void setJoinPhone(String joinPhone) {
		this.joinPhone = joinPhone;
	}
	public String getJoinText() {
		return joinText;
	}
	public void setJoinText(String joinText) {
		this.joinText = joinText;
	}
	public String getAllowStatus() {
		return allowStatus;
	}
	public void setAllowStatus(String allowStatus) {
		this.allowStatus = allowStatus;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public Date getAllowDate() {
		return allowDate;
	}
	public void setAllowDate(Date allowDate) {
		this.allowDate = allowDate;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	
	@Override
	public String toString() {
		return "JoinVO [joinNo=" + joinNo + ", joinPw=" + joinPw + ", joinName=" + joinName + ", joinPhone=" + joinPhone
				+ ", joinText=" + joinText + ", allowStatus=" + allowStatus + ", joinDate=" + joinDate + ", allowDate="
				+ allowDate + ", memberNo=" + memberNo + "]";
	}
}
