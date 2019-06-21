package org.academiadecodigo.whiledlings.badpotatoes.entities.animations.Minion;

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

public enum MinionIdleLeft {


    PIC0(new Picture(10, 10, "./resources/player/slashing/0_Fallen_Angels_Slashing_0.png")),

    PIC1(new Picture(10, 10, "./resources/player/slashing/0_Fallen_Angels_Slashing_1.png")),

    PIC2(new Picture(10, 10, "./resources/player/slashing/0_Fallen_Angels_Slashing_2.png")),

    PIC3(new Picture(10, 10, "./resources/player/slashing/0_Fallen_Angels_Slashing_3.png")),

    PIC4(new Picture(10, 10, "./resources/player/slashing/0_Fallen_Angels_Slashing_4.png")),

    PIC5(new Picture(10, 10, "./resources/player/slashing/0_Fallen_Angels_Slashing_5.png")),

    PIC6(new Picture(10, 10, "./resources/player/slashing/0_Fallen_Angels_Slashing_6.png")),

    PIC7(new Picture(10, 10, "./resources/player/slashing/0_Fallen_Angels_Slashing_7.png")),

    PIC8(new Picture(10, 10, "./resources/player/slashing/0_Fallen_Angels_Slashing_8.png")),

    PIC9(new Picture(10, 10, "./resources/player/slashing/0_Fallen_Angels_Slashing_9.png")),

    PIC10(new Picture(10, 10, "./resources/player/slashing/0_Fallen_Angels_Slashing_10.png")),

    PIC11(new Picture(10, 10, "./resources/player/slashing/0_Fallen_Angels_Slashing_11.png"));

    private Picture pics;

    MinionIdleLeft(final Picture pics) {
        this.pics = pics;
    }

    public Picture getPics() {
        return this.pics;
    }
}