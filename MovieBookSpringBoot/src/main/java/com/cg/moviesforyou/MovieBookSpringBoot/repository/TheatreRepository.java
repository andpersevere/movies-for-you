package com.cg.moviesforyou.MovieBookSpringBoot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.moviesforyou.MovieBookSpringBoot.dto.Theatre;

public interface TheatreRepository extends JpaRepository<Theatre, Integer>{

	
}