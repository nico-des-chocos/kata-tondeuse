package com.github.nico.kata.tondeuse;

public enum Orientation {
    NORTH, SOUTH, EAST, WEST;

    public static Orientation valueOfFromShort(final String orientation) {
        switch (orientation) {
            case("N"):    return NORTH;
            case ("E"):    return EAST;
            case ("S"):    return SOUTH;
            case ("W"):    return WEST;
            default:throw new IllegalArgumentException();
        }

    }
}
