package day04;

public class Ride {

    private final int day;
    private final int rideNumber;
    private final double km;

    public Ride(int day, int rideNumber, double km) {
        this.day = day;
        this.rideNumber = rideNumber;
        this.km = km;
    }

    public int getDay() {
        return day;
    }

    public int getRideNumber() {
        return rideNumber;
    }

    public double getKm() {
        return km;
    }
}
