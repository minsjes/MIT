package com.mit.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class QnaVO {
	
	private int qnaNo;
	private String qnaClass;
	private String qnaTitle;
	private String qnaContent;
	private Date qnaDate;
	private int qnaView;
	private String hiddenStatus;
	
	private int memberNo;
	private String memberName;
	
	private int rnum;
	
	private String[] files;
	private ArrayList<QnaFileVO> filList;
	
	private int commentNo;

	public int getQnaNo() {
		return qnaNo;
	}

	public void setQnaNo(int qnaNo) {
		this.qnaNo = qnaNo;
	}

	public String getQnaClass() {
		return qnaClass;
	}

	public void setQnaClass(String qnaClass) {
		this.qnaClass = qnaClass;
	}

	public String getQnaTitle() {
		return qnaTitle;
	}

	public void setQnaTitle(String qnaTitle) {
		this.qnaTitle = qnaTitle;
	}

	public String getQnaContent() {
		return qnaContent;
	}

	public void setQnaContent(String qnaContent) {
		this.qnaContent = qnaContent;
	}

	public Date getQnaDate() {
		return qnaDate;
	}

	public void setQnaDate(Date qnaDate) {
		this.qnaDate = qnaDate;
	}

	public int getQnaView() {
		return qnaView;
	}

	public void setQnaView(int qnaView) {
		this.qnaView = qnaView;
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

	public ArrayList<QnaFileVO> getFilList() {
		return filList;
	}

	public void setFilList(ArrayList<QnaFileVO> filList) {
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
		return "QnaVO [qnaNo=" + qnaNo + ", qnaClass=" + qnaClass + ", qnaTitle=" + qnaTitle + ", qnaContent="
				+ qnaContent + ", qnaDate=" + qnaDate + ", qnaView=" + qnaView + ", hiddenStatus=" + hiddenStatus
				+ ", memberNo=" + memberNo + ", memberName=" + memberName + ", rnum=" + rnum + ", files="
				+ Arrays.toString(files) + ", filList=" + filList + ", commentNo=" + commentNo + "]";
	}
}