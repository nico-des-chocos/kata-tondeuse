package com.github.nico.kata.tondeuse.adapters.input.main.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileArgumentValidatorTestCase {

    @Test
    public void fichierInexistant() {
        assertThrows(IllegalArgumentException.class, () -> FileArgumentValidator.validate(new String[]{"fichier_inexistant.txt"}));
    }

    @Test
    public void fichierExistant() {
        assertTrue(FileArgumentValidator.validate(new String[]{"data/test/test_one_lawnmower.txt"}));
    }
}
