package com.driver;

public class Director {
    private String name; // name of the director
    private int numberOfMovie; // number of movies directed by the director
    private double imdbrating; // imdb rating for a director

    public Director() {
    }

    public Director(String name, int numberOfMovie, double imdbrating) {
        this.name = name;
        this.numberOfMovie = numberOfMovie;
        this.imdbrating = imdbrating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfMovie() {
        return numberOfMovie;
    }

    public void setNumberOfMovie(int numberOfMovie) {
        this.numberOfMovie = numberOfMovie;
    }

    public double getImdbrating() {
        return imdbrating;
    }

    public void setImdbrating(double imdbrating) {
        this.imdbrating = imdbrating;
    }
}
