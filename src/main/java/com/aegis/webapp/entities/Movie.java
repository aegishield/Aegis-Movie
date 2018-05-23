package com.aegis.webapp.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name ="movie")
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "movieid")
	private Long movieId;
	
	@Column(name = "moviename")
    private String movieName;
	
	@Column(name = "imdblink")
    private String imdbLink;
	
	@Column(name = "posterlink")
    private String posterLink;
    
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "release_date",columnDefinition="DATE")
	private Date releaseDate;
	
	@Column(name = "status")
	private boolean status;
	
    public Movie() {
    	 
    }
    
    public Movie(Long movieId, String movieName, String imdbLink, String posterLink,Date releaseDate,String stringDate,boolean status) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.imdbLink = imdbLink;
		this.posterLink = posterLink;
		this.releaseDate = releaseDate;
		this.status = status;
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
	

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	
	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
    public String toString() {
        return this.movieName;
    }
}
