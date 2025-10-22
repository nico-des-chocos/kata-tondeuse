package com.github.nico.kata.tondeuse.adapters.input.main;


import com.github.nico.kata.tondeuse.adapters.input.ArgumentValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArgumentValidatorTestCase {
    @Test
    public void aucunArgument() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ArgumentValidator.validate(new String[]{});
        });
    }
}
