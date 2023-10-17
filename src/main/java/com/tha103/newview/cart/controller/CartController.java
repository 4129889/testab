package com.tha103.newview.cart.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.tha103.newview.actpic.model.ActPic;
import com.tha103.newview.cart.service.CartService;
import com.tha103.newview.cart.service.impl.CartServiceImpl;

@WebServlet("/cart")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CartService service;

	@Override
	public void init() throws ServletException {
		service = new CartServiceImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ActPic actPic = service.getItem();
		resp.getWriter().write(new Gson().toJson(actPic));
		System.out.println(actPic);
	}
}


