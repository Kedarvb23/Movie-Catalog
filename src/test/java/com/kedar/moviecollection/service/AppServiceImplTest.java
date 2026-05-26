package com.kedar.moviecollection.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.kedar.moviecollection.entity.Actor;
import com.kedar.moviecollection.entity.Movie;
import com.kedar.moviecollection.entity.User;
import com.kedar.moviecollection.repo.ActorRepo;
import com.kedar.moviecollection.repo.MovieRepo;

@ExtendWith(MockitoExtension.class)
public class AppServiceImplTest {

    @Mock
    private MovieRepo movieRepo;
    
    @Mock
    private ActorRepo actorRepo;
    
    @InjectMocks
    private AppServiceImpl appServiceImpl;

    @DisplayName("TEST-CREATE-PRODUCT")
    @Test
    public void testsetMovieRepo() {
        Movie movie = new Movie();
        movie.setDescription("Movie is Amazing...!");
        movie.setCategory("Action");
        movie.setId(5L);

        
     
     // Use doNothing() for void methods
        doNothing().when(movieRepo).create(movie);

        // Call the method to test
        appServiceImpl.createMovie(movie);

        // Verify that the method was called
        verify(movieRepo, times(1)).create(movie);

        // Assert the category of the movie
        assertEquals("Action", movie.getCategory());
        }
        
        @DisplayName("Test findMovies")
        @Test
        public void testFindMovies() {
            List<Movie> movies = Arrays.asList(new Movie(), new Movie());
            when(movieRepo.findAll()).thenReturn(movies);

            List<Movie> result = appServiceImpl.findMovies();

            assertEquals(2, result.size());
            verify(movieRepo, times(1)).findAll();
        
    }
        @DisplayName("Test findMoviesByName")
        @Test
        public void testFindMoviesByName() {
            String name = "Inception";
            List<Movie> movies = Arrays.asList(new Movie(), new Movie());
            when(movieRepo.findByName(name)).thenReturn(movies);

            List<Movie> result = appServiceImpl.findMoviesByName(name);

            assertEquals(2, result.size());
            verify(movieRepo, times(1)).findByName(name);
        }

        @DisplayName("Test findMovie")
        @Test
        public void testFindMovie(){
            Long id = 1L;
            Movie movie = new Movie();
            when(movieRepo.findById(id)).thenReturn(movie);

            Movie result = appServiceImpl.findMovie(id);

            assertNotNull(result);
            verify(movieRepo, times(1)).findById(id);
        }


        @DisplayName("Test createMovie")
        @Test
        public void testCreateMovie() {
            Movie movie = new Movie();
            doNothing().when(movieRepo).create(movie);

            appServiceImpl.createMovie(movie);

            verify(movieRepo, times(1)).create(movie);
        }

        @DisplayName("Test createActor")
        @Test
        public void testCreateActor() {
            Actor actor = new Actor();
            doNothing().when(actorRepo).create(actor);

            appServiceImpl.createActor(actor);

            verify(actorRepo, times(1)).create(actor);
        }

		/*
		 * @DisplayName("Test updateMovie")
		 * 
		 * @Test public void testUpdateMovie() { Movie movie = new Movie();
		 * doNothing().when(movieRepo).update(movie);
		 * 
		 * appServiceImpl.update(movie);
		 * 
		 * verify(movieRepo, times(1)).update(movie); }
		 * 
		 * @DisplayName("Test updateActor")
		 * 
		 * @Test public void testUpdateActor() { Actor actor = new Actor();
		 * doNothing().when(actorRepo).update(actor);
		 * 
		 * appServiceImpl.update(actor);
		 * 
		 * verify(actorRepo, times(1)).update(actor); }
		 */

        @DisplayName("Test deleteMovie")
        @Test
        public void testDeleteMovie() {
            Long id = 1L;
            doNothing().when(movieRepo).delete(id);

            appServiceImpl.deleteMovie(id);

            verify(movieRepo, times(1)).delete(id);
        }

        @DisplayName("Test deleteActor")
        @Test
        public void testDeleteActor() {
            Long actorId = 1L;
            doNothing().when(actorRepo).delete(actorId);

            appServiceImpl.deleteActor(actorId);

            verify(actorRepo, times(1)).delete(actorId);
        }

        @DisplayName("Test findMoviesByCategory")
        @Test
        public void testFindMoviesByCategory() {
            String category = "Action";
            List<Movie> movies = Arrays.asList(new Movie(), new Movie());
            when(movieRepo.findByCategory(category)).thenReturn(movies);

            List<Movie> result = appServiceImpl.findMoviesByCategory(category);

            assertEquals(2, result.size());
            verify(movieRepo, times(1)).findByCategory(category);
        }

        @DisplayName("Test findMoviesByActor")
        @Test
        public void testFindMoviesByActor() {
            String actor = "Leonardo DiCaprio";
            List<Movie> movies = Arrays.asList(new Movie(), new Movie());
            when(movieRepo.findByActor(actor)).thenReturn(movies);

            List<Movie> result = appServiceImpl.findMoviesByActor(actor);

            assertEquals(2, result.size());
            verify(movieRepo, times(1)).findByActor(actor);
        }

        @DisplayName("Test findActors")
        @Test
        public void testFindActors() {
            List<Actor> actors = Arrays.asList(new Actor(), new Actor());
            when(actorRepo.findActors()).thenReturn(actors);

            List<Actor> result = appServiceImpl.findActors();

            assertEquals(2, result.size());
            verify(actorRepo, times(1)).findActors();
        }

        @DisplayName("Test findActor")
        @Test
        public void testFindActor() {
            Long id = 1L;
            Actor actor = new Actor();
            when(actorRepo.findActorById(id)).thenReturn(actor);

            Actor result = appServiceImpl.findActor(id);

            assertNotNull(result);
            verify(actorRepo, times(1)).findActorById(id);
        }

        @DisplayName("Test findActorsByMovie")
        @Test
        public void testFindActorsByMovie() {
            Movie movie = new Movie();
            List<Actor> actors = Arrays.asList(new Actor(), new Actor());
            when(actorRepo.findActorsByMovie(movie)).thenReturn(actors);

            List<Actor> result = appServiceImpl.findActorsByMovie(movie);

            assertEquals(2, result.size());
            verify(actorRepo, times(1)).findActorsByMovie(movie);
        }

        @DisplayName("Test registerUser")
        @Test
        public void testRegisterUser() {
            User user = new User();
            doNothing().when(actorRepo).registerUser(user);

            appServiceImpl.registerUser(user);

            verify(actorRepo, times(1)).registerUser(user);
        }
    }

