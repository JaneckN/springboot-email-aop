package pl.com.janeck.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.com.janeck.annotation.AddMovie;
import pl.com.janeck.service.EmailService;
import pl.com.janeck.model.Movie;
import pl.com.janeck.service.MovieService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private MovieService movieService;
    private EmailService emailService;

    @Autowired
    public MovieController(MovieService movieService, EmailService emailService) {
        this.movieService = movieService;
        this.emailService = emailService;
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        return new ResponseEntity<>(movieService.getMovies(), HttpStatus.OK);
    }


    @PostMapping
    @AddMovie
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movieToAdd) {
        Optional<Movie> movie = movieService.addMovie(movieToAdd);
        if (movie.isPresent()) {
            return new ResponseEntity<>(movie.get(), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
