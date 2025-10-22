package com.github.nico.kata.tondeuse.domain;

import java.util.Objects;

public class Coordinates {
    private  int _x;
    private  int _y;
    public Coordinates(final int x, final int y) {
        _x=x;
        _y=y;
    }

    public void updateX(int delta_x) {_x +=delta_x;}
    public void updateY(int delta_y) {_y +=delta_y;}

    public int get_x() { return _x; }
    public int get_y() { return _y; }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates coordinates = (Coordinates) o;
        return _x == coordinates._x && _y == coordinates._y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(_x, _y);
    }
}
