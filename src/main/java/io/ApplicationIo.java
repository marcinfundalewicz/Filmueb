package io;

import model.Actor;
import model.Genre;
import model.Movie;
import model.TvSeries;
import model.exceptions.GenreNotExistsException;

import java.util.Scanner;

public class ApplicationIo {
    Scanner scanner = new Scanner(System.in);

    public Movie createMovie() {
        System.out.println("Podaj tytuł");
        String title = scanner.nextLine();
        int year;
        do {
            System.out.println("Podaj rok produkcji");
            year = scanner.nextInt();
            if (year <= 0) {
                System.err.println("Podany rok nie może być mniejszy od 0");
            }
        } while (year <= 0);
        scanner.nextLine();
        System.out.println("Podaj reżysera");
        String director = scanner.nextLine();
        System.out.println("Podaj gatunek [Sci Fi, Komedia, Akcja, Thriller]");
        String genre = scanner.nextLine();
        System.out.println("Podaj opis");
        String description = scanner.nextLine();
        System.out.println("Podaj ocenę");
        int rating = scanner.nextInt();
        scanner.nextLine();

        try {
            Genre checkGenre = Genre.convert(genre);
        } catch (GenreNotExistsException e) {
            System.err.println((e.getMessage()));
        }

        return new

                Movie(title, year, director, genre, description, rating);
    }

    public Actor createActor() {
        System.out.println("Podaj imię");
        String firstName = scanner.nextLine();
        System.out.println("Podaj nazwisko");
        String lastName = scanner.nextLine();
        System.out.println("Podaj kraj");
        String country = scanner.nextLine();

        return new Actor(firstName, lastName, country);
    }

    public TvSeries createTvSeries() {
        System.out.println("Podaj tytuł");
        String title = scanner.nextLine();
        System.out.println("Podaj liczbę sezonów");
        int seasons = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj liczbę odcinków");
        int episodes = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj producenta");
        String producer = scanner.nextLine();
        System.out.println("Podaj gatunek [Sci Fi, Komedia, Akcja, Thriller]");
        String genre = scanner.nextLine();
        System.out.println("Podaj opis");
        String description = scanner.nextLine();
        System.out.println("Podaj ocenę");
        int rating = scanner.nextInt();
        scanner.nextLine();
        Genre checkGenre = Genre.convert(genre);

        if (seasons <= 0 || episodes <= 0 || rating <= 0 || rating > 10 || checkGenre == null) {
            System.out.println("Wprowadzona wartość jest nieprawidłowa. Nie udało się utworzyć serialu");
            return null;
        }

        return new TvSeries(title, seasons, episodes, producer, genre, description, rating);
    }

    public int readInt() {
        int number = scanner.nextInt();
        scanner.nextLine();
        return number;
    }
}
