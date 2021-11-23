package day02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MovieService {

    private final List<Movie> movies = new ArrayList<>();

    public MovieService(Path path) throws IOException {
        addMoviesFromFile(path);
    }

    private void addMoviesFromFile(Path path) throws IOException {
        List<String> lines = Files.readAllLines(path);
        for (String line : lines) {
            addMovieFromLine(line);
        }
    }

    private void addMovieFromLine(String line) {
        String[] parts = line.split(";");
        if (parts.length != 3) return;
        movies.add(new Movie(parts[0], Integer.parseInt(parts[1]), parts[2]));
    }

    public List<Movie> getMovies() {
        return movies;
    }
}
