package com.github.nico.kata.tondeuse.adapters.input.main.validator;

public class FileError {
    private final String _message ;
    private final int _lineNumber;

    public FileError (final int lineNumber, final String message) {
            _message = message;
            _lineNumber = lineNumber;
    }

    @Override
    public String toString() {
        return _lineNumber + " - " + _message ;
    }


}
