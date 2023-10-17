package com.tha103.newview.compic.model;

import java.util.List;

public class TestHibernateDAO {
	public static void main(String[] args) {
		ComPicDAO dao = new ComPicDAOImpl();

		// 新增
//		ComPicVO comPic1 = new ComPicVO();
//		comPic1.setUserID(1);
//		comPic1.setPostID(1);
//		comPic1.setComPicContent("講話很糟糕");
//		comPic1.setComPicStatus(0);
//		
//		dao.insert(comPic1);

		// 修改
//		ComPicVO comPic2 = new ComPicVO();
//		comPic2.setComPicID(1);
//		comPic2.setUserID(1);
//		comPic2.setPostID(1);
//		comPic2.setComPicContent("講話很糟糕");
//		comPic2.setComPicStatus(0);
//		
//		dao.update(comPic2);

		// 刪除
//		dao.delete(2);

		// 查詢單筆
		ComPicVO comPic3 = dao.findeByPrimaryKey(1);
		System.out.println(comPic3);

		// 查詢多筆
		List<ComPicVO> list = dao.getAll();
		for (ComPicVO lists : list) {
			System.out.println(lists);
		}
	}
}
