package com.github.nico.kata.tondeuse.domain.command.impl;

import com.github.nico.kata.tondeuse.domain.Lawnmower;
import com.github.nico.kata.tondeuse.domain.Orientation;
import com.github.nico.kata.tondeuse.domain.Coordinates;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ForwardCommandTestCase {

    private static final int BORDER_X = 3;
    private static final int BORDER_Y = 3;

    @Test
    public void move_to_east_without_stoper_wall() {
        assertFowardCommandWithMove(Orientation.EAST, 3, 2);
    }

    @Test
    public void move_to_north_without_stoper_wall() {
        assertFowardCommandWithMove(Orientation.NORTH, 2, 3);
    }

    @Test
    public void move_to_west_without_stoper_wall() {
        assertFowardCommandWithMove(Orientation.WEST, 1, 2);
    }

    @Test
    public void move_to_south_without_stoper_wall() {
        assertFowardCommandWithMove(Orientation.SOUTH, 2, 1);
    }
    @Test
    public void move_to_south_with_stoper_wall() {
        assertFowardCommandWithoutMove(Orientation.SOUTH, 2,0);
    }

    @Test
    public void move_to_west_with_stoper_wall() {
        assertFowardCommandWithoutMove(Orientation.WEST, 0,2);
    }

    @Test
    public void move_to_east_with_stoper_wall() {
        assertFowardCommandWithoutMove(Orientation.EAST, BORDER_X,2);
    }

    @Test
    public void move_to_north_with_stoper_wall() {
        assertFowardCommandWithoutMove(Orientation.NORTH, 2,BORDER_Y);
    }

    private static void assertFowardCommandWithMove(Orientation orientation, int x, int y) {
        assertForwardCommand(orientation, x, y, new Lawnmower(new Coordinates(BORDER_X-1, BORDER_Y-1), orientation));
    }

    private static void assertFowardCommandWithoutMove(Orientation orientation, int x, int y) {
        assertForwardCommand(orientation, x, y, new Lawnmower(new Coordinates(x, y), orientation));
    }

    private static void assertForwardCommand(Orientation east, int x, int y, Lawnmower lawnmower) {
        ForwardCommand forwardCommand = new ForwardCommand(new Coordinates (BORDER_X,BORDER_Y));
        forwardCommand.doMove(lawnmower);
        assertEquals(new Lawnmower(new Coordinates(x, y), east), lawnmower);
    }
}