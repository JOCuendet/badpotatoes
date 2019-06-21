package org.academiadecodigo.whiledlings.badpotatoes.entities.animations.player;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public enum PlayerMoveLeft {

    PIC0(new Picture(150, 305, "./resources/player/walking/0_Fallen_Angels_Walking_0.png")),
    PIC1(new Picture(150, 305, "./resources/player/walking/0_Fallen_Angels_Walking_1.png"));

    private Picture pic;

    PlayerMoveLeft(final Picture pic) {
        this.pic = pic;
    }

    public Picture getPic() {
        return this.pic;
    }
}