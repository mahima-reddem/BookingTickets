package com.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@XmlRootElement
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})

public class Theatre {
	
	@Id@GeneratedValue
	private int theatreId;
	private String theatreName;
	private String theatreAddress;
	
	@OneToMany(mappedBy = "theatre", fetch = FetchType.LAZY)
	 @Fetch(value = FetchMode.SUBSELECT)
	private List<Movie> movies =new ArrayList<Movie>();
	
	
	public Theatre(){
		super();
	}
	
	
	public int getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(int theatreId) {
		this.theatreId = theatreId;
	}

	public String getTheatreName() {
		return theatreName;
	}

	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}

	public String getTheatreAddress() {
		return theatreAddress;
	}

	public void setTheatreAddress(String theatreAddress) {
		this.theatreAddress = theatreAddress;
	}

	/*public List<Movie> getMovieList() {
		return movies;
	}

	public void setMovieList(List<Movie> movieList) {
		this.movies = movieList;
	}*/



}
