package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    void firstPlayerWins() {
        Player monkey = new Player(45, "monkey", 86);
        Player lion = new Player(12,"lion",21);
        Game game = new Game();

        game.register(monkey);
        game.register(lion);

        int expected = 1;
        int actual = game.round("monkey","lion");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    void secondPlayerWins() {
        Player monkey = new Player(45, "monkey", 86);
        Player lion = new Player(12,"lion",125);
        Game game = new Game();

        game.register(monkey);
        game.register(lion);

        int expected = 2;
        int actual = game.round("monkey","lion");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    void drawPlay() {
        Player monkey = new Player(45, "monkey", 86);
        Player lion = new Player(12,"lion",86);
        Game game = new Game();

        game.register(monkey);
        game.register(lion);

        int expected = 0;
        int actual = game.round("monkey","lion");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    void firstPlayerNotFound() {
        Player monkey = new Player(45, "monkey", 86);
        Player lion = new Player(12,"lion",86);
        Game game = new Game();

        game.register(lion);
        game.register(monkey);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("tiger","lion"));

    }

    @Test
    void secondPlayerNotFound() {
        Player monkey = new Player(45, "monkey", 86);
        Player lion = new Player(12,"lion",86);
        Game game = new Game();

        game.register(lion);
        game.register(monkey);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("monkey","giraffe"));

    }


}