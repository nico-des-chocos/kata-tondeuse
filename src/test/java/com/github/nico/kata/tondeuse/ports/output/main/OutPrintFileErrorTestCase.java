package com.github.nico.kata.tondeuse.ports.output.main;

import com.github.nico.kata.tondeuse.adapters.input.main.validator.FileContentError;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class OutPrintFileErrorTestCase {

    @Test
    void printErrors() throws IOException {
        FileContentError fileContentError = new FileContentError();
        fileContentError.addError(1, "message");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        OutPrintFileError.printErrors(outputStream, fileContentError);
        assertEquals("Errors founds on input file : \n1 - message\n",  outputStream.toString());
    }
}