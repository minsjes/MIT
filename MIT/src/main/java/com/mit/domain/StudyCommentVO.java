package com.mit.domain;

public class StudyCommentVO {
	private int commentNo;
	private String commentText;
	private String commentDate;
	private int studyNo;
	private int memberNo;
	private String memberName;
	
	public int getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}
	public String getCommentText() {
		return commentText;
	}
	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}
	public String getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}
	public int getStudyNo() {
		return studyNo;
	}
	public void setStudyNo(int studyNo) {
		this.studyNo = studyNo;
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
	
	@Override
	public String toString() {
		return "StudyCommentVO [commentNo=" + commentNo + ", commentText=" + commentText + ", commentDate="
				+ commentDate + ", studyNo=" + studyNo + ", memberNo=" + memberNo + ", memberName=" + memberName + "]";
	}
}
