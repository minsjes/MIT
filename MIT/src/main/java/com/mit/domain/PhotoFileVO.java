package com.mit.domain;

public class PhotoFileVO {

	private int fileNo;
	private String fileName;
	private int photoNo;
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
	public int getPhotoNo() {
		return photoNo;
	}
	public void setPhotoNo(int photoNo) {
		this.photoNo = photoNo;
	}
	public String getFileLocation() {
		return fileLocation;
	}
	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}
	@Override
	public String toString() {
		return "PhotoFileVO [fileNo=" + fileNo + ", fileName=" + fileName + ", photoNo=" + photoNo + ", fileLocation="
				+ fileLocation + "]";
	}
	
	
}
