package com.mit.domain;

import java.util.ArrayList;
import java.util.Arrays;

public class FreeVO {
	private int freeNo;
	private String freeTitle;
	private String freeContent;
	private String freeDate;
	private int freeView;
	private String hiddenStatus;
	
	private int memberNo;
	private String memberName;
	
	private int rnum;
	
	private String[] files;
	private ArrayList<FreeFileVO> filList;
	
	private int commentNo;

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

	public String getFreeDate() {
		return freeDate;
	}

	public void setFreeDate(String freeDate) {
		this.freeDate = freeDate;
	}

	public int getFreeView() {
		return freeView;
	}

	public void setFreeView(int freeView) {
		this.freeView = freeView;
	}

	public String getHiddenStatus() {
		return hiddenStatus;
	}

	public void setHiddenStatus(String hiddenStatus) {
		this.hiddenStatus = hiddenStatus;
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

	public int getRnum() {
		return rnum;
	}

	public void setRnum(int rnum) {
		this.rnum = rnum;
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

	@Override
	public String toString() {
		return "FreeVO [freeNo=" + freeNo + ", freeTitle=" + freeTitle + ", freeContent=" + freeContent + ", freeDate="
				+ freeDate + ", freeView=" + freeView + ", hiddenStatus=" + hiddenStatus + ", memberNo=" + memberNo
				+ ", memberName=" + memberName + ", rnum=" + rnum + ", files=" + Arrays.toString(files) + ", filList="
				+ filList + ", commentNo=" + commentNo + "]";
	}
}