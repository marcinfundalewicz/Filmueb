package model;

import model.exceptions.GenreNotExistsException;

public enum Genre {
    SCI_FI("Sci Fi"),
    COMEDY("Komedia"),
    ACTION("Akcja"),
    THRILLER("Thriller");

    String polishDescription;

    Genre(String polishDescription) {
        this.polishDescription = polishDescription;
    }

    public static Genre convert(String genre) {
        for (Genre genres : Genre.values()) {
            if (genre.equalsIgnoreCase(genres.polishDescription)) {
                return genres;
            }
        }
        throw new GenreNotExistsException("Podany gatunek jest nieprawidłowy");
    }

    @Override
    public String toString() {
        return "Gatunek " + polishDescription;

    }
}
