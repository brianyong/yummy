package edu.kh.yummy.menu.model.vo;

public class Menu {
	private int menuNo;			// 메뉴번호
	private String menuName;	// 메뉴이름
	private String menuImg;		// 메뉴이미지
	private int menuPrice;		// 메뉴가격
	private int menuSalePercent;// 메뉴할인율
	private int storeNo;		// 가게번호
	private int memberNo;		// 회원번호
	private String menuStatus;	// 메뉴상태

	public Menu() {}
	
	
	public Menu(int menuNo, String menuName, String menuImg, int menuPrice, int menuSalePercent) {
		super();
		this.menuNo = menuNo;
		this.menuName = menuName;
		this.menuImg = menuImg;
		this.menuPrice = menuPrice;
		this.menuSalePercent = menuSalePercent;
	}




	public String getMenuStatus() {
		return menuStatus;
	}

	public void setMenuStatus(String menuStatus) {
		this.menuStatus = menuStatus;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public int getMenuNo() {
		return menuNo;
	}

	public void setMenuNo(int menuNo) {
		this.menuNo = menuNo;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuImg() {
		return menuImg;
	}

	public void setMenuImg(String menuImg) {
		this.menuImg = menuImg;
	}

	public int getMenuPrice() {
		return menuPrice;
	}

	public void setMenuPrice(int menuPrice) {
		this.menuPrice = menuPrice;
	}

	public int getMenuSalePercent() {
		return menuSalePercent;
	}

	public void setMenuSalePercent(int menuSalePercent) {
		this.menuSalePercent = menuSalePercent;
	}

	public int getStoreNo() {
		return storeNo;
	}

	public void setStoreNo(int storeNo) {
		this.storeNo = storeNo;
	}


	@Override
	public String toString() {
		return "Menu [menuNo=" + menuNo + ", menuName=" + menuName + ", menuImg=" + menuImg + ", menuPrice=" + menuPrice
				+ ", menuSalePercent=" + menuSalePercent + ", storeNo=" + storeNo + ", memberNo=" + memberNo
				+ ", menuStatus=" + menuStatus + "]";
	}

}
