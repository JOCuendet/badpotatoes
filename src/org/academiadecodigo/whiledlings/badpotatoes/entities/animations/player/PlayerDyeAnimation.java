package org.academiadecodigo.whiledlings.badpotatoes.entities.animations.player;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public enum PlayerDyeAnimation {

    PIC0(new Picture(150, 305, "./resources/player/dying/0_Fallen_Angels_Dying_0.png"));

    private Picture pic;

    PlayerDyeAnimation(final Picture pics) {
        this.pic = pics;
    }

    public Picture getPic() {
        return this.pic;
    }
}