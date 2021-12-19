package com.mit.domain;

public class SuggestionFileVO {
	private int fileNo;
	private String fileName;
	private int suggestionNo;
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
	public int getSuggestionNo() {
		return suggestionNo;
	}
	public void setSuggestionNo(int suggestionNo) {
		this.suggestionNo = suggestionNo;
	}
	public String getFileLocation() {
		return fileLocation;
	}
	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}
	
	@Override
	public String toString() {
		return "SuggestionFileVO [fileNo=" + fileNo + ", fileName=" + fileName + ", suggestionNo=" + suggestionNo
				+ ", fileLocation=" + fileLocation + "]";
	}
}
