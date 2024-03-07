package db;

import db.exceptions.DuplicateException;
import model.Actor;
import model.Movie;
import model.TvSeries;

public class ApplicationDataBase {
    private Movie[] movies = new Movie[5];
    private int numberOfMovies;
    private TvSeries[] tvSeries = new TvSeries[5];
    private int numberOfTvSeries;
    private Actor[] actors = new Actor[5];
    private int numberOfActors;

    public Movie[] getMovies() {
        Movie[] withoutNulls = new Movie[numberOfMovies];
        for (int i = 0; i < numberOfMovies; i++) {
            withoutNulls[i] = movies[i];
        }
        return withoutNulls;
    }

    public TvSeries[] getTvSeries() {
        TvSeries[] withoutNulls = new TvSeries[numberOfTvSeries];
        for (int i = 0; i < numberOfTvSeries; i++) {
            withoutNulls[i] = tvSeries[i];
        }
        return withoutNulls;
    }

    public Actor[] getActors() {
        Actor[] withoutNulls = new Actor[numberOfActors];
        for (int i = 0; i < numberOfActors; i++) {
            withoutNulls[i] = actors[i];
        }
        return withoutNulls;
    }

    public void addMovie(Movie movie) {
        boolean movieExists = findMovie(movie);
        if (!movieExists) {
            movies[numberOfMovies] = movie;
            numberOfMovies++;
        } else {
            throw new DuplicateException("Obiekt już istnieje");
        }
    }

    public void addTvSeries(TvSeries series) {
        boolean tvSeriesExists = findTvSeries(series);
        if (!tvSeriesExists) {
            tvSeries[numberOfTvSeries] = series;
            numberOfTvSeries++;
        } else {
            throw new DuplicateException("Obiekt już istnieje");
        }
    }

    public void addActor(Actor actor) {
        boolean actorExists = findActor(actor);
        if (!actorExists) {
            actors[numberOfActors] = actor;
            numberOfActors++;
        } else {
            throw new DuplicateException("Obiekt już istnieje");
        }
    }

    private boolean findMovie(Movie movie) {
        for (int i = 0; i < numberOfMovies; i++) {
            if (movie.equals(movies[i])) {
                return true;
            }
        }
        return false;
    }

    private boolean findActor(Actor actor) {
        for (int i = 0; i < numberOfActors; i++) {
            if (actor.equals(actors[i])) {
                return true;
            }
        }
        return false;
    }

    private boolean findTvSeries(TvSeries series) {
        for (int i = 0; i < numberOfTvSeries; i++) {
            if (series.equals(tvSeries[i])) {
                return true;
            }
        }
        return false;
    }
}
