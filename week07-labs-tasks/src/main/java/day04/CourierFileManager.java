package day04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CourierFileManager {

    private CourierFileManager() {
        throw new IllegalStateException("Utility class");
    }

    public static Courier createCourierFromFile(Path path) {
        try {
            return createCourier(Files.readAllLines(path));
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file.", ioe);
        }
    }

    private static Courier createCourier(List<String> lines) {
        Courier courier = new Courier();
        for (String line : lines) {
            String[] parts = line.split(" ");
            courier.addRide(new Ride(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Double.parseDouble(parts[2])));
        }
        return courier;
    }
}
