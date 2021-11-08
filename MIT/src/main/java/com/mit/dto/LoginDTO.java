package com.mit.dto;

public class LoginDTO {
	
	private int memberNo;
	private String memberPw;
	private boolean useCookie;
	
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
	public boolean isUseCookie() {
		return useCookie;
	}
	public void setUseCookie(boolean useCookie) {
		this.useCookie = useCookie;
	}
	
	@Override
	public String toString() {
		return "LoginDTO [memberNo=" + memberNo + ", memberPw=" + memberPw + ", useCookie=" + useCookie + "]";
	}
	
	
	

}
