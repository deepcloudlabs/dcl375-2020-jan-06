package com.example.imdb.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.annotation.RequestScope;

import com.example.imdb.domain.Genre;
import com.example.imdb.domain.Movie;
import com.example.imdb.model.CriteriaBean;
import com.example.imdb.service.MovieService;

@Controller
@RequestMapping("search")
@RequestScope
public class ImdbSearchController {
	@Autowired MovieService movieSrv;
	@ModelAttribute("genres") // ${genres}
	public Collection<Genre> getAllGenre(){
		return movieSrv.findAllGenres();
	}
	@PostMapping
	public String doSearch(Model model,
			CriteriaBean criteria) {
		Collection<Movie> movies = 
				movieSrv.findAllMoviesByCriteria(
						criteria);
		model.addAttribute("movies", movies);
		return "search";
	}
	
	@GetMapping
	public String home() {
		return "search";
	}
}
