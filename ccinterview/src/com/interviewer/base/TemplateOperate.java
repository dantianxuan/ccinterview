/**
 * 
 */
package com.interviewer.base;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * @author jinsaichen
 * 
 */
public class TemplateOperate {
	// 在Hibernate中，所有的操作都是通过Session完成
	// 此Session不同于JSP的Session
	private SessionFactory factory = null;

	// 在构造方法之中实例化session对象
	public TemplateOperate() {
		// 找到Hibernate配置
		Configuration config = new Configuration().configure();
		// 从配置中取出SessionFactory
		factory = config.buildSessionFactory();

	}

	// 所有的操作都是通过session进行的
	// 向数据库中增加数据
	public void insert(Object p) {
		// 开始事务
		// 从SessionFactory中取出一个Session
		Session session = factory.openSession();
		Transaction tran = session.beginTransaction();
		// 执行语句
		session.save(p);
		// 提交事务
		tran.commit();
		// 关闭Session
		session.close();
	}

	// 修改
	public void update(Object p) {
		// 开始事务
		Session session = factory.openSession();
		Transaction tran = session.beginTransaction();
		// 执行语句
		session.update(p);
		// 提交事务
		tran.commit();
	}

	// 按ID查询：推荐使用HQL —— 是Hibernate官方推荐的查询语言
	public Object queryById(String id, String sql) {
		Object p = null;
		// 使用Hibernate查询语言
		Session session = factory.openSession();
		String hql = sql;
		// 通过Query接口查询
		Query q = session.createQuery(hql);
		q.setString(0, id);
		List l = q.list();
		Iterator iter = l.iterator();
		if (iter.hasNext()) {
			p = iter.next();
		}
		return p;
	}

	// 删除数据
	// Hibernate2、Hibernate 3通用的删除
	// 使用此方法删除数据之前，必须先查找到数据对象，性能呢？
	public void delete(Object p) {
		Session session = factory.openSession();
		Transaction tran = session.beginTransaction();
		// 执行语句
		session.delete(p);
		// 提交事务
		tran.commit();
	}

	// 在Hibernate 3之中根据HQL中的语句进行了修改，增加了删除指令
	public void delete(String id, String sql) {
		String hql = sql;
		Session session = factory.openSession();
		Query q = session.createQuery(hql);
		// 把参数设置
		q.setString(0, id);
		// 执行更新语句
		q.executeUpdate();
		// 进行事务处理
		session.beginTransaction().commit();
	}

	// 查询全部数据，写HQL
	public List queryAll(String sql) {
		List l = null;
		Session session = factory.openSession();
		String hql = sql;
		Query q = session.createQuery(hql);
		l = q.list();
		return l;
	}

	// 模糊查询
	public List queryByLike(String cond, String sql) {
		Session session = factory.openSession();
		List l = null;
		String hql = sql;
		Query q = session.createQuery(hql);
		q.setString(0, "%" + cond + "%");
		l = q.list();
		return l;
	}

	// 分页查询
	public List queryByPage(int start, int pageNo, String sql) {
		Session session = factory.openSession();
		Query query = session.createQuery(sql);
		query.setFirstResult(start);// 就是说你的从第几条开始
		query.setMaxResults(pageNo);// 页面默认显示的条数
		return query.list();
	}
}
