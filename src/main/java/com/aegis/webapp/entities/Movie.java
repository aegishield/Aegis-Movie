package com.aegis.webapp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "movieid")
	private Long movieId;
	
	@Column(name = "moviename")
    private String movieName;
	
	@Column(name = "imdblink")
    private String imdbLink;
	
	@Column(name = "posterlink")
    private String posterLink;
    
    public Movie() {
    	 
    }
    
    public Movie(Long movieId, String movieName, String imdbLink, String posterLink) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.imdbLink = imdbLink;
		this.posterLink = posterLink;
	}

    
    
	public Long getMovieId() {
		return movieId;
	}



	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}



	public String getMovieName() {
		return movieName;
	}



	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}



	public String getImdbLink() {
		return imdbLink;
	}



	public void setImdbLink(String imdbLink) {
		this.imdbLink = imdbLink;
	}



	public String getPosterLink() {
		return posterLink;
	}



	public void setPosterLink(String posterLink) {
		this.posterLink = posterLink;
	}



	@Override
    public String toString() {
        return this.movieName;
    }
}
