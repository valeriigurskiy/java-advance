package com.oktenweb.javaadvance.dao;

import com.oktenweb.javaadvance.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieDao extends JpaRepository<Movie, Integer> {

}
