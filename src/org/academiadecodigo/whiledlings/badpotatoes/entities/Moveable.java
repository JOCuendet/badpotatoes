package org.academiadecodigo.whiledlings.badpotatoes.entities;

import org.academiadecodigo.whiledlings.badpotatoes.controls.DirectionType;

public interface Moveable {

    void move(DirectionType direction, int playerSpeed) throws InterruptedException;
}
