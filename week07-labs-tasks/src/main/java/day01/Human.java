package day01;

import java.time.LocalDate;

public class Human {

    private String name;
    private int yearOfBirth;

    public Human(String name, int yearOfBirth) {
        setName(name);
        setYearOfBirth(yearOfBirth);
    }

    public String getName() {
        return name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank!");
        } else if (!name.trim().contains(" ")) {
            throw new IllegalArgumentException("Name must contain at least two words!");
        }
        this.name = name;
    }

    public void setYearOfBirth(int yearOfBirth) {
        int max = LocalDate.now().getYear();
        int min = max - 120;
        if (yearOfBirth < min) {
            throw new IllegalArgumentException("Year of birth cannot be below minimum value of " + min + "!");
        } else if (yearOfBirth > max) {
            throw new IllegalArgumentException("Year of birth cannot exceed maximum value of " + max + "!");
        }
        this.yearOfBirth = yearOfBirth;
    }
}
