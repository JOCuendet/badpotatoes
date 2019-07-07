package org.academiadecodigo.whiledlings.badpotatoes.entities;

import org.academiadecodigo.whiledlings.badpotatoes.controls.DirectionType;

public class Player implements Moveable {

    private final int X;
    private final int Y;

    private Shield shield;
    private PlayerAnimations animation;
    private int moveSpeed = 10;
    private DirectionType direction;
    private DirectionType oldDirection;
    private int maxHealth = 5; // 5 hits dead
    private int health;


    public Player() {

        this.health = maxHealth;
        this.X = 150;
        this.Y = 305;
        this.direction = DirectionType.IDLERIGHT;
        this.oldDirection = DirectionType.IDLERIGHT;


        this.shield = new Shield();
        this.animation = new PlayerAnimations(this);

    }

    public Shield getShield() {
        return shield;
    }

    public int getMoveSpeed() {
        return moveSpeed;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public PlayerAnimations getAnimation() {
        return animation;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public DirectionType getDirection() {
        return direction;
    }

    public void setDirection(DirectionType direction) {
        this.direction = direction;
    }

    public DirectionType getOldDirection() {
        return oldDirection;
    }

    public void setOldDirection(DirectionType oldDirection) {
        this.oldDirection = oldDirection;
    }

    @Override
    public void move(DirectionType direction, int playerSpeed) throws InterruptedException {

        switch (direction) {
            case LEFT:
                animation.walkLeft();
                break;
            case RIGHT:
                animation.walkRight();
                break;
            case IDLELEFT:
                animation.idleLeft();
                break;
            case IDLERIGHT:
                animation.idleRight();
                break;
            case SHIELD:
                animation.ShieldAnimation();
                break;
            case DYING:
                animation.dyeAnimation();
                break;
            case ATTACKRIGHT:
                animation.slashAtack();
                break;
            case HURT:
                //getHit();
                animation.hurtAnimation();
                break;
        }
    }


    public void getHit() {
        if (!shield.isShieldUp()) {
            health--;
        }
    }

    public int getHealth() {
        return health;
    }

    public void addHeal(int healer) {

        int tooMuchHp = health + healer;

        if (health == 100) {

            System.out.println("You have full health already.");
            return;
        }

        if ((tooMuchHp) >= 100) {

            health += (100 - health);
            System.out.println("Player hp2: " + health);
            return;
        }

        health += healer;
        System.out.println("Player hp3: " + health);
    }

    public void attack(Potato[] potatoes) {

        for (Potato potato : potatoes) {
            if (!potato.isDead()) {
                if ((potato.getPictureX() > (getX() + 60)) &&
                        (potato.getPictureX() < (getX() + 90))) {
                    potato.hit();
                }
            }
        }
    }
}
