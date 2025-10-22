package com.github.nico.kata.tondeuse.domain.command.impl;

import com.github.nico.kata.tondeuse.domain.Coordinates;
import com.github.nico.kata.tondeuse.domain.Lawnmower;
import com.github.nico.kata.tondeuse.domain.Orientation;
import com.github.nico.kata.tondeuse.domain.command.LawnmowerCommand;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandTestCaseToolBox {

    LawnmowerCommand _command;

    public void assertTurnLawnmowerOn(Orientation west, Orientation south) {
        Lawnmower lawnmower = _command.doMove(new Lawnmower(new Coordinates(5, 5), west));
        assertEquals(south, lawnmower.getOrientation());
    }
}
