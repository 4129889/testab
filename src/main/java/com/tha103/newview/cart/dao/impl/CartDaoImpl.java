package com.tha103.newview.cart.dao.impl;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import com.google.gson.Gson;
import com.tha103.newview.act.model.Act;
import com.tha103.newview.actpic.model.ActPic;
import com.tha103.newview.cart.dao.CartDao;
import com.tha103.newview.cart.vo.Cart;
import com.tha103.util.HibernateUtil;


import redis.clients.jedis.Jedis;

public class CartDaoImpl implements CartDao {
	private static final Gson GSON = new Gson();
	String hql = "FROM ActPic ap JOIN FETCH ap.act WHERE ap.id = :actId";
	//这一行定义了一个私有的、静态的、最终的Gson对象，用于JSON的序列化和反序列化。
	//因为它是静态的，这个对象在类的所有实例之间是共享的。
	
	@Override
	public Cart getBySeatId(Integer seatId) {
//这个方法使用Jedis库从本地运行的Redis服务器（端口6379）中获取与给定seatId关联的数据。
//数据以JSON字符串的形式存储，然后使用Gson库将其解析为Cart类的对象。
		try (Jedis jedis = new Jedis("localhost", 6379)) {
			String jsonStr = jedis.get(String.valueOf(seatId));
			//这一行从Redis中获取与seatId相关联的值，并存储为一个字符串jsonStr。
			return GSON.fromJson(jsonStr, Cart.class);
			//这一行使用Gson库将jsonStr字符串反序列化为一个Cart对象，并返回它。
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ActPic selectByActId(Integer actId) {
		//这个方法使用Hibernate从数据库中获取与给定actId关联的ActPic对象。
		//它开始一个新的事务，尝试获取数据，然后提交事务。
		//如果获取数据成功，它会返回这个ActPic对象。
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		//这一行获取当前的Hibernate Session。
		try {
			session.beginTransaction();
			//这一行开始一个新的数据库事务。
			ActPic actPic = session.get(ActPic.class, actId);
//			Hibernate.initialize(actPic.getAct());
			//这一行从数据库中获取一个与actId相关联的ActPic对象。
			Hibernate.initialize(actPic);
			//这一行初始化actPic对象，以确保所有的懒加载属性都已被获取。
			session.getTransaction().commit();
			//这一行提交之前开始的数据库事务。
//这里的异常处理代码与getBySeatId方法中的非常类似，
//但增加了一个事务回滚session.getTransaction().rollback();。
			return actPic;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return null;
		}
	}
	
	@Override
	public Act selectByActId2(Integer actId) {
		//这个方法使用Hibernate从数据库中获取与给定actId关联的ActPic对象。
		//它开始一个新的事务，尝试获取数据，然后提交事务。
		//如果获取数据成功，它会返回这个ActPic对象。
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		//这一行获取当前的Hibernate Session。
		try {
			session.beginTransaction();
			//这一行开始一个新的数据库事务。
			Act act = session.get(Act.class, actId);
			//这一行从数据库中获取一个与actId相关联的ActPic对象。
			Hibernate.initialize(act);
			//这一行初始化actPic对象，以确保所有的懒加载属性都已被获取。
			session.getTransaction().commit();
			//这一行提交之前开始的数据库事务。
//这里的异常处理代码与getBySeatId方法中的非常类似，
//但增加了一个事务回滚session.getTransaction().rollback();。
			return act;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return null;
		}
	}
	
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			
			session.beginTransaction();
			
			List<Act> list = session.createQuery("select distinct d from Act d left join fetch d.actPics", Act.class).list();
			for (Act act : list) {
				System.out.println(act + " =============");
			
			
			}
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			HibernateUtil.shutdown();
		}
	}
}
