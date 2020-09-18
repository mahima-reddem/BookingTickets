package com.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.db.HibernateTemplate;
import com.dto.Theatre;

public class TheatreDAO {
	
private SessionFactory factory = null;
	
	public int register(Theatre theatre){
		return HibernateTemplate.addObject(theatre);
	}
	
	public Theatre getTheatre(int theatreId) {
		return (Theatre)HibernateTemplate.getObject(Theatre.class,theatreId);
	}  
	
	public List<Theatre> getAllTheatres(){
		List<Theatre> theatres = (List)HibernateTemplate.getObjectListByQuery("from Theatre");
		System.out.println("Inside All Theatres ..."+theatres);
		return theatres;
	}
	
	public int editTheatre(Theatre theatre){
		return HibernateTemplate.updateObject(theatre);
	}
	
	public int deleteTheatre(int id){
		return HibernateTemplate.deleteObject(Theatre.class, id);
	}

	

}
