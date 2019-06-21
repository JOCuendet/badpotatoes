package org.academiadecodigo.whiledlings.badpotatoes.entities;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.whiledlings.badpotatoes.controls.DirectionType;
import org.academiadecodigo.whiledlings.badpotatoes.entities.animations.player.*;

public class PlayerAnimations {
    private final int SPEED_OF_ANIMATION = 20;
    private Player player;
    private int X;
    private int Y;
    private Rectangle[] maxHealthBar;

    public PlayerAnimations(Player player) {
        this.player = player;
        this.X = player.getX();
        this.Y = player.getY();
        this.maxHealthBar = new Rectangle[player.getMaxHealth()];
    }

    public void stopAll(DirectionType oldDirectionStopper) {
        switch (oldDirectionStopper) {
            case IDLERIGHT:
                for (int i = 0; i < PlayerIdleRight.values().length; i++)
                    PlayerIdleRight.values()[i].getPic().delete();
                break;
            case IDLELEFT:
                for (int i = 0; i < PlayerIdleLeft.values().length; i++)
                    PlayerIdleLeft.values()[i].getPic().delete();
                break;
            case LEFT:
                for (int i = 0; i < PlayerMoveLeft.values().length; i++)
                    PlayerMoveLeft.values()[i].getPic().delete();
                break;
            case RIGHT:
                for (int i = 0; i < PlayerMoveRight.values().length; i++)
                    PlayerMoveRight.values()[i].getPic().delete();
                break;
            case JUMP:
                for (int i = 0; i < PlayerJumpAnimation.values().length; i++)
                    PlayerJumpAnimation.values()[i].getPic().delete();
                break;
            case DYING:
                for (int i = 0; i < PlayerDyeAnimation.values().length; i++)
                    PlayerDyeAnimation.values()[i].getPic().delete();
                break;
            case ATTACKRIGHT:
                for (int i = 0; i < PlayerSlashing.values().length; i++)
                    PlayerSlashing.values()[i].getPic().delete();
                break;
            case HURT:
                for (int i = 0; i < PlayerHurtAnimation.values().length; i++)
                    PlayerHurtAnimation.values()[i].getPic().delete();
                break;
            case SHIELD:
                for (int i = 0; i < PlayerShieldAnimation.values().length; i++)
                    PlayerShieldAnimation.values()[i].getPic().delete();
                break;
        }
    }

    public void hurtAnimation() throws InterruptedException {
        stopAll(player.getOldDirection());
        PlayerHurtAnimation.values()[0].getPic().draw();
        Thread.sleep(100);
        PlayerHurtAnimation.values()[0].getPic().delete();
        PlayerIdleRight.values()[0].getPic().draw();
    }

    public void ShieldAnimation() {
        stopAll(player.getOldDirection());
        PlayerShieldAnimation.values()[0].getPic().draw();
    }

    public void dyeAnimation() throws InterruptedException {

        stopAll(DirectionType.IDLERIGHT);
        stopAll(DirectionType.HURT);
        stopAll(DirectionType.IDLELEFT);
        stopAll(DirectionType.SHIELD);
        stopAll(DirectionType.LEFT);
        stopAll(DirectionType.RIGHT);
        PlayerDyeAnimation.values()[0].getPic().draw();
    }

    public void gameOver() throws InterruptedException {


        Picture gameOverPic = new Picture(10,10, "./resources/ui&background/gamestatus/Gameover.png/");
        gameOverPic.draw();
        Thread.sleep(4000);
    }

    public void slashAtack() {
        stopAll(player.getOldDirection());
        PlayerSlashing.values()[0].getPic().draw();
    }

    public void idleRight() {
        stopAll(player.getOldDirection());
        PlayerIdleRight.values()[0].getPic().draw();
    }

    public void idleLeft() {
        PlayerIdleLeft.values()[0].getPic().draw();
    }

    public void walkLeft() throws InterruptedException {
        int speed = SPEED_OF_ANIMATION / 2;

        for (int i = 0; i < PlayerMoveLeft.values().length; i++) {

            if (player.getDirection() == DirectionType.LEFT) {
                Thread.sleep(speed);
                if (i > 0)
                    PlayerMoveLeft.values()[i - 1].getPic().delete();

                PlayerMoveLeft.values()[i].getPic().draw();
                Thread.sleep(speed);
                if (i == PlayerMoveLeft.values().length - 1) {
                    PlayerMoveLeft.values()[i].getPic().delete();
                    PlayerMoveLeft.values()[0].getPic().draw();
                }
            }
        }
    }

    public void walkRight() throws InterruptedException { // add speed variable for "walkLeft" run!
        int speed = SPEED_OF_ANIMATION / 2;

        for (int i = 0; i < PlayerMoveRight.values().length; i++) {

            if (player.getDirection() == DirectionType.RIGHT) {
                Thread.sleep(speed);
                if (i > 0)
                    PlayerMoveRight.values()[i - 1].getPic().delete();

                PlayerMoveRight.values()[i].getPic().draw();
                Thread.sleep(speed);
                if (i == PlayerMoveRight.values().length - 1) {
                    PlayerMoveRight.values()[i].getPic().delete();
                    PlayerMoveRight.values()[0].getPic().draw();
                }
            }
        }
    }

    public void drawLifeBar() {

        int x = 20;
        int y = 20;
        int blockWidth = 75;
        int blockThickness = 5;
        int blockSpacer = 5;

        if (maxHealthBar[0] != null)
            for (Rectangle pic : maxHealthBar) {
                pic.delete();
            }

        for (int i = 0; i < player.getMaxHealth(); i++) {
            maxHealthBar[i] = new Rectangle(x, y, blockWidth, blockThickness);
            maxHealthBar[i].setColor(Color.RED);
            maxHealthBar[i].draw();
            x += blockWidth + blockSpacer;
        }
        for (int i = 0; i < player.getHealth(); i++) {
            maxHealthBar[i].fill();
        }
    }


    public void jump() throws InterruptedException {

        // NOT IMPLEMENTED YET.

    }
}
