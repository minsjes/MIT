package com.mit.domain;

public class MemberVO {
	
	private int rnum;
	
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}

	private int memberNo ;
	private String memberPw;
	private String memberName;
	private String memberPhone;
	private String memberClass;
	private String allowDate;
	private String dormancyStatus;
	
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	public String getMemberClass() {
		return memberClass;
	}
	public void setMemberClass(String memberClass) {
		this.memberClass = memberClass;
	}
	public String getAllowDate() {
		return allowDate;
	}
	public void setAllowDate(String allowDate) {
		this.allowDate = allowDate;
	}
	public String getDormancyStatus() {
		return dormancyStatus;
	}
	public void setDormancyStatus(String dormancyStatus) {
		this.dormancyStatus = dormancyStatus;
	}
	
	@Override
	public String toString() {
		return "MemberVO [memberNo=" + memberNo + ", memberPw=" + memberPw + ", memberName=" + memberName
				+ ", memberPhone=" + memberPhone + ", memberClass=" + memberClass + ", allowDate=" + allowDate
				+ ", dormancyStatus=" + dormancyStatus + "]";
	}
}
