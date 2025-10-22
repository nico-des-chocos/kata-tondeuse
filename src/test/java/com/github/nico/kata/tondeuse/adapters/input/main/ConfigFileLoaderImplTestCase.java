package com.github.nico.kata.tondeuse.adapters.input.main;

import com.github.nico.kata.tondeuse.domain.*;
import com.github.nico.kata.tondeuse.domain.command.LawnmowerCommand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConfigFileLoaderImplTestCase {
    @Test
    public void loadGardenSize() {
        ConfigFileLoaderImpl config = getConfigFileLoaderForOneLawnmower();

        assertEquals(5, config.getGardenWith());
        assertEquals(5, config.getGardenHeight());
    }

    @Test
    public void loadLawnmower() {
        ConfigFileLoaderImpl config = getConfigFileLoaderForOneLawnmower();
        assertEquals(1, config.getLawnmowers().size());
        Lawnmower lawnmower = new Lawnmower(new Coordinates(1,2), Orientation.NORTH);
        assertEquals(lawnmower,  config.getLawnmowers().get(0));
    }

    @Test
    public void loadLawnmowerCommands() {
        ConfigFileLoaderImpl config = getConfigFileLoaderForOneLawnmower();
        assertEquals(1, config.getLawnmowerCommands().size());
    }

    private ConfigFileLoaderImpl getConfigFileLoaderForOneLawnmower() {
        return getConfigFileLoader("data/test/parcourt_simple_une_tondeuse.txt");
    }

    private ConfigFileLoaderImpl getConfigFileLoader(String filePath) {
        ConfigFileLoaderImpl config = new ConfigFileLoaderImpl(new StubCommandBuilder());
        config.loadConfigFromFile(filePath);
        return config;
    }

    private static class StubCommandBuilder implements CommandBuilder {

        @Override
        public LawnmowerCommand getCommand(final LawnmowerCommandType type) {
            return lawnmower -> lawnmower;
        }
    }

}
