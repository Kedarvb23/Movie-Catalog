package com.kedar.moviecollection.repo;

import java.util.List;

import com.kedar.moviecollection.entity.Actor;
import com.kedar.moviecollection.entity.Movie;
import com.kedar.moviecollection.entity.User;

public interface ActorRepo {
	List<Actor> findActorsByMovie(Movie movie);
	List<Actor> findActors();
	Actor findActorById(Long id);
	void create(Actor actor);
	Actor update(Actor actor);
	void delete(Long actor_id);
	void registerUser(User user);
}
