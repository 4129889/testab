package com.tha103.newview.cart.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.tha103.newview.act.model.Act;
import com.tha103.newview.actpic.model.ActPic;
import com.tha103.newview.cart.dao.CartDao;
import com.tha103.newview.cart.dao.impl.CartDaoImpl;
import com.tha103.newview.cart.service.CartService;

public class CartServiceImpl implements CartService {
	@Autowired
	private CartDao dao;
	
	public CartServiceImpl() {
		dao = new CartDaoImpl();
	}
	
	@Override
	public ActPic getItem() {
		return dao.selectByActId(2);
	}
	
	public Act getItem2() {
		return dao.selectByActId2(2);
	}
}
