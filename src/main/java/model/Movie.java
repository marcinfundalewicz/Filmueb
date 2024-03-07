package model;

import java.util.Objects;

public class Movie extends Item {
    private int year;
    private String director;

    public Movie(String title, int year, String director, String genre, String description, int rating) {
        super(title, genre, description, rating);
        this.year = year;
        this.director = director;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return super.toString() + " rok " + year + " reżyser " + director;
    }
}
