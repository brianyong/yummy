package edu.kh.yummy.order.model.vo;

import java.sql.Date;
import java.sql.Timestamp;

public class Orders {

	private int orderNo;         // 주문번호
	   private Date orderDate;      // 주문일
	   private String orderRequest;      //주문시 요청사항
	   private Timestamp visitTime;      //  회원방문시간
	   private int memberNo;      // 멤버 번호
	   
	   public Orders() {}

	public Orders(int orderNo, Date orderDate, String orderRquest, Timestamp visitTime, int memberNo) {
		super();
		this.orderNo = orderNo;
		this.orderDate = orderDate;
		this.orderRequest = orderRquest;
		this.visitTime = visitTime;
		this.memberNo = memberNo;
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

	@Override
	public String toString() {
		return "Orders [orderNo=" + orderNo + ", orderDate=" + orderDate + ", orderRequest=" + orderRequest
				+ ", visitTime=" + visitTime + ", memberNo=" + memberNo + "]";
	}
	   
	   
}
