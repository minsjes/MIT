package com.mit.domain;

import java.util.Date;

public class QnaCommentVO {

	private int commentNo;
	private int qnaNo;
	private int memberNo;
	private String memberName;
	private String commentText;
	private Date commentDate;
	
	public int getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}
	public int getQnaNo() {
		return qnaNo;
	}
	public void setQnaNo(int qnaNo) {
		this.qnaNo = qnaNo;
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
	public String getCommentText() {
		return commentText;
	}
	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}
	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	
	@Override
	public String toString() {
		return "QnaCommentVO [commentNo=" + commentNo + ", qnaNo=" + qnaNo + ", memberNo=" + memberNo + ", memberName="
				+ memberName + ", commentText=" + commentText + ", commentDate=" + commentDate + "]";
	}
}
	