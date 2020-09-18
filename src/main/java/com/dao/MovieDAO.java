package com.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.db.HibernateTemplate;
import com.dto.Movie;

public class MovieDAO {
	
private SessionFactory factory = null;
	
	public int register(Movie movie){ 
		return HibernateTemplate.addObject(movie);
	}
	public Movie getMovie(int movieId) {
		return (Movie)HibernateTemplate.getObject(Movie.class,movieId);
	}
	public int editMovie(Movie movie) {
		return HibernateTemplate.updateObject(movie);
	}
    public int deleteMovie(int id) {
    	return HibernateTemplate.deleteObject(Movie.class,id);
	}
    public List<Movie> getAllMovies() {
		List<Movie> movies=(List)HibernateTemplate.getObjectListByQuery("From Movie");
		System.out.println("Inside All Movies ..."+movies);
		return movies;	
	}
    
    public List<Movie> getMoviesByTheatreId(int theatreId){
    	List<Movie> movies = (List)HibernateTemplate.getMoviesByTheatreId(theatreId);
    	System.out.println("Movies by theatre Id..."+movies);
    	return movies;
    }



}
