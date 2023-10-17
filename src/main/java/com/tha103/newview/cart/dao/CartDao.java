package com.tha103.newview.cart.dao;

import com.tha103.newview.act.model.Act;
import com.tha103.newview.actpic.model.ActPic;
import com.tha103.newview.cart.vo.Cart;

public interface CartDao {

	Cart getBySeatId(Integer seatId);
	//这个方法应该根据座位ID（seatId）返回一个Cart对象。这可能用于在购物车中查找与特定座位相关的商品或服务。
	
	ActPic selectByActId(Integer actId);
	//这个方法应该根据活动ID（actId）返回一个ActPic对象。这可能用于获取与某个活动相关的图片或其他媒体资源。
	
	Act  selectByActId2(Integer actId);
}
