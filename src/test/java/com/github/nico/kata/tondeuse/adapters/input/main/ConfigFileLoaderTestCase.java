package com.github.nico.kata.tondeuse.adapters.input.main;

import com.github.nico.kata.tondeuse.domain.*;
import com.github.nico.kata.tondeuse.domain.command.LawnmowerCommand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConfigFileLoaderTestCase {
    @Test
    public void loadGardenSize() {
        ConfigFileLoader config = new ConfigFileLoader("data/test/parcourt_simple_une_tondeuse.txt");

        assertEquals(5, config.getGardenWith());
        assertEquals(5, config.getGardenHeight());
    }

    @Test
    public void loadLawnmower() {
        ConfigFileLoader config = new ConfigFileLoader("data/test/parcourt_simple_une_tondeuse.txt");

        assertEquals(1, config.getLawnmowers().size());

        Lawnmower lawnmower = new Lawnmower(new Position(1,2), Orientation.NORTH);
    }

    @Test
    public void loadLawnmowerCommands() {
        ConfigFileLoader config = new ConfigFileLoader("data/test/parcourt_simple_une_tondeuse.txt");
        config.setCommandBuilder(new StubCommandBuilder());
        assertEquals(9, config.getLawnmowerCommands().size());
    }

    private class StubCommandBuilder implements CommandBuilder {

        @Override
        public LawnmowerCommand getCommand(LownmowerCommandType type) {
            return new LawnmowerCommand() {
                @Override
                public Lawnmower doMove(Lawnmower lawnmower) {
                    return lawnmower;
                }
            };
        }
    }

}
