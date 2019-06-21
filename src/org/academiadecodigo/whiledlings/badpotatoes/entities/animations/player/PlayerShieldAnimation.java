package org.academiadecodigo.whiledlings.badpotatoes.entities.animations.player;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public enum PlayerShieldAnimation {

    PIC0(new Picture(150, 305, "./resources/player/shield/0_Fallen_Angels_Shield_0.png"));

    private Picture pic;

    PlayerShieldAnimation(final Picture pics) {
        this.pic = pics;
    }

    public Picture getPic() {
        return this.pic;
    }
}