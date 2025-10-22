package com.github.nico.kata.tondeuse.adapters.input.main;

import com.github.nico.kata.tondeuse.adapters.input.ConfigLoader;
import com.github.nico.kata.tondeuse.domain.Coordinates;
import com.github.nico.kata.tondeuse.domain.command.LawnmowerCommand;
import com.github.nico.kata.tondeuse.domain.command.impl.ForwardCommand;

public class CommandBuilderImpl implements CommandBuilder {

    private ConfigLoader _configFileLoader;


    @Override
    public LawnmowerCommand getCommand(LawnmowerCommandType type) {
        switch (type) {
            case A:
                return new ForwardCommand(new Coordinates(_configFileLoader.getGardenWith(), _configFileLoader.getGardenHeight()));
            case G:
                break;
            case D:
                break;
        }
        return null;
    }

    public void setConfigLoader(ConfigLoader configFileLoader) {
        _configFileLoader = configFileLoader;
    }
}
