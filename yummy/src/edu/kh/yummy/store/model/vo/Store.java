package edu.kh.yummy.store.model.vo;


public class Store {
	private int storeNo; // 매장 번호
	private String storeName; // 상호명
	private String storePhone; // 매장 전화번호
	private String storeAddr; // 매장 주소
	private String storeImg; // 매장 대표 이미지
	private String storeOpen; // 매장 오픈시간
	private String storeClose; // 매장 클로즈시간
	private String storeStory; // 매장 설명
	private String storeStatus; // 매장 승인상태 (정상 : Y, 승인 전 : N)
	private String corNo; // 사업자 등록번호
	private String corNoImg; // 사업자 등록증 첨부사진
	private int categoryNo; // 카테고리 번호
	private int memberNo; // 회원 번호

	public Store() {
	}

	public Store(int storeNo, String storeName, String storePhone, String storeAddr, String storeImg, String corNo,
			int memberNo) {
		super();
		this.storeNo = storeNo;
		this.storeName = storeName;
		this.storePhone = storePhone;
		this.storeAddr = storeAddr;
		this.storeImg = storeImg;
		this.corNo = corNo;
		this.memberNo = memberNo;
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

	public String getStoreAddr() {
		return storeAddr;
	}

	public void setStoreAddr(String storeAddr) {
		this.storeAddr = storeAddr;
	}

	public String getStoreImg() {
		return storeImg;
	}

	public void setStoreImg(String storeImg) {
		this.storeImg = storeImg;
	}

	public String getStoreOpen() {
		return storeOpen;
	}

	public void setStoreOpen(String storeOpen) {
		this.storeOpen = storeOpen;
	}

	public String getStoreClose() {
		return storeClose;
	}

	public void setStoreClose(String storeClose) {
		this.storeClose = storeClose;
	}

	public String getStoreStory() {
		return storeStory;
	}

	public void setStoreStory(String storeStory) {
		this.storeStory = storeStory;
	}

	public String getStoreStatus() {
		return storeStatus;
	}

	public void setStoreStatus(String storeStatus) {
		this.storeStatus = storeStatus;
	}

	public String getCorNo() {
		return corNo;
	}

	public void setCorNo(String corNo) {
		this.corNo = corNo;
	}

	public String getCorNoImg() {
		return corNoImg;
	}

	public void setCorNoImg(String corNoImg) {
		this.corNoImg = corNoImg;
	}

	public int getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	@Override
	public String toString() {
		return "Store [storeNo=" + storeNo + ", storeName=" + storeName + ", storePhone=" + storePhone + ", storeAddr="
				+ storeAddr + ", storeImg=" + storeImg + ", storeOpen=" + storeOpen + ", storeClose=" + storeClose
				+ ", storeStory=" + storeStory + ", storeStatus=" + storeStatus + ", corNo=" + corNo + ", corNoImg="
				+ corNoImg + ", categoryNo=" + categoryNo + ", memberNo=" + memberNo + "]";
	}
	
	

	

}
