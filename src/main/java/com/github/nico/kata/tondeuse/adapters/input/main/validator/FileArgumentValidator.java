package com.github.nico.kata.tondeuse.adapters.input.main.validator;

import java.io.File;

public class FileArgumentValidator {
    public static boolean validate(String[] args) {
        File file = new File(args[0]);

        if (!file.exists()) {
            throw new IllegalArgumentException("Le fichier n'existe pas ou son chemin d'accès n'est pas bon");
        }

        return Boolean.TRUE;
    }
}
