package com.github.nico.kata.tondeuse.adapters.input.main.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FileContentValidatorTestCase {

    @Test
    void content_is_trunked_no_command_for_lawnmower() {
        assertThrows(FileContentError.class, () -> (new FileContentValidator()).validate("data/test/test_trunckated.txt"));
    }

    @Test
    void content_no_lawnmower() {
        assertThrows(FileContentError.class, () -> (new FileContentValidator()).validate("data/test/test_no_lawmower.txt"));
    }

    @Test
    void content_first_line_contains_letter() {
        assertThrows(FileContentError.class, () -> (new FileContentValidator()).validate("data/test/test_first_line_contains_letter.txt"));
    }

    @Test
    void content_empty() {
        assertThrows(FileContentError.class, () -> (new FileContentValidator()).validate("data/test/test_content_empty.txt"));
    }

    @Test
    void content_is_valid() {
        assertDoesNotThrow(() -> (new FileContentValidator()).validate("data/test/test_valid.txt"));
    }

    @Test
    void content_new_command() {
        assertThrows(FileContentError.class, () -> (new FileContentValidator()).validate("data/test/test_new_command.txt"));
    }

    @Test
    void content_bad_orientation() {
        assertThrows(FileContentError.class, () -> (new FileContentValidator()).validate("data/test/test_bad_orientation.txt"));
    }

    @Test
    void content_bad_coordonate_for_lawnmower() {
        assertThrows(FileContentError.class, () -> (new FileContentValidator()).validate("data/test/test_bad_coordonate_for_lawnmower.txt"));
    }

}
