package com.mit.domain;

public class InfoFileVO {

	private int fileNo;
	private String fileName;
	private int infoNo;
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
	public int getInfoNo() {
		return infoNo;
	}
	public void setInfoNo(int infoNo) {
		this.infoNo = infoNo;
	}
	public String getFileLocation() {
		return fileLocation;
	}
	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}
	@Override
	public String toString() {
		return "InfoFileVO [fileNo=" + fileNo + ", fileName=" + fileName + ", infoNo=" + infoNo + ", fileLocation="
				+ fileLocation + "]";
	}

	


}
