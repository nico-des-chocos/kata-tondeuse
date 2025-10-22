package com.github.nico.kata.tondeuse.domain;

import com.github.nico.kata.tondeuse.domain.command.LawnmowerCommand;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LawnmowerTestCase {

    @Test
    public void move_lawnmower() {
        Lawnmower lawnmower = new Lawnmower(new Coordinates(0,0), Orientation.EAST);
        Lawnmower expected = new Lawnmower(new Coordinates(0,1), Orientation.EAST);

        ArrayList<LawnmowerCommand> lawnmowerCommands = new ArrayList<>();
        lawnmowerCommands.add(new StubLawnmowerCommand(expected));
        lawnmower.move(lawnmowerCommands);

        assertEquals(expected, lawnmower);
    }

    private static class StubLawnmowerCommand implements LawnmowerCommand {
        Lawnmower _lawnmower_expected;
        public StubLawnmowerCommand(Lawnmower lawnmower_expected) {
            _lawnmower_expected= lawnmower_expected;
        }

        @Override
        public Lawnmower doMove(Lawnmower lawnmower) {
            lawnmower.updateState(_lawnmower_expected.getCoordinates(), _lawnmower_expected.getOrientation());
            return lawnmower;
        }
    }

}