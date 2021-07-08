package edu.kh.yummy.order.model.vo;

import java.sql.Date;
import java.sql.Timestamp;

public class Orders {

	private int orderNo;         // 주문번호
	   private Date orderDate;      // 주문일
	   private String orderRequest;      //주문시 요청사항
	   private Timestamp visitTime;      //  회원방문시간
	   private int memberNo;      // 멤버 번호
	   
	   private String storeAddress; //가게 주소
	   private String storeName; //가게명
	   private String menuName; //메뉴명
	   private int menuPrice; //메뉴 가격
	   
	  private String orderVisitTime;
	  
	  private String customerPhone;
	  
	  private String customerRequest;
	   
	   
	   public Orders() {}

	
	
	


	public Orders(int orderNo, Date orderDate, String orderRequest, Timestamp visitTime, int memberNo,
			String storeAddress, String storeName, String menuName, int menuPrice, String orderVisitTime,
			String customerPhone, String customerRequest) {
		super();
		this.orderNo = orderNo;
		this.orderDate = orderDate;
		this.orderRequest = orderRequest;
		this.visitTime = visitTime;
		this.memberNo = memberNo;
		this.storeAddress = storeAddress;
		this.storeName = storeName;
		this.menuName = menuName;
		this.menuPrice = menuPrice;
		this.orderVisitTime = orderVisitTime;
		this.customerPhone = customerPhone;
		this.customerRequest = customerRequest;
	}





	public String getOrderVisitTime() {
		return orderVisitTime;
	}





	public void setOrderVisitTime(String orderVisitTime) {
		this.orderVisitTime = orderVisitTime;
	}



	public String getCustomerPhone() {
		return customerPhone;
	}





	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}





	public String getCustomerRequest() {
		return customerRequest;
	}





	public void setCustomerRequest(String customerRequest) {
		this.customerRequest = customerRequest;
	}





	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderRequest() {
		return orderRequest;
	}

	public void setOrderRequest(String orderRequest) {
		this.orderRequest = orderRequest;
	}

	public Timestamp getVisitTime() {
		return visitTime;
	}

	public void setVisitTime(Timestamp visitTime) {
		this.visitTime = visitTime;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getStoreAddress() {
		return storeAddress;
	}

	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
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

	public int getMenuPrice() {
		return menuPrice;
	}

	public void setMenuPrice(int menuPrice) {
		this.menuPrice = menuPrice;
	}

	@Override
	public String toString() {
		return "Orders [orderNo=" + orderNo + ", orderDate=" + orderDate + ", orderRequest=" + orderRequest
				+ ", visitTime=" + visitTime + ", memberNo=" + memberNo + ", storeAddress=" + storeAddress
				+ ", storeName=" + storeName + ", menuName=" + menuName + ", menuPrice=" + menuPrice
				+ ", orderVisitTime=" + orderVisitTime + ", customerPhone=" + customerPhone + ", customerRequest="
				+ customerRequest + "]";
	}
	   
	   
}
