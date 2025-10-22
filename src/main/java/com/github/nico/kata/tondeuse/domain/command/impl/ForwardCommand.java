package com.github.nico.kata.tondeuse.domain.command.impl;

import com.github.nico.kata.tondeuse.domain.Lawnmower;
import com.github.nico.kata.tondeuse.domain.Orientation;
import com.github.nico.kata.tondeuse.domain.Coordinates;
import com.github.nico.kata.tondeuse.domain.command.LawnmowerCommand;

public class ForwardCommand implements LawnmowerCommand {

    private final int MAX_X;
    private final int MAX_Y;
    public ForwardCommand(Coordinates coordinates) {
        MAX_X = coordinates.get_x();
        MAX_Y =  coordinates.get_y();
    }

    @Override

    public Lawnmower doMove(final Lawnmower lawnmower) {
        Coordinates coordinates = lawnmower.getCoordinates();
        Orientation orientation = lawnmower.getOrientation();

        switch (orientation) {
            case EAST:
                if (coordinates.get_x() < MAX_X)
                    coordinates.updateX(1);
                break;
            case WEST:
                if (coordinates.get_x() > 0)
                    coordinates.updateX(-1);
                break;
            case NORTH:
                if (coordinates.get_y() < MAX_Y)
                    coordinates.updateY(1);
                break;
            case SOUTH:
                if (coordinates.get_y() > 0)
                    coordinates.updateY(-1);
                break;
            default: break;
        }

        lawnmower.updateState(coordinates,orientation);
        return lawnmower;
    }
}
