package com.mit.domain;

public class SuggestionCommentVO {
	private int commentNo;
	private String commentText;
	private String commentDate;
	private int suggestionNo;
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
	public int getSuggestionNo() {
		return suggestionNo;
	}
	public void setSuggestionNo(int suggestionNo) {
		this.suggestionNo = suggestionNo;
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
		return "SuggestionCommentVO [commentNo=" + commentNo + ", commentText=" + commentText + ", commentDate="
				+ commentDate + ", suggestionNo=" + suggestionNo + ", memberNo=" + memberNo + ", memberName="
				+ memberName + "]";
	}
}
