package org.academiadecodigo.whiledlings.badpotatoes.entities.animations.player;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public enum PlayerSlashing {

    PIC0(new Picture(150, 305, "./resources/player/slashing/0_Fallen_Angels_Slashing_0.png"));

    private Picture pic;

    PlayerSlashing(final Picture pics) {
        this.pic = pics;
    }

    public Picture getPic() {
        return this.pic;
    }
}