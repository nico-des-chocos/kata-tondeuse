package com.github.nico.kata.tondeuse.ports.output.main;

import com.github.nico.kata.tondeuse.domain.Coordinates;
import com.github.nico.kata.tondeuse.domain.Lawnmower;

import java.io.*;
import java.util.Iterator;
import java.util.List;

public class OutPrintLawnmowerState {

    public static void printState(OutputStream outputStream, List<Lawnmower> lawnmowers) throws IOException {
        StringBuilder builder = new StringBuilder();
        Iterator<Lawnmower> it = lawnmowers.iterator();
        while (it.hasNext()) {
            Lawnmower lawnmower = it.next();
            Coordinates pos = lawnmower.getCoordinates();
            builder.append(pos.get_x());
            builder.append(" ");
            builder.append(pos.get_y());
            builder.append(" ");
            builder.append(lawnmower.getOrientation().toString().charAt(0));
            if (it.hasNext())
                builder.append(" ");
        }

        outputStream.write(builder.toString().getBytes());
        outputStream.flush();
    }
}
