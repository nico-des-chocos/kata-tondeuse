package com.github.nico.kata.tondeuse.adapters.input.main.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileArgumentValidatorTestCase {

    @Test
    public void fichierInexistant() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> FileArgumentValidator.validate(new String[]{"fichier_inexistant.txt"}));
    }

    @Test
    public void fichierExistant() {
        assertTrue(FileArgumentValidator.validate(new String[]{"data/test/parcourt_simple_une_tondeuse.txt"}));
    }
}
