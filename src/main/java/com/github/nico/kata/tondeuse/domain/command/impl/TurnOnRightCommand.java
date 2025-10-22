package com.github.nico.kata.tondeuse.domain.command.impl;

import com.github.nico.kata.tondeuse.domain.Coordinates;
import com.github.nico.kata.tondeuse.domain.Lawnmower;
import com.github.nico.kata.tondeuse.domain.Orientation;
import com.github.nico.kata.tondeuse.domain.command.LawnmowerCommand;

public class TurnOnRightCommand implements LawnmowerCommand {
    @Override
    public Lawnmower doMove(Lawnmower lawnmower) {
        Coordinates pos = lawnmower.getCoordinates();
        switch (lawnmower.getOrientation()) {
            case NORTH: lawnmower.updateState(pos, Orientation.EAST);break;
            case WEST: lawnmower.updateState(pos, Orientation.NORTH);break;
            case SOUTH: lawnmower.updateState(pos, Orientation.WEST);break;
            case EAST: lawnmower.updateState(pos, Orientation.SOUTH);break;
        }

        return lawnmower;
    }
}
