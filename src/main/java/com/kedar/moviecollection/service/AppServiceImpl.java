package com.kedar.moviecollection.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kedar.moviecollection.entity.Actor;
import com.kedar.moviecollection.entity.Movie;
import com.kedar.moviecollection.entity.User;
import com.kedar.moviecollection.repo.ActorRepo;
import com.kedar.moviecollection.repo.MovieRepo;

@Service
@Transactional
public class AppServiceImpl implements AppService {

    private static final Logger log = LoggerFactory.getLogger(AppServiceImpl.class);
    
    private MovieRepo movieRepo;
    private ActorRepo actorRepo;
    
    @Autowired
    public void setMovieRepo(MovieRepo movieRepo) {
        this.movieRepo = movieRepo;
    }
    
    @Autowired
    public void setActorRepo(ActorRepo actorRepo) {
        this.actorRepo = actorRepo;
    }
    
    @Override
    public List<Movie> findMovies() {
        log.info("Fetching all movies");
        try {
            List<Movie> movies = movieRepo.findAll();
            log.debug("Fetched movies: {}", movies);
            return movies;
        } catch (Exception e) {
            log.error("Error fetching movies: {}", e.getMessage());
            throw e;
        }
    }

    @Override
    public List<Movie> findMoviesByName(String name) {
        log.info("Fetching movies by name: {}", name);
        try {
            List<Movie> movies = movieRepo.findByName(name);
            log.debug("Fetched movies by name '{}': {}", name, movies);
            return movies;
        } catch (Exception e) {
            log.error("Error fetching movies by name '{}': {}", name, e.getMessage());
            throw e;
        }
    }

    @Override
    public Movie findMovie(Long id) {
        log.debug("Entering findMovie method with id: {}", id);
        try {
            Movie movie = movieRepo.findById(id);
            log.info("Movie found: {}", movie);
            return movie;
        } catch (Exception e) {
            log.error("Error finding movie with id '{}': {}", id, e.getMessage());
            throw e;
        }
    }

    
    @Override
    public void createMovie(Movie movie) {
        log.info("Creating movie: {}", movie);
        try {
            movieRepo.create(movie);
            log.debug("Movie created: {}", movie);
        } catch (Exception e) {
            log.error("Error creating movie '{}': {}", movie, e.getMessage());
            throw e;
        }
    }
    
    @Override
    public void createActor(Actor actor) {
        log.info("Creating actor: {}", actor);
        try {
            actorRepo.create(actor);
            log.debug("Actor created: {}", actor);
        } catch (Exception e) {
            log.error("Error creating actor '{}': {}", actor, e.getMessage());
            throw e;
        }
    }

    @Override
    public void update(Movie movie) {
        log.info("Updating movie: {}", movie);
        try {
            movieRepo.update(movie);
            log.debug("Movie updated: {}", movie);
        } catch (Exception e) {
            log.error("Error updating movie '{}': {}", movie, e.getMessage());
            throw e;
        }
    }
    
    @Override
    public void update(Actor actor) {
        log.info("Updating actor: {}", actor);
        try {
            actorRepo.update(actor);
            log.debug("Actor updated: {}", actor);
        } catch (Exception e) {
            log.error("Error updating actor '{}': {}", actor, e.getMessage());
            throw e;
        }
    }

    @Override
    public void deleteMovie(Long id) {
        log.info("Deleting movie with id: {}", id);
        try {
            movieRepo.delete(id);
            log.debug("Movie deleted with id: {}", id);
        } catch (Exception e) {
            log.error("Error deleting movie with id '{}': {}", id, e.getMessage());
            throw e;
        }
    }
    
    @Override
    public void deleteActor(Long actor_id) {
        log.info("Deleting actor with id: {}", actor_id);
        try {
            actorRepo.delete(actor_id);
            log.debug("Actor deleted with id: {}", actor_id);
        } catch (Exception e) {
            log.error("Error deleting actor with id '{}': {}", actor_id, e.getMessage());
            throw e;
        }
    }

    @Override
    public List<Movie> findMoviesByCategory(String category) {
        log.info("Fetching movies by category: {}", category);
        try {
            List<Movie> movies = movieRepo.findByCategory(category);
            log.debug("Fetched movies by category '{}': {}", category, movies);
            return movies;
        } catch (Exception e) {
            log.error("Error fetching movies by category '{}': {}", category, e.getMessage());
            throw e;
        }
    }

    @Override
    public List<Movie> findMoviesByActor(String actor) {
        log.info("Fetching movies by actor: {}", actor);
        try {
            List<Movie> movies = movieRepo.findByActor(actor);
            log.debug("Fetched movies by actor '{}': {}", actor, movies);
            return movies;
        } catch (Exception e) {
            log.error("Error fetching movies by actor '{}': {}", actor, e.getMessage());
            throw e;
        }
    }

    @Override
    public List<Actor> findActors() {
        log.info("Fetching all actors");
        try {
            List<Actor> actors = actorRepo.findActors();
            log.debug("Fetched actors: {}", actors);
            return actors;
        } catch (Exception e) {
            log.error("Error fetching actors: {}", e.getMessage());
            throw e;
        }
    }

    @Override
    public Actor findActor(Long id) {
        log.info("Fetching actor by id: {}", id);
        try {
            Actor actor = actorRepo.findActorById(id);
            log.debug("Fetched actor by id '{}': {}", id, actor);
            return actor;
        } catch (Exception e) {
            log.error("Error fetching actor by id '{}': {}", id, e.getMessage());
            throw e;
        }
    }

    @Override
    public List<Actor> findActorsByMovie(Movie movie) {
        log.info("Fetching actors by movie: {}", movie);
        try {
            List<Actor> actors = actorRepo.findActorsByMovie(movie);
            log.debug("Fetched actors by movie '{}': {}", movie, actors);
            return actors;
        } catch (Exception e) {
            log.error("Error fetching actors by movie '{}': {}", movie, e.getMessage());
            throw e;
        }
    }
    
    @Override
    public void registerUser(User user) {
        log.info("Registering user: {}", user);
        try {
            actorRepo.registerUser(user);
            log.debug("User registered: {}", user);
        } catch (Exception e) {
            log.error("Error registering user '{}': {}", user, e.getMessage());
            throw e;
        }
    }
}
