package com.aegis.webapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aegis.webapp.entities.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long>{
	List<Movie> findAll();
	Movie findByMovieName(String movieName);
	Movie findByMovieId(Long movieId);
}
