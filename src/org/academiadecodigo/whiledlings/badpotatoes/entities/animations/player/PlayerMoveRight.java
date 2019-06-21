package org.academiadecodigo.whiledlings.badpotatoes.entities.animations.player;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public enum PlayerMoveRight {

    PIC0(new Picture(150, 305, "./resources/player/walkingleft/0_Fallen_Angels_Walking_0.png")),
    PIC1(new Picture(150, 305, "./resources/player/walkingleft/0_Fallen_Angels_Walking_1.png"));

    private Picture pic;

    PlayerMoveRight(final Picture pics) {
        this.pic = pics;
    }

    public Picture getPic() {
        return this.pic;
    }
}