package com.mit.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class FreeVO {
	private int freeNo;
	private String freeTitle;
	private String freeContent;
	private Date freeDate;
	private int memberNo;
	private String memberName;
	private String[] files;
	private ArrayList<FreeFileVO> filList;
	private int commentNo;
	private int rnum;

	public int getFreeNo() {
		return freeNo;
	}

	public void setFreeNo(int freeNo) {
		this.freeNo = freeNo;
	}

	public String getFreeTitle() {
		return freeTitle;
	}

	public void setFreeTitle(String freeTitle) {
		this.freeTitle = freeTitle;
	}

	public String getFreeContent() {
		return freeContent;
	}

	public void setFreeContent(String freeContent) {
		this.freeContent = freeContent;
	}

	public Date getFreeDate() {
		return freeDate;
	}

	public void setFreeDate(Date freeDate) {
		this.freeDate = freeDate;
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

	public String[] getFiles() {
		return files;
	}

	public void setFiles(String[] files) {
		this.files = files;
	}

	public ArrayList<FreeFileVO> getFilList() {
		return filList;
	}

	public void setFilList(ArrayList<FreeFileVO> filList) {
		this.filList = filList;
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
		return "FreeVO [freeNo=" + freeNo + ", freeTitle=" + freeTitle + ", freeContent=" + freeContent + ", freeDate="
				+ freeDate + ", memberNo=" + memberNo + ", memberName=" + memberName + ", files="
				+ Arrays.toString(files) + ", filList=" + filList + ", commentNo=" + commentNo + "]";
	}
}