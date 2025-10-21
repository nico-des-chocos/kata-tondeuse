package com.github.nico.kata.tondeuse;

import java.util.Objects;

public class Position {
    private final int _x;
    private final int _y;
    public Position( final int x, final int y) {
        _x=x;
        _y=y;
    }

    public int get_x() { return _x; }
    public int get_y() { return _y; }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return _x == position._x && _y == position._y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(_x, _y);
    }
}
