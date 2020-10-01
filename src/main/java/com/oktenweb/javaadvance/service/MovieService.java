package com.oktenweb.javaadvance.service;

import com.oktenweb.javaadvance.dao.MovieDao;
import com.oktenweb.javaadvance.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService implements IMovieService{

    @Autowired
    private MovieDao movieDao;

    @Override
    public Movie insertMovie(Movie movie) {

        return movieDao.save(movie);
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieDao.findAll();
    }

    @Override
    public Movie getMovie(int id) {
        return movieDao.findById(id).orElseThrow(() -> new RuntimeException("Error " + id));
    }

    @Override
    public Movie updateMovie(Movie movie) {
        return movieDao.save(movie);
    }

    @Override
    public void removeMovie(int id) {
        movieDao.deleteById(id);
    }
}
