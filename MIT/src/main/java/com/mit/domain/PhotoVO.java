package com.mit.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class PhotoVO {

	private int photoNo;
	private String photoTitle;
	private String photoContent;
	private Date photoDate;
	private int memberNo;
	private String[] files;
	private ArrayList<PhotoFileVO> filList;
	private String memberName;
	private int commentNo;
	private int rnum;
	
	private String photoImage;
	
	public int getPhotoNo() {
		return photoNo;
	}
	public void setPhotoNo(int photoNo) {
		this.photoNo = photoNo;
	}
	public String getPhotoTitle() {
		return photoTitle;
	}
	public void setPhotoTitle(String photoTitle) {
		this.photoTitle = photoTitle;
	}
	public String getPhotoContent() {
		return photoContent;
	}
	public void setPhotoContent(String photoContent) {
		this.photoContent = photoContent;
	}
	public Date getPhotoDate() {
		return photoDate;
	}
	public void setPhotoDate(Date photoDate) {
		this.photoDate = photoDate;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String[] getFiles() {
		return files;
	}
	public void setFiles(String[] files) {
		this.files = files;
	}
	public ArrayList<PhotoFileVO> getFilList() {
		return filList;
	}
	public void setFilList(ArrayList<PhotoFileVO> filList) {
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
	public String getPhotoImage() {
		return photoImage;
	}
	public void setPhotoImage(String photoImage) {
		this.photoImage = photoImage;
	}
	@Override
	public String toString() {
		return "PhotoVO [photoNo=" + photoNo + ", photoTitle=" + photoTitle + ", photoContent=" + photoContent
				+ ", photoDate=" + photoDate + ", memberNo=" + memberNo + ", files=" + Arrays.toString(files)
				+ ", filList=" + filList + ", memberName=" + memberName + ", commentNo=" + commentNo + ", rnum=" + rnum
				+ "]";
	}
	
	
	
	
	
	
	
}
