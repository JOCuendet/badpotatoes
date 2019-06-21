package org.academiadecodigo.whiledlings.badpotatoes.entities.animations.player;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public enum PlayerIdleLeft {

    PIC0(new Picture(150, 305, "./resources/player/idleleftblinking/0_Fallen_Angels_IdleBlinking_0.png"));

    private Picture pic;

    PlayerIdleLeft(final Picture pics) {
        this.pic = pics;
    }

    public Picture getPic() {
        return this.pic;
    }
}