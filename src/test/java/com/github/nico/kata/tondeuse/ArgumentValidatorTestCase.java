package com.github.nico.kata.tondeuse;


import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArgumentValidatorTestCase {
    @Test
    public void aucunArgument() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ArgumentValidator.validate(new String[]{});
        });
    }
}
