package day04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourierTest {

    Courier courier = new Courier();

    @Test
    void testAddRide() {
        courier.addRide(new Ride(1, 1, 10.0));
        courier.addRide(new Ride(1, 2, 20.0));
        courier.addRide(new Ride(2, 1, 30.0));
        assertEquals(3, courier.getRides().size());
        assertEquals(1, courier.getRides().get(0).getDay());
        assertEquals(2, courier.getRides().get(1).getRideNumber());
        assertEquals(30.0, courier.getRides().get(2).getKm());
    }

    @Test
    void testAddRideWrongDay() {
        courier.addRide(new Ride(1, 1, 10.0));
        courier.addRide(new Ride(2, 1, 20.0));
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> courier.addRide(new Ride(1, 2, 30.0)));
        assertEquals("Day must be sequential.", e.getMessage());
    }

    @Test
    void testAddRideWrongRideNumber() {
        courier.addRide(new Ride(1, 1, 10.0));
        courier.addRide(new Ride(2, 2, 20.0));
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> courier.addRide(new Ride(2, 1, 30.0)));
        assertEquals("Ride number must be sequential.", e.getMessage());
    }
}
