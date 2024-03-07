package app;

import controller.ApplicationController;
import controller.exceptions.OptionNotExistsException;
import db.exceptions.DuplicateException;
import io.exceptions.IncorrectDataException;
import model.exceptions.GenreNotExistsException;

public class Filmweb {

    public static void main(String[] args) {
        try {
            final String appName = "Filmweb v0.4";
            ApplicationController controller = new ApplicationController();
            controller.mainLoop();
        } catch (IncorrectDataException | OptionNotExistsException | DuplicateException | GenreNotExistsException e) {
            System.err.println((e.getMessage()));
        }
    }
}