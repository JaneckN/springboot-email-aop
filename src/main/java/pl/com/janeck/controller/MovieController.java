package pl.com.janeck.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.com.janeck.service.MailService;
import pl.com.janeck.model.Movie;
import pl.com.janeck.service.MovieService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private MovieService movieService;
    private MailService mailService;

    @Autowired
    public MovieController(MovieService movieService, MailService mailService) {
        this.movieService = movieService;
        this.mailService = mailService;
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        return new ResponseEntity<>(movieService.getMovies(), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movieToAdd) {
        Optional<Movie> movie = movieService.addMovie(movieToAdd);
        if (movie.isPresent()) {
            mailService.sendSimpleMessage("janeck@protonmail.com", "Added Movie", movieToAdd.getTitle() + " movie was added @ " + LocalDateTime.now());
            return new ResponseEntity<>(movie.get(), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
