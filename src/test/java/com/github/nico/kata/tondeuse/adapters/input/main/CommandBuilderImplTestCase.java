package com.github.nico.kata.tondeuse.adapters.input.main;

import com.github.nico.kata.tondeuse.adapters.input.ConfigLoader;
import com.github.nico.kata.tondeuse.domain.Lawnmower;
import com.github.nico.kata.tondeuse.domain.command.LawnmowerCommand;
import com.github.nico.kata.tondeuse.domain.command.impl.ForwardCommand;
import com.github.nico.kata.tondeuse.domain.command.impl.TurnOnLeftCommand;
import com.github.nico.kata.tondeuse.domain.command.impl.TurnOnRightCommand;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CommandBuilderImplTestCase {
    private static CommandBuilderImpl commandBuilder = new CommandBuilderImpl();

    @BeforeAll
    static void loadConfig() {
        commandBuilder = new CommandBuilderImpl();
        commandBuilder.setConfigLoader(new ConfigLoader() {
            @Override
            public int getGardenWith() {
                return 0;
            }

            @Override
            public int getGardenHeight() {
                return 0;
            }

            @Override
            public List<Lawnmower> getLawnmowers() {
                return new ArrayList<>();
            }

            @Override
            public ArrayList<List<LawnmowerCommand>> getLawnmowerCommands() {
                return new ArrayList<>();
            }
        });
    }

    @Test
    void getForwardCommand() {
        assertEquals(ForwardCommand.class, commandBuilder.getCommand(LawnmowerCommandType.A).getClass());
    }

    @Test
    void getTurnOnLeftCommand() {
        assertEquals(TurnOnLeftCommand.class, commandBuilder.getCommand(LawnmowerCommandType.G).getClass());
    }
    @Test
    void getTurnOnRightCommand() {
        assertEquals(TurnOnRightCommand.class, commandBuilder.getCommand(LawnmowerCommandType.D).getClass());
    }
}