package edu.kh.yummy.store.model.vo;

public class StoreGood {

	private int memberNo;		// 회원 번호 
	private int storeNo;		// 매장 번호 
	
	public StoreGood() {}

	public int getMemberNo() {
		return memberNo;
	}


	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}


	public int getStoreNo() {
		return storeNo;
	}


	public void setStoreNo(int storeNo) {
		this.storeNo = storeNo;
	}


	@Override
	public String toString() {
		return "StoreGood [memberNo=" + memberNo + ", storeNo=" + storeNo + "]";
	}
	
	
	
	
	
}
