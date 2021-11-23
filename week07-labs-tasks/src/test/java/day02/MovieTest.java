package day02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {

    @Test
    void testCreate() {
        Movie movie = new Movie("The Thing", 1980, "John Carpenter");
        assertEquals("The Thing", movie.getTitle());
        assertEquals(1980, movie.getYearOfProduction());
        assertEquals("John Carpenter", movie.getDirector());
    }
}
