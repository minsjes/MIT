package com.mit.domain;

import java.util.ArrayList;
import java.util.Arrays;

public class SuggestionVO {
	private int suggestionNo;
	private String suggestionTitle;
	private String suggestionContent;
	private String suggestionDate;
	private String hiddenStatus;
	
	private int memberNo;
	private String memberName;
	
	private int rnum;
	
	private String[] files;
	private ArrayList<SuggestionFileVO> fileList;
	
	private int commentNo;

	public int getSuggestionNo() {
		return suggestionNo;
	}

	public void setSuggestionNo(int suggestionNo) {
		this.suggestionNo = suggestionNo;
	}

	public String getSuggestionTitle() {
		return suggestionTitle;
	}

	public void setSuggestionTitle(String suggestionTitle) {
		this.suggestionTitle = suggestionTitle;
	}

	public String getSuggestionContent() {
		return suggestionContent;
	}

	public void setSuggestionContent(String suggestionContent) {
		this.suggestionContent = suggestionContent;
	}

	public String getSuggestionDate() {
		return suggestionDate;
	}

	public void setSuggestionDate(String suggestionDate) {
		this.suggestionDate = suggestionDate;
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

	public ArrayList<SuggestionFileVO> getFileList() {
		return fileList;
	}

	public void setFileList(ArrayList<SuggestionFileVO> fileList) {
		this.fileList = fileList;
	}

	public int getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}

	@Override
	public String toString() {
		return "SuggestionVO [suggestionNo=" + suggestionNo + ", suggestionTitle=" + suggestionTitle
				+ ", suggestionContent=" + suggestionContent + ", suggestionDate=" + suggestionDate + ", hiddenStatus="
				+ hiddenStatus + ", memberNo=" + memberNo + ", memberName=" + memberName + ", rnum=" + rnum + ", files="
				+ Arrays.toString(files) + ", commentNo=" + commentNo + "]";
	}
}
