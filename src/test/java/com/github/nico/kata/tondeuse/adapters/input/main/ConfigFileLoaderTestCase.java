package com.github.nico.kata.tondeuse.adapters.input.main;

import com.github.nico.kata.tondeuse.domain.*;
import com.github.nico.kata.tondeuse.domain.command.LawnmowerCommand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConfigFileLoaderTestCase {
    @Test
    public void loadGardenSize() {
        ConfigFileLoader config = getConfigFileLoaderForOneLanmower();

        assertEquals(5, config.getGardenWith());
        assertEquals(5, config.getGardenHeight());
    }

    @Test
    public void loadLawnmower() {
        ConfigFileLoader config = getConfigFileLoaderForOneLanmower();
        assertEquals(1, config.getLawnmowers().size());
        Lawnmower lawnmower = new Lawnmower(new Position(1,2), Orientation.NORTH);
    }

    @Test
    public void loadLawnmowerCommands() {
        ConfigFileLoader config = getConfigFileLoaderForOneLanmower();
        assertEquals(1, config.getLawnmowerCommands().size());
    }

    private ConfigFileLoader getConfigFileLoaderForOneLanmower() {
        return getConfigFileLoader("data/test/parcourt_simple_une_tondeuse.txt");
    }

    private ConfigFileLoader getConfigFileLoader(String filePath) {
        ConfigFileLoader config = new ConfigFileLoader(new StubCommandBuilder());
        config.loadConfigFromFile(filePath);
        return config;
    }

    private static class StubCommandBuilder implements CommandBuilder {

        @Override
        public LawnmowerCommand getCommand(final LownmowerCommandType type) {
            return new LawnmowerCommand() {
                @Override
                public Lawnmower doMove(final Lawnmower lawnmower) {
                    return lawnmower;
                }
            };
        }
    }

}
