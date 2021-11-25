package day04;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class CourierFileManagerTest {

    @Test
    void testCreateCourierFromFile() {
        Courier courier = CourierFileManager.createCourierFromFile(Path.of("src/test/resources/courier.txt"));
        assertEquals(6, courier.getRides().size());
        assertEquals(1, courier.getRides().get(0).getDay());
        assertEquals(1, courier.getRides().get(3).getRideNumber());
        assertEquals(9.0, courier.getRides().get(5).getKm());
    }
}
