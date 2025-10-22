package com.github.nico.kata.tondeuse.ports.output.main;

import com.github.nico.kata.tondeuse.domain.Coordinates;
import com.github.nico.kata.tondeuse.domain.Lawnmower;
import com.github.nico.kata.tondeuse.domain.Orientation;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class OutPrintLawnmowerStateTestCase {

    @Test
    void print_for_one_lawnmower_on_east_orientation() throws IOException {

        ArrayList<Lawnmower> lawnmowers = new ArrayList<>();
        lawnmowers.add(new Lawnmower(new Coordinates(1,2), Orientation.EAST));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        OutPrintLawnmowerState.printState(outputStream, lawnmowers);
        assertEquals("1 2 E",  outputStream.toString());
    }

    @Test
    void print_for_for_lawnmower_all_orientation() throws IOException {

        ArrayList<Lawnmower> lawnmowers = new ArrayList<>();
        Coordinates coordinates = new Coordinates(1,1);
        lawnmowers.add(new Lawnmower(coordinates, Orientation.EAST));
        lawnmowers.add(new Lawnmower(coordinates, Orientation.WEST));
        lawnmowers.add(new Lawnmower(coordinates, Orientation.NORTH));
        lawnmowers.add(new Lawnmower(coordinates, Orientation.SOUTH));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        OutPrintLawnmowerState.printState(outputStream, lawnmowers);
        assertEquals("1 1 E 1 1 W 1 1 N 1 1 S",  outputStream.toString());
    }
}