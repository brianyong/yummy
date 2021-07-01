package edu.kh.yummy.member.model.vo;

import java.sql.Date;

public class Member {
	
	private int memberNo;			// 회원 번호
	private String memberId;		// 회원 아이디
	private String memberPw;		// 회원 비밀번호
	private String memberName;		// 회원 이름
	private String memberPhone;		// 전화번포('-' 포함)
	private String memberEmail;		// 이메일
	private String memberStatus;	// 회원 상태(Y:정상, N:탈퇴)
	private String memberGrade;		// 회원 등급(G:일반, O:점주, A:관리자)
	
	
	//store 정보
	private int storeNo;
	private String storeName;
	private String storePhone;
	private String storeAddress;
	private String storeIMG;
	private String corNo;
	
	
	
	
	
	public Member() {}
	
	
	
	

	public Member(int memberNo, String memberId, String memberName, String memberPhone, String memberEmail,
			String memberGrade, int storeNo, String storeName, String storePhone, String storeAddress, String storeIMG,
			String corNo) {
		super();
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberPhone = memberPhone;
		this.memberEmail = memberEmail;
		this.memberGrade = memberGrade;
		this.storeNo = storeNo;
		this.storeName = storeName;
		this.storePhone = storePhone;
		this.storeAddress = storeAddress;
		this.storeIMG = storeIMG;
		this.corNo = corNo;
	}





	public Member(int memberNo, String memberId, String memberPw, String memberName, String memberPhone,
			String memberEmail, String memberStatus, String memberGrade, int storeNo, String storeName,
			String storePhone, String storeAddress, String storeIMG, String corNo) {
		super();
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberPhone = memberPhone;
		this.memberEmail = memberEmail;
		this.memberStatus = memberStatus;
		this.memberGrade = memberGrade;
		this.storeNo = storeNo;
		this.storeName = storeName;
		this.storePhone = storePhone;
		this.storeAddress = storeAddress;
		this.storeIMG = storeIMG;
		this.corNo = corNo;
	}





	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberStatus() {
		return memberStatus;
	}

	public void setMemberStatus(String memberStatus) {
		this.memberStatus = memberStatus;
	}

	public String getMemberGrade() {
		return memberGrade;
	}

	public void setMemberGrade(String memberGrade) {
		this.memberGrade = memberGrade;
	}
	
	

	public int getStoreNo() {
		return storeNo;
	}





	public void setStoreNo(int storeNo) {
		this.storeNo = storeNo;
	}





	public String getStoreName() {
		return storeName;
	}





	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}





	public String getStorePhone() {
		return storePhone;
	}





	public void setStorePhone(String storePhone) {
		this.storePhone = storePhone;
	}





	public String getStoreAddress() {
		return storeAddress;
	}





	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}





	public String getStoreIMG() {
		return storeIMG;
	}





	public void setStoreIMG(String storeIMG) {
		this.storeIMG = storeIMG;
	}





	public String getCorNo() {
		return corNo;
	}





	public void setCorNo(String corNo) {
		this.corNo = corNo;
	}





	@Override
	public String toString() {
		return "Member [memberNo=" + memberNo + ", memberId=" + memberId + ", memberPw=" + memberPw + ", memberName="
				+ memberName + ", memberPhone=" + memberPhone + ", memberEmail=" + memberEmail + ", memberStatus="
				+ memberStatus + ", memberGrade=" + memberGrade + ", storeNo=" + storeNo + ", storeName=" + storeName
				+ ", storePhone=" + storePhone + ", storeAddress=" + storeAddress + ", storeIMG=" + storeIMG
				+ ", corNo=" + corNo + "]";
	}





	


}
