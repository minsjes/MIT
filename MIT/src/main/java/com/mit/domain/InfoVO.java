package com.mit.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class InfoVO {
	
	private int infoNo;
	private String infoTitle;
	private String infoContent;
	private int memberNo;
	private Date infoDate;
	private String[] files;
	private ArrayList<InfoFileVO> filList;
	private String memberName;
	private int commentNo;
	private int rnum;
	public int getInfoNo() {
		return infoNo;
	}
	public void setInfoNo(int infoNo) {
		this.infoNo = infoNo;
	}
	public String getInfoTitle() {
		return infoTitle;
	}
	public void setInfoTitle(String infoTitle) {
		this.infoTitle = infoTitle;
	}
	public String getInfoContent() {
		return infoContent;
	}
	public void setInfoContent(String infoContent) {
		this.infoContent = infoContent;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public Date getInfoDate() {
		return infoDate;
	}
	public void setInfoDate(Date infoDate) {
		this.infoDate = infoDate;
	}
	public String[] getFiles() {
		return files;
	}
	public void setFiles(String[] files) {
		this.files = files;
	}
	public ArrayList<InfoFileVO> getFilList() {
		return filList;
	}
	public void setFilList(ArrayList<InfoFileVO> filList) {
		this.filList = filList;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public int getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	@Override
	public String toString() {
		return "InfoVO [infoNo=" + infoNo + ", infoTitle=" + infoTitle + ", infoContent=" + infoContent + ", memberNo="
				+ memberNo + ", infoDate=" + infoDate + ", files=" + Arrays.toString(files) + ", filList=" + filList
				+ ", memberName=" + memberName + ", commentNo=" + commentNo + ", rnum=" + rnum + "]";
	}
	
	
	
	
	
	
	
	
	
}
