package com.github.nico.kata.tondeuse.domain.command;

import com.github.nico.kata.tondeuse.domain.Lawnmower;

public interface LawnmowerCommand {
    Lawnmower doMove(Lawnmower lawnmower);
}
