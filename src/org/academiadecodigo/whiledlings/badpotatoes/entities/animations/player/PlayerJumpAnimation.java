package org.academiadecodigo.whiledlings.badpotatoes.entities.animations.player;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public enum PlayerJumpAnimation {

    PIC0(new Picture(150, 305, "./resources/player/jumploop/0_Fallen_Angels_JumpLoop_0.png"));

    private Picture pic;

    PlayerJumpAnimation(final Picture pics) {
        this.pic = pics;
    }

    public Picture getPic() {
        return this.pic;
    }
}