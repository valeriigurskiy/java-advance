package com.oktenweb.javaadvance.controller;

import com.oktenweb.javaadvance.dao.MovieDao;
import com.oktenweb.javaadvance.entity.Movie;
import com.oktenweb.javaadvance.service.IMovieService;
import com.oktenweb.javaadvance.validator.MovieValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private IMovieService movieService;
//    private MovieValidator movieValidator;

    @Autowired
    public MovieController(IMovieService movieService){
        this.movieService = movieService;
    }
    
    @GetMapping(value = "/movies")
    public List<Movie> getMovies() {
        return movieService.getAllMovies();
    }

//    @GetMapping(value = "/movies/{id}")
//    public Movie getMovieById(@PathVariable int id){
//        return movies.stream()
//                .filter(movie -> movie.getId() == id)
//                .findFirst()
//                .orElseThrow(() -> new RuntimeException("No such movie"));
//    }

//    @GetMapping(value ="/movies/{title}")
//    public Movie getMovieByName(@PathVariable String title){
//        return movies.stream()
//                .filter(movie -> movie.getTitle().equals(title))
//                .findFirst()
//                .orElseThrow(() -> new RuntimeException("No such movie"));
//    }

    @GetMapping(value = "/movies/{id}")
    public Movie getMovie(@PathVariable int id) {
        return movieService.getMovie(id);
    }

//
//    @PostMapping(value = "/movies")
//    public Movie insertMovie(@RequestBody Movie movie){
//        movies.add(movie);
//        return movie;
//    }

    @PostMapping(value = "/movies")
//    @ResponseBody(HttpStatus.CREATED)
    public Movie insertMovie(@RequestBody @Valid Movie movie) {
        return movieService.insertMovie(movie);
    }

    @PutMapping(value = "/{id}")
    public Movie updateMovie(@PathVariable int id, @RequestBody Movie movie) {
        movie.setId(id);
        return movieService.updateMovie(movie);
    }

    @DeleteMapping(value = "/movies/{id}")
    public void deleteMovie(@PathVariable int id) {
        movieService.removeMovie(id);
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        webDataBinder.addValidators(new MovieValidator());
//        webDataBinder.addValidators(movieValidator);
    }

}
