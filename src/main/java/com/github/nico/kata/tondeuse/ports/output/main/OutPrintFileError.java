package com.github.nico.kata.tondeuse.ports.output.main;

import com.github.nico.kata.tondeuse.adapters.input.main.validator.FileContentError;
import com.github.nico.kata.tondeuse.adapters.input.main.validator.FileError;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;

public class OutPrintFileError {
    public static void printErrors(OutputStream outputStream, FileContentError e) throws IOException {
        StringBuilder builder = new StringBuilder();
        Iterator<FileError> it = e.getError().iterator();
        builder.append("Errors founds on input file : \n");
        while (it.hasNext()) {
            FileError err = it.next();
            builder.append(err.toString());
            builder.append("\n");
        }

        outputStream.write(builder.toString().getBytes());
        outputStream.flush();
    }
}
