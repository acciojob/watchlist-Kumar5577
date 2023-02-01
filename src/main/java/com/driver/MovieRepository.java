package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Repository
public class MovieRepository {

    private HashMap<String,Movie> movieMap;
    private HashMap<String,Director> directorMap;
    private HashMap<String, List<String>>  directorMovieMap;

    public MovieRepository() {
        this.movieMap = new HashMap<String,Movie>();
        this.directorMap = new HashMap<String,Director>();
        this.directorMovieMap = new HashMap<String,List<String>>();
    }
    public void addMovie(Movie movie){
        movieMap.put(movie.getName(), movie);
    }
    public void addDirector(Director director){
        directorMap.put(director.getName(), director);
    }
    public void addMovieDirectorPair(String movie,String director){
        if(movieMap.containsKey(movie)&&directorMap.containsKey(director)){
            movieMap.put(movie,movieMap.get(movie));
            directorMap.put(director,directorMap.get(director));
            List<String> currentMovies = new ArrayList<>();
            if(directorMovieMap.containsKey(director))
                currentMovies = directorMovieMap.get(director);
            currentMovies.add(movie);
            directorMovieMap.put(director,currentMovies);


        }

        }
    public Movie getMovieByName(String movie){
        return movieMap.get(movie);
    }
    public Director getDirectorByName(String director){
        return directorMap.get(director);
    }
    public List<String> getMoviesByDirectorName(String director){
        List<String> movieList = new ArrayList<>();
        if(directorMovieMap.containsKey(director)) movieList = directorMovieMap.get(director);
        return movieList;
    }
    public List<String> findAllMovies(){
        return  new ArrayList<>(movieMap.keySet());
    }
    public void deleteDirector(String director) {
        List<String> movies = new ArrayList<>();

        if (directorMovieMap.containsKey(director)) {
            movies = directorMovieMap.get(director);
            for (String movie : movies) {
                if (movieMap.containsKey(movie)) {
                    movieMap.remove(movie);
                }
            }
            directorMovieMap.remove(director);
        }

        if (directorMap.containsKey(director)) {
            directorMap.remove(director);
        }
    }
    public void deleteAllDirectors(){
        HashSet<String> movieSet = new HashSet<>();

        // directorMap = new HashMap

        for(String director: directorMovieMap.keySet()){
            for(String movie: directorMovieMap.get(director)){
                movieSet.add(movie);
            }
        }
    }

}
