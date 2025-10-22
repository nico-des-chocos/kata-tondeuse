package com.github.nico.kata.tondeuse.domain;

import com.github.nico.kata.tondeuse.domain.command.LawnmowerCommand;

import java.util.List;
import java.util.Objects;

public class Lawnmower {
    private Coordinates _coordinates;
    private  Orientation _orientation;

    public Lawnmower(final Coordinates pos, final Orientation orientation) {
        updateState(pos, orientation);
    }

    public void move(List<LawnmowerCommand> lawnmowerCommands) {
        lawnmowerCommands.forEach(lawnmowerCommand -> lawnmowerCommand.doMove(this));
    }

    public Coordinates getCoordinates() {return _coordinates;}
    public Orientation getOrientation() {return _orientation;}

    public void updateState(Coordinates coordinates, Orientation orientation) {
        _coordinates = coordinates;
        _orientation=orientation;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Lawnmower lawnmower = (Lawnmower) o;
        return Objects.equals(_coordinates, lawnmower._coordinates) && _orientation == lawnmower._orientation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(_coordinates, _orientation);
    }

    @Override
    public String toString() {
        return _coordinates.get_x() + " " + _coordinates.get_y() + " " + _orientation;
    }
}
