package com.db;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.dto.Customer;
import com.dto.Movie;
import com.dto.Theatre;
import com.dto.Ticket;

public class HibernateTemplate {
	
private static SessionFactory sessionFactory;
	
	static{
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}
	
	public static int addObject(Object obj){		
		//System.out.println("Inside Template(add object)");
		
		int result=0;
		Transaction tx = null;
		
		try{			
			Session session=sessionFactory.openSession();
			tx=session.beginTransaction();
			System.out.println(obj);
			
			session.save(obj);
			          
			tx.commit();			
			result=1;
			
		}catch (Exception e){		
			if (tx != null) {
			    tx.rollback();
			}			
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static Object getObject(Class c,Serializable serializable)
	{
		Object obj=null;
		
		try {			
			return sessionFactory.openSession().get(c,serializable);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return obj;
	}
	
    public static List<Object> getObjectListByQuery(String query){
		
		return sessionFactory.openSession().createQuery(query).list();
	}
	
  
	public static Object getObjectByName(String custName, String custPassword) {
		
		String queryString = "from Customer where custName = :custName and custPassword =:custPassword";
		  Query query = sessionFactory.openSession().createQuery(queryString);
		  query.setString("custName", custName);
		  query.setString("custPassword", custPassword);
		  Object queryResult = query.uniqueResult();
		  Customer customer = (Customer)queryResult;
		  return customer;
	}
	
	//@SuppressWarnings("unchecked")
	public static List<Movie> getMoviesByTheatreId(int id){
		String queryString = "from Movie where theatreId: id";
		Query query = sessionFactory.openSession().createQuery(queryString);
		query.setInteger("theatreId", id);
		Object queryResult = query.uniqueResult();
		List<Movie> movies = (List<Movie>)queryResult;
		return movies;
		
	}
	
	public static Theatre getTheatreByName(String name){
		
		String queryString = "from theatre where theatreName = :name";
		Query query = sessionFactory.openSession().createQuery(queryString);
		query.setString("theatreName", name);
		Object queryResult = query.uniqueResult();
		Theatre theatre = (Theatre)queryResult;
		return theatre;
		
	}
	
	public static Ticket getTicketByCustomerId(int id){
		
		String quesyString = "from ticket where customerId = :id";
		Query query = sessionFactory.openSession().createQuery(quesyString);
		query.setInteger("customerId", id);
		Object queryResult = query.uniqueResult();
		Ticket ticket = (Ticket)queryResult;
		return ticket;
		
	}
	
	
	public static int updateObject(Object obj)
	{
		int result=0;
		
		Transaction tx=null;
		
		try {
			
			Session session=sessionFactory.openSession();
			tx=session.beginTransaction();
			
			session.saveOrUpdate(obj);
			
			tx.commit();
			
			result=1;
			
		} catch (Exception e) {
		
			tx.rollback();
			
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static int deleteObject(Class c,Serializable serializable)
	{
		int result=0;
		
		Session session=sessionFactory.openSession();
		
		Transaction tx=session.beginTransaction();
		
		try {
			
			Object obj=session.get(c,serializable);
			
			session.delete(obj);
			
			tx.commit();
			
			result=1;
						
		} catch (Exception e) {
			
			e.printStackTrace();
			
			tx.rollback();
		}
		
		return result;
	}

	public static List<Object> getObjectListByName(Class c, String columName, String value) {
		Session session=sessionFactory.openSession();
		  Criteria criteria = session.createCriteria(c);
			Criterion nameCriterion = Restrictions.eq(columName, value);
			criteria.add(nameCriterion);
			return criteria.list();
	}
	
	

}
