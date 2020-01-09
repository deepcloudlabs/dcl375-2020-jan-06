package com.example.imdb.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.annotation.RequestScope;

import com.example.imdb.domain.Genre;
import com.example.imdb.model.CriteriaBean;
import com.example.imdb.service.MovieService;

@Controller
@RequestMapping("search")
@RequestScope
public class ImdbSearchController {
	@Autowired
	MovieService movieSrv;

	@ModelAttribute("genres") // ${genres}
	public Collection<Genre> getAllGenre() {
		return movieSrv.findAllGenres();
	}

	@PostMapping
	public String doSearch(@ModelAttribute("criteria") CriteriaBean criteria) {
		criteria.setMovies(movieSrv.findAllMoviesByCriteria(criteria));
		return "search";
	}

	@GetMapping
	public String home() {
		return "search";
	}
}
