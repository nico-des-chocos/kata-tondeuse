package com.github.nico.kata.tondeuse.domain;

import com.github.nico.kata.tondeuse.domain.command.LawnmowerCommand;

import java.util.ArrayList;
import java.util.Objects;

public class Lawnmower {
    private  Position _position;
    private  Orientation _orientation;

    public Lawnmower(final Position pos, final Orientation orientation) {
        updateState(pos, orientation);
    }

    public void move(ArrayList<LawnmowerCommand> lawnmowerCommands) {
        lawnmowerCommands.forEach(lawnmowerCommand -> lawnmowerCommand.doMove(this));
    }

    public Position getPosition() {return _position;}
    public Orientation getOrientation() {return _orientation;}

    public void updateState(Position position, Orientation orientation) {
        _position = position;
        _orientation=orientation;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Lawnmower lawnmower = (Lawnmower) o;
        return Objects.equals(_position, lawnmower._position) && _orientation == lawnmower._orientation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(_position, _orientation);
    }
}
