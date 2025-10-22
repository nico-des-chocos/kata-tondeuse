package com.github.nico.kata.tondeuse.adapters.input.main;

import com.github.nico.kata.tondeuse.adapters.input.ConfigLoader;
import com.github.nico.kata.tondeuse.domain.Coordinates;
import com.github.nico.kata.tondeuse.domain.Lawnmower;
import com.github.nico.kata.tondeuse.domain.command.LawnmowerCommand;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.InvalidPathException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ConfigFileLoaderImpl implements ConfigLoader {
    private  int _gardenWith;
    private  int _gardenHeight;

    private final ArrayList<Lawnmower> _lawnmowers = new ArrayList<>();

    private final ArrayList<ArrayList<LawnmowerCommand>> _commands = new ArrayList<>();

    private final CommandBuilder _commandBuilder;

    public ConfigFileLoaderImpl(CommandBuilder commandBuilder) {
        _commandBuilder = commandBuilder;
    }

    public void loadConfigFromFile(final String filePath) {
        try {
            Scanner scanner = new Scanner(new File(filePath));

            String line = scanner.nextLine();

            // First line is the garden's size
            String[] size = line.split(" ");
            _gardenWith = Integer.parseInt(size[0]);
            _gardenHeight =  Integer.parseInt(size[1]);


            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                String[] lawsmower_info = line.split(" ");
                _lawnmowers.add(new Lawnmower(new Coordinates(Integer.parseInt(lawsmower_info[0]),Integer.parseInt(lawsmower_info[1])), OrientationAdapter.valueOf(lawsmower_info[2])));

                line = scanner.nextLine();
                ArrayList<LawnmowerCommand> commands = new ArrayList<>();
                line.chars().forEach(c -> commands.add(_commandBuilder.getCommand(LawnmowerCommandType.valueOf(Character.toString(c)) )));
                commands.removeIf(Objects::isNull);
                _commands.add(commands);
            }


        } catch (FileNotFoundException e) {
            throw new InvalidPathException(filePath, e.getMessage());
        }
    }

    @Override
    public int getGardenWith() {
        return _gardenWith;
    }

    @Override
    public int getGardenHeight() {
        return _gardenHeight;
    }

    @Override
    public List<Lawnmower> getLawnmowers() {
        return new ArrayList<>(_lawnmowers);
    }

    @Override
    public List<List<LawnmowerCommand>> getLawnmowerCommands() {
        return new ArrayList<>(_commands);
    }

}
