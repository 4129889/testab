package com.tha103.newview.cart.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.tha103.newview.act.model.Act;
import com.tha103.newview.cart.service.CartService;
import com.tha103.newview.cart.service.impl.CartServiceImpl;

@WebServlet("/cart2")
public class CartController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CartService service;

	@Override
	public void init() throws ServletException {
		service = new CartServiceImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Act act = service.getItem2();
		resp.getWriter().write(new Gson().toJson(act));
		System.out.println(act);
	}
}
