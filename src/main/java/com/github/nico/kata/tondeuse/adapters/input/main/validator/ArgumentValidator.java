package com.github.nico.kata.tondeuse.adapters.input.main.validator;

import java.io.File;

public class ArgumentValidator {
    public static void validate(String[] strings) {
        if (strings.length != 1) {
            throw new IllegalArgumentException(" Usage: java -jar ./target/kata-tondeuse-1.0.SNAPSHOT.jar <input-file>");
        }

        File file = new File(strings[0]);
        System.out.println("Fichier ? "+ file.getAbsolutePath());
        if (!file.exists()) {
            throw new IllegalArgumentException("Le fichier n'existe pas ou son chemin d'accès n'est pas bon");
        }
    }
}
