package com.github.nico.kata.tondeuse;

import java.io.File;

public class ArgumentValidator {
    public static boolean validate(String[] strings) {
        if (strings.length != 1) {
            throw new IllegalArgumentException("Absence d'argument");
        }

        File file = new File(strings[0]);
        System.out.println("Fichier ? "+ file.getAbsolutePath());
        if (!file.exists()) {
            throw new IllegalArgumentException("Le fichier n'existe pas ou son chemin d'accès n'est pas bon");
        }

        return Boolean.TRUE;
    }
}
