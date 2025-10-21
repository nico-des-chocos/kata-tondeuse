package com.github.nico.kata.tondeuse;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrientationTestCase {

    @Test
    void valueOfFromShort_N_For_North() {
        assertEquals(Orientation.NORTH, Orientation.valueOfFromShort("N"));
    }

    @Test
    void valueOfFromShort_S_For_South() {
        assertEquals(Orientation.SOUTH, Orientation.valueOfFromShort("S"));
    }

    @Test
    void valueOfFromShort_E_For_East() {
        assertEquals(Orientation.EAST, Orientation.valueOfFromShort("E"));
    }

    @Test
    void valueOfFromShort_E_For_West() {
        assertEquals(Orientation.WEST, Orientation.valueOfFromShort("W"));
    }
}