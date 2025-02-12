package com.kedar.moviecollection.service;

import java.util.List;

import com.kedar.moviecollection.entity.Actor;
import com.kedar.moviecollection.entity.Movie;
import com.kedar.moviecollection.entity.User;


public interface AppService {
	List<Actor> findActors();
	List<Actor> findActorsByMovie(Movie movie);
	List<Movie> findMovies();
	List<Movie> findMoviesByName(String name);
	List<Movie> findMoviesByCategory(String category);
	List<Movie> findMoviesByActor(String actor);
	Movie findMovie(Long id);
	Actor findActor(Long id);
	void createMovie(Movie movie);
	void createActor(Actor actor);
	void update(Movie movie);
	void update(Actor actor);
	void deleteMovie(Long id);
	void deleteActor(Long actor_id);
	public void registerUser(User user);
}
