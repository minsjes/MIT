package com.mit.domain;

public class FreeFileVO {
	
	   private int fileNo;
	   private String fileName;
	   private int freeNo;
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
	   public int getFreeNo() {
	      return freeNo;
	   }
	   public void setFreeNo(int freeNo) {
	      this.freeNo = freeNo;
	   }
	   public String getFileLocation() {
	      return fileLocation;
	   }
	   public void setFileLocation(String fileLocation) {
	      this.fileLocation = fileLocation;
	   }
	   @Override
	   public String toString() {
	      return "FreeFileVO [fileNo=" + fileNo + ", fileName=" + fileName + ", freeNo=" + freeNo + ", fileLocation="
	            + fileLocation + "]";
	   }
	   
	   
	   

	}