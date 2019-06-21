package org.academiadecodigo.whiledlings.badpotatoes.worldelements;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.whiledlings.badpotatoes.controls.DirectionType;

public class Block {

    private Picture background;

    private int X;
    private int Y;
    private boolean drawn;


    public Block(int x, int y, String backgroundPath) {
        this.X = x;
        this.Y = y;
        this.background = new Picture(x, y, backgroundPath);
    }

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public int getY() {
        return Y;
    }

    public void drawBlock() {
        background.draw();
    }

    public boolean isDrawn() {
        return drawn;
    }

    public void setDrawn(boolean drawn) {
        this.drawn = drawn;
    }

    public void moveTo(int x) {
        this.X = x;
    }

    public void move(DirectionType direction, Rectangle newBg) throws InterruptedException {

        switch (direction) {
            case LEFT:
                X -= 32;
                if (X + 1 <= (newBg.getWidth() - 32)) {
                    if (!isDrawn()) {
                        background.draw(); // 800 - 32  768@DRAW
                        background.translate(0, 0);
                        setDrawn(true);
                        break;
                    }
                }
                background.translate(-9, 0);
                break;
            case RIGHT:
                X += 32; // X = 1000 - drawFALSE
                if (X >= (newBg.getWidth() - 32)) {
                    if (isDrawn()) {
                        background.delete();
                        setDrawn(false);
                        break;
                    }
                }
                background.translate(9, 0);
                break;
        }
    }

    public void delete() {
        background.delete();
    }

    public Picture getBackground() {
        return background;
    }
}

