package com.github.nico.kata.tondeuse;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.InvalidPathException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class ConfigFileLoader {
    private final int _gardenWith;
    private final int _gardenHeight;

    private final ArrayList<Lawnmower> _lawnmowers = new ArrayList<>();

    public ConfigFileLoader(final String filePath) {
        try {
            Scanner scanner = new Scanner(new File(filePath));

            String line = scanner.nextLine();

            // First line is the garden's size
            String[] size = line.split(" ");
            _gardenWith = Integer.parseInt(size[0]);
            _gardenHeight =  Integer.parseInt(size[1]);

            // Second line First Lawsmower
            line = scanner.nextLine();
            String[] lawsmower_info = line.split(" ");
            _lawnmowers.add(new Lawnmower(new Position(Integer.parseInt(lawsmower_info[0]),Integer.parseInt(lawsmower_info[1])), Orientation.valueOfFromShort(lawsmower_info[2])));


            // Third line command for the first Lawsmower
            line = scanner.nextLine();


        } catch (FileNotFoundException e) {
            throw new InvalidPathException(filePath, e.getMessage());
        }
    }

    public int getGardenWith() {
        return _gardenWith;
    }

    public int getGardenHeight() {
        return _gardenHeight;
    }

    public List<Lawnmower> getLawnmowers() {
        return new ArrayList<>(_lawnmowers);
    }

    public List<LawnmowerCommand> getLawnmowerCommands() {
        return new ArrayList<>();
    }
}
