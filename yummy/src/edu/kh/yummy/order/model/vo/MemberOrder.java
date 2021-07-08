package edu.kh.yummy.order.model.vo;

import java.util.List;

public class MemberOrder {
	private int memberNo;
	private int orderNo;
	private int menuNo;
	private String menuName;// 메뉴명
	private int menuPrice;// 메뉴 가격
	private int menuAmount;// 주문 수 격
	
	public MemberOrder () {}

	public MemberOrder(String menuName, int menuPrice, int menuAmount) {
		super();
		this.menuName = menuName;
		this.menuPrice = menuPrice;
		this.menuAmount = menuAmount;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public int getMenuPrice() {
		return menuPrice;
	}

	public void setMenuPrice(int menuPrice) {
		this.menuPrice = menuPrice;
	}

	public int getMenuAmount() {
		return menuAmount;
	}

	public void setMenuAmount(int menuAmount) {
		this.menuAmount = menuAmount;
	}

	
	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public int getMenuNo() {
		return menuNo;
	}

	public void setMenuNo(int menuNo) {
		this.menuNo = menuNo;
	}

	@Override
	public String toString() {
		return "MemberOrder [memberNo=" + memberNo + ", orderNo=" + orderNo + ", menuNo=" + menuNo + ", menuName="
				+ menuName + ", menuPrice=" + menuPrice + ", menuAmount=" + menuAmount + "]";
	}

	
	
	
}
