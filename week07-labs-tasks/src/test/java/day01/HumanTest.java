package day01;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class HumanTest {

    int maxYear = LocalDate.now().getYear();
    int minYear = maxYear - 120;

    @Test
    void testCreateMinYear() {
        Human human = new Human("John Doe", minYear);
        assertEquals("John Doe", human.getName());
        assertEquals(minYear, human.getYearOfBirth());
    }

    @Test
    void testCreateMaxYear() {
        Human human = new Human("John Doe", maxYear);
        assertEquals("John Doe", human.getName());
        assertEquals(maxYear, human.getYearOfBirth());
    }

    @Test
    void testCreateYearTooLow() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> new Human("John Doe", minYear - 1));
        assertEquals("Year of birth cannot be below minimum value of " + minYear + "!", iae.getMessage());
    }

    @Test
    void testCreateYearTooHigh() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> new Human("John Doe", maxYear + 1));
        assertEquals("Year of birth cannot exceed maximum value of " + maxYear + "!", iae.getMessage());
    }

    @Test
    void testCreateNameNull() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> new Human(null, minYear));
        assertEquals("Name cannot be null!", iae.getMessage());
    }

    @Test
    void testCreateNameBlank() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> new Human(" \n \r ", minYear));
        assertEquals("Name cannot be blank!", iae.getMessage());
    }

    @Test
    void testCreateNameOneWord() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> new Human("John", minYear));
        assertEquals("Name must contain at least two words!", iae.getMessage());
    }
}
