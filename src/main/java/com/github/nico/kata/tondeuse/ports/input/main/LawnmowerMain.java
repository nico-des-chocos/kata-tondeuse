package com.github.nico.kata.tondeuse.ports.input.main;

import com.github.nico.kata.tondeuse.adapters.input.main.validator.ArgumentValidator;
import com.github.nico.kata.tondeuse.adapters.input.main.CommandBuilderImpl;
import com.github.nico.kata.tondeuse.adapters.input.main.ConfigFileLoaderImpl;
import com.github.nico.kata.tondeuse.adapters.input.main.validator.FileArgumentValidator;
import com.github.nico.kata.tondeuse.adapters.input.main.validator.FileContentError;
import com.github.nico.kata.tondeuse.adapters.input.main.validator.FileContentValidator;
import com.github.nico.kata.tondeuse.domain.Lawnmower;
import com.github.nico.kata.tondeuse.domain.command.LawnmowerCommand;
import com.github.nico.kata.tondeuse.ports.output.main.OutPrintFileError;
import com.github.nico.kata.tondeuse.ports.output.main.OutPrintLawnmowerState;

import java.io.IOException;
import java.util.List;

public class LawnmowerMain {
    public static void main(String[] args) {
        // setup
        try {
            ArgumentValidator.validate(args);
            FileArgumentValidator.validate(args);
            new FileContentValidator().validate(args[0]);

            CommandBuilderImpl commandBuilder = new CommandBuilderImpl();
            ConfigFileLoaderImpl fileLoader = new ConfigFileLoaderImpl(commandBuilder);
            commandBuilder.setConfigLoader(fileLoader);

            fileLoader.loadConfigFromFile(args[0]);

            List<Lawnmower> lawnmowers = fileLoader.getLawnmowers();
            List<List<LawnmowerCommand>> commands = fileLoader.getLawnmowerCommands();

            for(int i = 0; i < lawnmowers.size(); i++){
                Lawnmower lawnmower = lawnmowers.get(i);
                lawnmower.move(commands.get(i));
            }

            OutPrintLawnmowerState.printState(System.out, lawnmowers);
            System.exit(0);

        } catch (IllegalArgumentException | IOException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        } catch (FileContentError e) {
            try {
                OutPrintFileError.printErrors(System.err, e);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            System.exit(1);
        }
    }
}
