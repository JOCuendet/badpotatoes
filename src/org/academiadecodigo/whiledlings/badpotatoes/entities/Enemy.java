package org.academiadecodigo.whiledlings.badpotatoes.entities;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.whiledlings.badpotatoes.controls.DirectionType;

public abstract class Enemy implements Moveable {
    protected Rectangle background;
    DirectionType direction;
    int health;
    private DirectionType oldDirection;
    private int X;
    private int Y;

    Enemy(int x, int y) {
        X = x;
        Y = y;
        this.direction = DirectionType.IDLERIGHT;
        this.oldDirection = DirectionType.IDLERIGHT;
    }

    public abstract void move(DirectionType direction, int playerSpeed) throws InterruptedException;
}


