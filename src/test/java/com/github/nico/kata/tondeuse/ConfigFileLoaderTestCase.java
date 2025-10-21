package com.github.nico.kata.tondeuse;

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

        assertEquals(1, config.getLawnmowerCommands().size());
        //        Lawnmower lawnmower = new Lawnmower(new Position(1,2), Orientation.NORTH);
    }
}
