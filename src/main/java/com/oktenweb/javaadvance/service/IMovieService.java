package com.oktenweb.javaadvance.service;

import com.oktenweb.javaadvance.entity.Movie;

import java.util.List;

public interface IMovieService {

    Movie insertMovie(Movie movie);

    List<Movie> getAllMovies();

    Movie getMovie(int id);

    Movie updateMovie(Movie movie);

    void removeMovie(int id);

}
