package com.github.nico.kata.tondeuse.adapters.input.main.validator;

import java.util.ArrayList;
import java.util.List;

public class FileContentError extends RuntimeException {

//    private
    private final List<FileError> errors = new ArrayList<>();


    public FileContentError() {
    }

    public boolean hasError() {
        return !errors.isEmpty();
    }

    public void addError(final int lineNumber, final String message) {
        errors.add(new FileError(lineNumber, message));
    }

    public List<FileError> getError() {
        return new ArrayList<>(errors);
    }
}
