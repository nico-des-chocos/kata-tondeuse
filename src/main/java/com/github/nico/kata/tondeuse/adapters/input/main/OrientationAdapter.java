package com.github.nico.kata.tondeuse.adapters.input.main;

import com.github.nico.kata.tondeuse.domain.Orientation;

public class OrientationAdapter {
    public static Orientation valueOf(String orientation) {
        switch (orientation) {
            case("N"):    return Orientation.NORTH;
            case ("E"):    return Orientation.EAST;
            case ("S"):    return Orientation.SOUTH;
            case ("W"):    return Orientation.WEST;
            default:throw new IllegalArgumentException();
        }
    }
}
