package com.example.imdb.controller;

import java.io.IOException;
import java.util.Collection;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.imdb.domain.Movie;
import com.example.imdb.service.MovieService;

@WebServlet(urlPatterns = "/search")
public class ImdbController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private MovieService movieSrv;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("search.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String genre = request.getParameter("genre");
		int from = 1970;
		int to = 1979;
		try {
			to = Integer.parseInt(request.getParameter("to"));
		} catch (NumberFormatException e) {
		}
		try {
			from = Integer.parseInt(request.getParameter("from"));
		} catch (NumberFormatException e) {
		}
		Collection<Movie> movies = movieSrv.findAllMoviesByYearRangeAndGenre(genre, from, to);
		// JSP: ${movies}
		request.setAttribute("movies", movies);
		request.getRequestDispatcher("search.jsp").forward(request, response);
	}

}
