package com.mit.domain;

import java.util.ArrayList;
import java.util.Arrays;

public class StudyVO {
	private int studyNo;
	private String studyClass;
	private String studyTitle;
	private String studyContent;
	private String studyDate;
	private int studyView;
	
	private int memberNo;
	private String memberName;
	
	private int rnum;
	
	private String[] files;
	private ArrayList<StudyFileVO> fileList;
	
	private int commentNo;
	
	public int getStudyNo() {
		return studyNo;
	}
	public void setStudyNo(int studyNo) {
		this.studyNo = studyNo;
	}
	public String getStudyClass() {
		return studyClass;
	}
	public void setStudyClass(String studyClass) {
		this.studyClass = studyClass;
	}
	public String getStudyTitle() {
		return studyTitle;
	}
	public void setStudyTitle(String studyTitle) {
		this.studyTitle = studyTitle;
	}
	public String getStudyContent() {
		return studyContent;
	}
	public void setStudyContent(String studyContent) {
		this.studyContent = studyContent;
	}
	public String getStudyDate() {
		return studyDate;
	}
	public void setStudyDate(String studyDate) {
		this.studyDate = studyDate;
	}
	public int getStudyView() {
		return studyView;
	}
	public void setStudyView(int studyView) {
		this.studyView = studyView;
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
	public ArrayList<StudyFileVO> getFileList() {
		return fileList;
	}
	public void setFileList(ArrayList<StudyFileVO> fileList) {
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
		return "StudyVO [studyNo=" + studyNo + ", studyClass=" + studyClass + ", studyTitle=" + studyTitle
				+ ", studyContent=" + studyContent + ", studyDate=" + studyDate + ", studyView=" + studyView
				+ ", memberNo=" + memberNo + ", memberName=" + memberName + ", rnum=" + rnum + ", files="
				+ Arrays.toString(files) + ", fileList=" + fileList + ", commentNo=" + commentNo + "]";
	}
}
