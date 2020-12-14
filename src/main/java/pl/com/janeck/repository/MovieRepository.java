package pl.com.janeck.repository;

import org.springframework.stereotype.Repository;
import pl.com.janeck.model.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;

@Repository
public class MovieRepository {

    private List<Movie> movies = initialize();

    private List<Movie> initialize() {
        List<Movie> initialDB = new ArrayList<Movie>();
        initialDB.add(new Movie(1L, "Rambo 2 Krew", 1990, "WB"));
        initialDB.add(new Movie(2L, "Zaginiony w akcji", 1989, "Philadelphia"));
        initialDB.add(new Movie(3L, "Rocky VIII", 1998, "Pictures"));
        return initialDB;
    }


    public List<Movie> getMovies() {
        return movies;
    }

    public boolean addMovie(Movie movieToAdd) {
        movies.add(movieToAdd);
        return true;
    }

    public Optional<Movie> getMovieById(Long id) {
        return movies.stream().filter(movie -> id.equals(movie.getId())).findAny();

    }

    public boolean deleteMovie(Movie movie) {
        movies.remove(movie);
        return true;
    }

    public Long getNextId() {
        OptionalLong id = movies.stream().mapToLong(Movie::getId).max();
        if (id.isPresent()) {
            return 1L + id.getAsLong();
        }
        return 1L;
    }

}
