//package com.tha103.newview.cartact.model;
//
//import java.util.List;
//
//
//public class TestHibernateDAO {
//	public static void main(String[] args) {
//		CartActDAO dao = new CartActDAOImpl();
//
//		// 新增
//		CartActVO cartAct1 = new CartActVO();
//		cartAct1.setUserID(1);
//		cartAct1.setPostID(1);
//		cartAct1.setCartActContent("講話很糟糕");
//		cartAct1.setCartActStatus(0);
//		
//		dao.insert(cartAct1);
//
//		// 修改
////		CartActVO cartAct2 = new CartActVO();
////		cartAct2.setCartActID(1);
////		cartAct2.setUserID(1);
////		cartAct2.setPostID(1);
////		cartAct2.setCartActContent("講話很糟糕");
////		cartAct2.setCartActStatus(0);
////		
////		dao.update(cartAct2);
//
//		// 刪除
////		dao.delete(2);
//
////		// 查詢單筆
////		CartActVO cartAct3 = dao.findeByPrimaryKey(1);
////		System.out.println(cartAct3);
////
////		// 查詢多筆
////		List<CartActVO> list = dao.getAll();
////		for (CartActVO lists : list) {
////			System.out.println(lists);
//		}
//	}
//}
