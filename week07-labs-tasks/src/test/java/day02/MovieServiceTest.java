package day02;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class MovieServiceTest {

    @Test
    void testCreate() throws IOException {
        MovieService movieService = new MovieService(Paths.get("src/main/resources/movies.csv"));
        assertEquals(5, movieService.getMovies().size());
        assertEquals("Jurassic park", movieService.getMovies().get(0).getTitle());
        assertEquals(1997, movieService.getMovies().get(1).getYearOfProduction());
        assertEquals("Peter Jackson", movieService.getMovies().get(3).getDirector());
    }

    @Test
    void testCreateWrongPath() {
        assertThrows(IOException.class, () -> new MovieService(Paths.get("src/main/resources/movies_.csv")));
    }
}
