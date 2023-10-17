package com.tha103.newview.orderlist.model;

import java.util.List;
public class TestHibernateDAO {
	public static void main(String[] args) {
		OrderListDAO dao = new OrderListDAOImpl();

		// 新增
//		OrderListVO orderList1 = new OrderListVO();
//		orderList1.setUserID(1);
//		orderList1.setPostID(1);
//		orderList1.setOrderListContent("講話很糟糕");
//		orderList1.setOrderListStatus(0);
//		
//		dao.insert(orderList1);

		// 修改
//		OrderListVO orderList2 = new OrderListVO();
//		orderList2.setOrderListID(1);
//		orderList2.setUserID(1);
//		orderList2.setPostID(1);
//		orderList2.setOrderListContent("講話很糟糕");
//		orderList2.setOrderListStatus(0);
//		
//		dao.update(orderList2);

		// 刪除
//		dao.delete(2);

		// 查詢單筆
		OrderListVO orderList3 = dao.findeByPrimaryKey(1);
		System.out.println(orderList3);

		// 查詢多筆
		List<OrderListVO> list = dao.getAll();
		for (OrderListVO lists : list) {
			System.out.println(lists);
		}
	}
}
