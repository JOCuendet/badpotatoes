package org.academiadecodigo.whiledlings.badpotatoes.entities;

public class Shield {

    // private int resistance;
    private boolean shieldUp;

    public Shield() {
        this.shieldUp = false;
    }

    public void shieldUP() {
        this.shieldUp = true;
    }

    public void shieldDown() {
        this.shieldUp = false;
    }

    public boolean isShieldUp() {
        return shieldUp;
    }
}
