package org.academiadecodigo.whiledlings.badpotatoes.entities.animations.player;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public enum PlayerHurtAnimation {

    PIC0(new Picture(150, 305, "./resources/player/hurt/0_Fallen_Angels_Hurt_0.png"));

    private Picture pic;

    PlayerHurtAnimation(final Picture pics) {
        this.pic = pics;
    }

    public Picture getPic() {
        return this.pic;
    }
}