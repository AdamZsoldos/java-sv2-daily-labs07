package day04;

import java.util.ArrayList;
import java.util.List;

public class Courier {


    private final List<Ride> rides = new ArrayList<>();

    public void addRide(Ride ride) {
        validateRide(ride);
        rides.add(ride);
    }

    private void validateRide(Ride ride) {
        if (rides.isEmpty()) return;
        if (rides.get(rides.size() - 1).getDay() > ride.getDay()) {
            throw new IllegalArgumentException("Day must be sequential.");
        } else if (rides.get(rides.size() - 1).getDay() == ride.getDay() &&
                rides.get(rides.size() - 1).getRideNumber() >= ride.getRideNumber()) {
            throw new IllegalArgumentException("Ride number must be sequential.");
        }
    }

    public List<Ride> getRides() {
        return rides;
    }
}
