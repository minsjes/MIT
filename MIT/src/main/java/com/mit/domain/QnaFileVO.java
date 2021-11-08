package com.mit.domain;

public class QnaFileVO {

	   private int fileNo;
	   private String fileName;
	   private int qnaNo;
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
	public int getQnaNo() {
		return qnaNo;
	}
	public void setQnaNo(int qnaNo) {
		this.qnaNo = qnaNo;
	}
	public String getFileLocation() {
		return fileLocation;
	}
	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}
	
	@Override
	public String toString() {
		return "QnaFileVO [fileNo=" + fileNo + ", fileName=" + fileName + ", qnaNo=" + qnaNo + ", fileLocation="
				+ fileLocation + "]";
	}
	   
	   
	
	
	
	
	
}
