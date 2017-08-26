package com.app.hostel.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class BaseDao {

	Transaction tx;
	
	
	public Session getSession(SessionFactory sessionFactory){
		
		Session session = sessionFactory.openSession();
		tx  = session.beginTransaction();
		
		return session;
	}
	
	public void  closeSession(Session session){
		
		tx.commit();
		session.close();
		
	}

}
