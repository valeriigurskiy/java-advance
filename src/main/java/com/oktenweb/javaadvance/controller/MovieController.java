package com.oktenweb.javaadvance.controller;

import com.oktenweb.javaadvance.entity.Movie;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MovieController {

    private List<Movie> movies = new ArrayList<>();

    {
        movies.add(new Movie(1, "123", 125));
        movies.add(new Movie(2, "321", 130));
    }


    @GetMapping(value = "/movies")
    public List<Movie> getMovies(){
        return movies;
    }

    @GetMapping(value = "/movies/{id}")
    public Movie getMovie(@PathVariable int id){
        return movies.stream()
                .filter(movie -> movie.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No such movie"));
    }

    @PostMapping(value = "/movies")
    public Movie insertMovie(@RequestBody Movie movie){
        movies.add(movie);
        return movie;
    }

}
