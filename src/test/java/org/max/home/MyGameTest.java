package org.max.home;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class MyGameTest {
    Game game;
    List<Door> doors;
    Player player;


    @BeforeEach
    void initialDoors() {
        doors = new ArrayList<>();
        doors.add(new Door(false));
        doors.add(new Door(false));
        doors.add(new Door(true));
    }

    @Test
    void testRoundNotRiskLoss() {
        //given
        player = new Player("Player", false);
        game = new Game(player, doors);
        //when
        boolean res = game.round(1).isPrize();
        //then
        Assertions.assertEquals(3, doors.size());
        Assertions.assertFalse(res);

    }

    @Test
    void testRoundNotRiskWin() {
        //given
        player = new Player("Player", false);
        game = new Game(player, doors);
        //when
        boolean res = game.round(2).isPrize();
        //then
        Assertions.assertEquals(3, doors.size());
        Assertions.assertTrue(res);
    }

    @Test
    void testRoundRiskLoss() {
        //given
        player = new Player("Player", true);
        game = new Game(player, doors);
        //when
        boolean res = game.round(2).isPrize();
        //then
        Assertions.assertEquals(2, doors.size());
        Assertions.assertFalse(res);
    }

    @Test
    void testRoundRiskWin() {
        //given
        player = new Player("Player", true);
        game = new Game(player, doors);
        //when
        boolean res = game.round(1).isPrize();
        //then
        Assertions.assertEquals(2, doors.size());
        Assertions.assertTrue(res);
    }
}