package com.github.nico.kata.tondeuse.adapters.input;

import com.github.nico.kata.tondeuse.domain.Lawnmower;
import com.github.nico.kata.tondeuse.domain.command.LawnmowerCommand;

import java.util.List;

public interface ConfigLoader {
    int getGardenWith();

    int getGardenHeight();

    List<Lawnmower> getLawnmowers();

    List<List<LawnmowerCommand>> getLawnmowerCommands();
}
