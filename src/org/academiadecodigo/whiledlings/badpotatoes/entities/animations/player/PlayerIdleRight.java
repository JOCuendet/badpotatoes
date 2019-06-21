package org.academiadecodigo.whiledlings.badpotatoes.entities.animations.player;

import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Fruit enum that demonstrates some currently available
 * <p>
 * approaches for caching an enum's values so that a new
 * <p>
 * copy of those values does not need to be instantiated
 * <p>
 * each time .values() is called.
 */

public enum PlayerIdleRight {

    PIC0(new Picture(150, 305, "./resources/player/idleblinking/0_Fallen_Angels_IdleBlinking_0.png"));

    private Picture pic;

    PlayerIdleRight(final Picture pic) {
        this.pic = pic;
    }

    public Picture getPic() {
        return this.pic;
    }
}