package com.github.nico.kata.tondeuse.adapters.input.main;

import java.io.File;

public class FileArgumentValidator {
    public static boolean validate(String[] strings) {
        File file = new File(strings[0]);

        if (!file.exists()) {
            throw new IllegalArgumentException("Le fichier n'existe pas ou son chemin d'accès n'est pas bon");
        }

        return Boolean.TRUE;
    }
}
