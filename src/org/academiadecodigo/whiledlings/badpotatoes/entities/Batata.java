package org.academiadecodigo.whiledlings.badpotatoes.entities;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.whiledlings.badpotatoes.Utility;
import org.academiadecodigo.whiledlings.badpotatoes.controls.DirectionType;

public class Batata extends Enemy implements Moveable {

    private final Player player;
    private final int movementSpeed;
    private int X;
    private int Y;
    private boolean drawn;
    private boolean dead;
    private Rectangle newBg;
    private Picture background;
    private int switcherInt = 1;
    private int switcherDelay = 1;
    private int pictureX;
    private int random = Utility.getRandomInt(50, 40);
    private int deadTimer = 0;
    private boolean counted;

    public Batata(int x, int y, Rectangle newBg, int movementSpeed, Player player) {

        super(x, y);
        this.counted = false;
        this.dead = false;

        this.player = player;
        this.movementSpeed = movementSpeed;

        this.X = x;
        this.Y = y;

        health = 1; // 3 hits

        this.background = new Picture(x, y, "./resources/enemy/batata/Batata_0.png");
        pictureX = background.getX();

        this.newBg = newBg;
        drawn = false;

        background.delete();
    }

    public boolean isCounted() {
        return counted;
    }

    public void setCounted() {
        this.counted = true;
    }

    public boolean isDrawn() {
        return drawn;
    }

    public void setDrawn(boolean drawn) {
        this.drawn = drawn;
    }

    public boolean isDead() {
        return dead;
    }

    public void moveAuto() {


        try {
            Thread.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int changeDirectionChance = Utility.getRandomInt(10, 1);
        int changeOrStaySameDirection = Utility.getRandomInt(100, 1);

        direction = (changeOrStaySameDirection > changeDirectionChance) ? DirectionType.LEFT : DirectionType.RIGHT;
        switchPic();

        switch (direction) {
            case LEFT:
                moveLeft(movementSpeed);
                break;
            default:
                moveRight(movementSpeed);
                break;
        }

    }

    private void switchPic() {

        if (switcherDelay > random) {
            switcherInt = switcherInt == 1 ? 2 : 1;
            random = Utility.getRandomInt(50, 40);
            switcherDelay = 0;
        }
        switcherDelay++;

        if (switcherInt == 1) {
            this.background.load("./resources/enemy/batata/Batata_0.png");

        }
        if (switcherInt == 2) {
            this.background.load("./resources/enemy/batata/Batata_1.png");
        }
    }

    @Override
    public void move(DirectionType direction, int playerSpeed) {

        switch (direction) {
            case LEFT:
                moveLeft(playerSpeed);
                break;
            case RIGHT:
                moveRight(playerSpeed);
                break;
        }

    }

    public int getPictureX() {
        return pictureX;
    }

    public void moveRight(int movementSpeed) {

        pictureX += movementSpeed; // X = 1000 - drawFALSE
        if (pictureX >= (newBg.getWidth()) - 169) {
            if (isDrawn()) {
                background.delete();
                setDrawn(false);
                return;
            }
        }
        background.translate(movementSpeed, 0);
    }

    public void moveLeft(int movementSpeed) {
        pictureX -= movementSpeed;
        if (pictureX + 1 <= (newBg.getWidth() - 169)) {
            if (!isDrawn()) {
                background.draw();
                background.translate(0, 0);
                setDrawn(true);
                return;
            }
        }
        background.translate(-movementSpeed, 0);
    }

    public void hit() {
        health--;
        if (health >= 0) {
            die();
        }
    }

    private void die() {
        this.background.load("./resources/enemy/batata/Batata_2.png");
        dead = true;
    }

    public boolean hitPlayer() {
        if (!isDead()) {
            if (player.getX() + 45 > pictureX) {
                player.getHit();
                return true;
            }
        }
        return false;
    }

    public void recoil() {
        int randomziedRecoilDistance = Utility.getRandomInt(600, 300);
        background.translate(randomziedRecoilDistance, 0);
        pictureX += randomziedRecoilDistance;
    }

    public int getDeadTimer() {
        return deadTimer;
    }

    public void incrementDeadTimer() {
        this.deadTimer++;
    }

    public void removeCorpse() {
        background.delete();
    }
}

