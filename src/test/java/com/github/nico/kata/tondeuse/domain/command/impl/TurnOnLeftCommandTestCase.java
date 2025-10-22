package com.github.nico.kata.tondeuse.domain.command.impl;

import com.github.nico.kata.tondeuse.domain.Orientation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TurnOnLeftCommandTestCase extends CommandTestCaseToolBox {

    @BeforeEach
    void setUp() {
        _command = new TurnOnLeftCommand();
    }

    @Test
    void turnOnLeftFromEast() {
        assertTurnLawnmowerOn(Orientation.EAST, Orientation.NORTH);
    }

    @Test
    void turnOnLeftFromWest() {
        assertTurnLawnmowerOn(Orientation.WEST, Orientation.SOUTH);
    }

    @Test
    void turnOnLeftFromNorth() {
        assertTurnLawnmowerOn(Orientation.NORTH, Orientation.WEST);
    }

    @Test
    void turnOnLeftFromSouth() {
        assertTurnLawnmowerOn(Orientation.SOUTH, Orientation.EAST);
    }
}