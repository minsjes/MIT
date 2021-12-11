package com.mit.domain;

public class StudyFileVO {
	private int fileNo;
	private String fileName;
	private int studyNo;
	private String fileLocation;
	
	public int getFileNo() {
		return fileNo;
	}
	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int getStudyNo() {
		return studyNo;
	}
	public void setStudyNo(int studyNo) {
		this.studyNo = studyNo;
	}
	public String getFileLocation() {
		return fileLocation;
	}
	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}
	
	@Override
	public String toString() {
		return "StudyFileVO [fileNo=" + fileNo + ", fileName=" + fileName + ", studyNo=" + studyNo + ", fileLocation="
				+ fileLocation + "]";
	}
}
