package model;

import java.util.Objects;

public class Actor {
    private String firstName;
    private String lastName;
    private String country;

    public Actor(String firstName, String lastName, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void showInfo() {
        System.out.println(firstName + " " + lastName + ", pochodzenie: " + country);
    }

    @Override
    public String toString() {
        return "Imię " + firstName + " nazwisko " + lastName + " kraj " + country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        return Objects.equals(lastName, actor.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName);
    }
}


