package edu.kh.yummy.cart.model.vo;

import java.util.List;

public class Cart {

	private int storeNo;
	private int menuNo;
	private String storeName;
	private String menuName;
	private int menuSaleCost;
	private int menuAmount;
	private int totalCost;
	private String storeAddr;
	
	
	
	public Cart() {}



	public int getStoreNo() {
		return storeNo;
	}



	public void setStoreNo(int storeNo) {
		this.storeNo = storeNo;
	}



	public int getMenuNo() {
		return menuNo;
	}



	public void setMenuNo(int menuNo) {
		this.menuNo = menuNo;
	}



	public String getStoreName() {
		return storeName;
	}



	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}



	public String getMenuName() {
		return menuName;
	}



	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}



	public int getMenuSaleCost() {
		return menuSaleCost;
	}



	public void setMenuSaleCost(int menuSaleCost) {
		this.menuSaleCost = menuSaleCost;
	}



	public int getMenuAmount() {
		return menuAmount;
	}



	public void setMenuAmount(int menuAmount) {
		this.menuAmount = menuAmount;
	}



	public int getTotalCost() {
		return totalCost;
	}



	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}



	public String getStoreAddr() {
		return storeAddr;
	}



	public void setStoreAddr(String storeAddr) {
		this.storeAddr = storeAddr;
	}



	@Override
	public String toString() {
		return "Cart [storeNo=" + storeNo + ", menuNo=" + menuNo + ", storeName=" + storeName + ", menuName=" + menuName
				+ ", menuSaleCost=" + menuSaleCost + ", menuAmount=" + menuAmount + ", totalCost=" + totalCost
				+ ", storeAddr=" + storeAddr + "]";
	}


	
	
	
	
	
	
}
