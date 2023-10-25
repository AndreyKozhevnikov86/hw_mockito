package ru.netology.qa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class MovieManagerTest {
    MovieManager manager = new MovieManager();

    @BeforeEach

    public void setUp() {
        manager.addMovie("Film1");
        manager.addMovie("Film2");
        manager.addMovie("Film3");

    }

    @Test
    public void addMovie() {

        String[] actual = manager.findAll();
        String[] expected = {"Film1", "Film2", "Film3"};
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void MovieLimitEqual() {

        manager.addMovie("Film4");
        manager.addMovie("Film5");
        String[] actual = manager.findLast();
        String[] expected = {"Film5", "Film4", "Film3", "Film2", "Film1"};
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test

    public void MovieLimitSetup() {
        MovieManager manager = new MovieManager(10);
        manager.addMovie("Film1");
        manager.addMovie("Film2");
        manager.addMovie("Film3");
        manager.addMovie("Film4");
        manager.addMovie("Film5");
        manager.addMovie("Film6");
        manager.addMovie("Film7");
        manager.addMovie("Film8");
        manager.addMovie("Film9");
        manager.addMovie("Film10");
        String[] actual = manager.findLast();
        String[] expected = {"Film10", "Film9", "Film8", "Film7", "Film6", "Film5", "Film4", "Film3", "Film2", "Film1"};
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void MovieLimitBelow() {

        String[] expected = {"Film3", "Film2", "Film1"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void MovieLimitAbove() {
        manager.addMovie("Film4");
        manager.addMovie("Film5");
        manager.addMovie("Film6");
        manager.addMovie("Film7");
        manager.addMovie("Film8");
        manager.addMovie("Film9");
        String[] expected = {"Film9", "Film8", "Film7", "Film6", "Film5"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

}
