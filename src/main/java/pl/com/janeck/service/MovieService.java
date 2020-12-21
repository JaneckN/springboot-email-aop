package pl.com.janeck.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.com.janeck.model.Movie;
import pl.com.janeck.repository.MovieRepository;

import java.util.List;
import java.util.Optional;


@Service
public class MovieService {

    private final MovieRepository movieRepository;


    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getMovies() {
        return movieRepository.getMovies();
    }

    public Optional<Movie> addMovie(Movie movieToAdd) {
        Long id = movieRepository.getNextId();
        movieToAdd.setId(id);
        movieRepository.addMovie(movieToAdd);
        return Optional.of(movieToAdd);
    }


}
