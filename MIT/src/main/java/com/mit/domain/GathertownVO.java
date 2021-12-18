package com.mit.domain;

public class GathertownVO {
	private int gathertownNo;
	private String groupName;
	private String groupContent;
	private String gathertownLink;
	private String thumbnail;
	private int groupNo;
	private int memberNo;
	private int rnum;
	
	public int getGathertownNo() {
		return gathertownNo;
	}
	public void setGathertownNo(int gathertownNo) {
		this.gathertownNo = gathertownNo;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getGroupContent() {
		return groupContent;
	}
	public void setGroupContent(String groupContent) {
		this.groupContent = groupContent;
	}
	public String getGathertownLink() {
		return gathertownLink;
	}
	public void setGathertownLink(String gathertownLink) {
		this.gathertownLink = gathertownLink;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public int getGroupNo() {
		return groupNo;
	}
	public void setGroupNo(int groupNo) {
		this.groupNo = groupNo;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum - 1;
	}
	
	@Override
	public String toString() {
		return "GathertownVO [gathertownNo=" + gathertownNo + ", groupName=" + groupName + ", groupContent="
				+ groupContent + ", gathertownLink=" + gathertownLink + ", thumbnail=" + thumbnail
				+ ", groupNo=" + groupNo + ", memberNo=" + memberNo + ", rnum=" + rnum + "]";
	}
}
