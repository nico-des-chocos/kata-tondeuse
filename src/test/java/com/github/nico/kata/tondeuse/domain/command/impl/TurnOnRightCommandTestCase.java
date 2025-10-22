package com.github.nico.kata.tondeuse.domain.command.impl;

import com.github.nico.kata.tondeuse.domain.Orientation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TurnOnRightCommandTestCase  extends CommandTestCaseToolBox {

    @BeforeEach
    void setUp() {
        _command = new TurnOnRightCommand();
    }

    @Test
    void turnOnRightFromEast() {
        assertTurnLawnmowerOn(Orientation.EAST, Orientation.SOUTH);
    }

    @Test
    void turnOnRightFromWest() {
        assertTurnLawnmowerOn(Orientation.WEST, Orientation.NORTH);
    }

    @Test
    void turnOnRightFromNorth() {
        assertTurnLawnmowerOn(Orientation.NORTH, Orientation.EAST);
    }

    @Test
    void turnOnRightFromSouth() {
        assertTurnLawnmowerOn(Orientation.SOUTH, Orientation.WEST);
    }

}