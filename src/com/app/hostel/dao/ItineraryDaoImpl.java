package com.app.hostel.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.hostel.entity.Itinerary;
@Component
public class ItineraryDaoImpl extends BaseDao implements ItineraryDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void createItinerary(Itinerary itinerary) {
		
		Session session = getSession(sessionFactory);
		session.persist(itinerary);
		closeSession(session);



	}
	
	@Override
	public Itinerary getItinerary(Integer id) {

		Session session = getSession(sessionFactory);
		Itinerary itinerary = (Itinerary)session.createCriteria(Itinerary.class)
				.add(Restrictions.eq("id",id))
				.add(Restrictions.eq("deleted",false));

		closeSession(session);
		return itinerary;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Itinerary> getItinerarys() {

		Session session = getSession(sessionFactory);
		List<Itinerary> itinerarys = session.createCriteria(Itinerary.class)
				.add(Restrictions.eq("deleted",false))
				.list();
		closeSession(session);
		return itinerarys;
	}

	@Override
	public void updateItinerary(Itinerary itinerary) {

		Session session = getSession(sessionFactory);
		session.update(itinerary);
		closeSession(session);

	}

	@Override
	public void deleteItinerary(Integer id) {

		Session session = getSession(sessionFactory);

		Itinerary itinerary = (Itinerary) session.get(Itinerary.class,id);

		itinerary.setDeleted(true);
		session.update(itinerary);

		closeSession(session);
	}


	
}