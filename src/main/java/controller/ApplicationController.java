package controller;

import controller.exceptions.OptionNotExistsException;
import db.ApplicationDataBase;
import db.exceptions.DuplicateException;
import io.ApplicationIo;
import io.exceptions.IncorrectDataException;
import model.Actor;
import model.Movie;
import model.TvSeries;
import model.exceptions.GenreNotExistsException;

public class ApplicationController {
    private ApplicationDataBase dataBase = new ApplicationDataBase();
    private ApplicationIo reader = new ApplicationIo();

    public void mainLoop() {
        int userOption;
        do {
            printOptions();
            System.out.println("Wybierz opcję:");
            userOption = reader.readInt();
            chooseOption(userOption);
        } while (userOption != Option.EXIT.getValue());
    }

    private void printOptions() {
        System.out.println(Option.ADD_MOVIE.getValue() + " - " + Option.ADD_MOVIE.getDescription());
        System.out.println(Option.ADD_TV_SERIES.getValue() + " - " + Option.ADD_TV_SERIES.getDescription());
        System.out.println(Option.ADD_ACTOR.getValue() + " - " + Option.ADD_ACTOR.getDescription());
        System.out.println(Option.PRINT_ALL.getValue() + " - " + Option.PRINT_ALL.getDescription());
        System.out.println(Option.EXIT.getValue() + " - " + Option.EXIT.getDescription());
    }

    private void printAll() {
        System.out.println("Filmy");
        Movie[] movies = dataBase.getMovies();
        for (Movie movie : movies) {
            System.out.println(movie);
        }
        System.out.println("Seriale");
        TvSeries[] tvSeries = dataBase.getTvSeries();
        for (TvSeries series : tvSeries) {
            System.out.println(series);
        }
        System.out.println("Aktorzy");
        Actor[] actors = dataBase.getActors();
        for (Actor actor : actors) {
            actor.showInfo();
        }
    }

    private void chooseOption(int userOption) {
        Option checkOption = Option.convert(userOption);
        switch (checkOption) {
            case ADD_MOVIE -> addMovie();
            case ADD_TV_SERIES -> addTvSeries();
            case ADD_ACTOR -> addActor();
            case PRINT_ALL -> printAll();
            case EXIT -> System.out.println(checkOption.getDescription());
            default -> System.out.println();
        }
    }

    private void addMovie() {
        Movie movie = reader.createMovie();
        dataBase.addMovie(movie);
    }

    private void addTvSeries() {
        TvSeries tvSeries = reader.createTvSeries();
        dataBase.addTvSeries(tvSeries);
    }

    private void addActor() {
        Actor actor = reader.createActor();
        dataBase.addActor(actor);
    }
}
