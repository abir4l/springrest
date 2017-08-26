package com.app.hostel.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.app.hostel.entity.User;

@Component
public class UserDaoImpl extends BaseDao implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void createUser(User user) {

		Session session = getSession(sessionFactory);
		session.persist(user);
		closeSession(session);
		
		
	}

	@Override
	public User getUser(Integer id) {

		Session session = getSession(sessionFactory);
		User user = (User) session.get(User.class, id);
		closeSession(session);
		return user;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUsers() {

		Session session = getSession(sessionFactory);
		List<User> users = session.createCriteria(User.class).list();
		closeSession(session);
		return users;
	}

	@Override
	public void updateUser(User user) {

		Session session = getSession(sessionFactory);
		session.update(user);
		closeSession(session);
		
	}

	@Override
	public void deleteUser(Integer id) {

		Session session = getSession(sessionFactory);

		// Setting up the user to delete
		User user = new User();
		user.setId(id);

		session.delete(user);
		closeSession(session);
		
	}

}
