package day02;

public class Movie {

    private final String title;
    private final int yearOfProduction;
    private final String director;

    public Movie(String title, int yearOfProduction, String director) {
        this.title = title;
        this.yearOfProduction = yearOfProduction;
        this.director = director;
    }

    public String getTitle() {
        return title;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public String getDirector() {
        return director;
    }
}
