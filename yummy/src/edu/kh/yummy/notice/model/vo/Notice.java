package edu.kh.yummy.notice.model.vo;

import java.sql.Timestamp;

public class Notice {
	
	private int noticeNo;			// 글번호
	private String noticeTitle;		// 글제목
	private String noticeContent;	// 글내용
	private Timestamp createDate;	// 작성일
	private int memberNo;		// 작성자번호
	private String memberGrade;		// 작성자등급
	
	 
	public Notice() {}


	
	public String getMemberGrade() {
		return memberGrade;
	}



	public void setMemberGrade(String memberGrade) {
		this.memberGrade = memberGrade;
	}



	public int getNoticeNo() {
		return noticeNo;
	}


	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}


	public String getNoticeTitle() {
		return noticeTitle;
	}


	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}


	public String getNoticeContent() {
		return noticeContent;
	}


	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}


	public Timestamp getCreateDate() {
		return createDate;
	}


	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}



	public int getMemberNo() {
		return memberNo;
	}


	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}



	@Override
	public String toString() {
		return "Notice [noticeNo=" + noticeNo + ", noticeTitle=" + noticeTitle + ", noticeContent=" + noticeContent
				+ ", createDate=" + createDate + ", memberNo=" + memberNo + ", memberGrade=" + memberGrade + "]";
	}










	
}
