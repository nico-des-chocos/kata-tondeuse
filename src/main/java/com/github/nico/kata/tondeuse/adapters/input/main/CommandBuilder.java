package com.github.nico.kata.tondeuse.adapters.input.main;

import com.github.nico.kata.tondeuse.domain.command.LawnmowerCommand;

public interface CommandBuilder {
    LawnmowerCommand getCommand(LawnmowerCommandType type);
}
