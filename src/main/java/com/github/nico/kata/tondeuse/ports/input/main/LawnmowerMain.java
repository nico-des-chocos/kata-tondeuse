package com.github.nico.kata.tondeuse.ports.input.main;

import com.github.nico.kata.tondeuse.adapters.input.ArgumentValidator;
import com.github.nico.kata.tondeuse.adapters.input.main.CommandBuilderImpl;
import com.github.nico.kata.tondeuse.adapters.input.main.ConfigFileLoaderImpl;
import com.github.nico.kata.tondeuse.adapters.input.main.FileArgumentValidator;
import com.github.nico.kata.tondeuse.domain.Lawnmower;
import com.github.nico.kata.tondeuse.domain.command.LawnmowerCommand;

import java.util.List;

public class LawnmowerMain {
    public static void main(String[] args) {
        // setup
        try {
            ArgumentValidator.validate(args);
            FileArgumentValidator.validate(args);

            CommandBuilderImpl commandBuilder = new CommandBuilderImpl();
            ConfigFileLoaderImpl fileLoader = new ConfigFileLoaderImpl(commandBuilder);
            commandBuilder.setConfigLoader(fileLoader);

            fileLoader.loadConfigFromFile(args[0]);

            List<Lawnmower> lawnmowers = fileLoader.getLawnmowers();
            List<List<LawnmowerCommand>> commands = fileLoader.getLawnmowerCommands();

            for(int i = 0; i < lawnmowers.size(); i++){
                Lawnmower lawnmower = lawnmowers.get(i);
                lawnmower.move(commands.get(i));
                System.out.println(lawnmower);
            }

        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }


    }



}
