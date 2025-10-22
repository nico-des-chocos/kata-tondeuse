package com.github.nico.kata.tondeuse.adapters.input.main;

import com.github.nico.kata.tondeuse.domain.Orientation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrientationAdapterTestCase {

    @Test
    void valueOfFromShort_N_For_North() {
        assertEquals(Orientation.NORTH, OrientationAdapter.valueOf("N"));
    }

    @Test
    void valueOfFromShort_S_For_South() {
        assertEquals(Orientation.SOUTH, OrientationAdapter.valueOf("S"));
    }

    @Test
    void valueOfFromShort_E_For_East() {
        assertEquals(Orientation.EAST, OrientationAdapter.valueOf("E"));
    }

    @Test
    void valueOfFromShort_E_For_West() {
        assertEquals(Orientation.WEST, OrientationAdapter.valueOf("W"));
    }
}