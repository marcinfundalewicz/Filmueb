package controller;

import controller.exceptions.OptionNotExistsException;

public enum Option {
    ADD_MOVIE(0, "Dodaj film"),
    ADD_TV_SERIES(1, "Dodaj serial"),
    ADD_ACTOR(2, "Dodaj aktora"),
    PRINT_ALL(3, "Wyświetl wszystkie filmy, seriale i aktorów"),
    EXIT(4, "Koniec programu");

    private int value;
    private String description;

    Option(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public static Option convert(int option) {
        for (Option options : Option.values()) {
            if (options.value == option) {
                return options;
            }
        }
        throw new OptionNotExistsException("Opcja nie istnieje");
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Opcja " + value + " opis " + description;
    }
}
