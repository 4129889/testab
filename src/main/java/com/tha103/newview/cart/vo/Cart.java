package com.tha103.newview.cart.vo;

import java.io.Serializable;

public class Cart implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer seatId;
	private Integer actId;
	private Integer userId;
	
	public Cart() {
	}

	public Cart(Integer seatId, Integer actId, Integer userId) {
		this.seatId = seatId;
		this.actId = actId;
		this.userId = userId;
	}

	public Integer getSeatId() {
		return seatId;
	}

	public void setSeatId(Integer seatId) {
		this.seatId = seatId;
	}

	public Integer getActId() {
		return actId;
	}

	public void setActId(Integer actId) {
		this.actId = actId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}
