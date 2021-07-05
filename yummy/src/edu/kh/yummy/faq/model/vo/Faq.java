package edu.kh.yummy.faq.model.vo;

import java.sql.Timestamp;

public class Faq {
	
	private int faqNo;
	private String faqTitle;
	private String faqContent;
	private String memberName;
	private int memberNo;
	private Timestamp createDate;
	
	public Faq() {}
	
	
	
	public Faq(String faqTitle, String faqContent, int memberNo) {
		super();
		this.faqTitle = faqTitle;
		this.faqContent = faqContent;
		this.memberNo = memberNo;
	}



	public int getFaqNo() {
		return faqNo;
	}
	public void setFaqNo(int faqNo) {
		this.faqNo = faqNo;
	}
	public String getFaqTitle() {
		return faqTitle;
	}
	public void setFaqTitle(String faqTitle) {
		this.faqTitle = faqTitle;
	}
	public String getFaqContent() {
		return faqContent;
	}
	public void setFaqContent(String faqContent) {
		this.faqContent = faqContent;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
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
		return "Faq [faqNo=" + faqNo + ", faqTitle=" + faqTitle + ", faqContent=" + faqContent + ", memberName="
				+ memberName + ", memberNo=" + memberNo + ", createDate=" + createDate + "]";
	}
	
	
	
	

}
