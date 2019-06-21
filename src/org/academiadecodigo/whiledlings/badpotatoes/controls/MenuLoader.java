package org.academiadecodigo.whiledlings.badpotatoes.controls;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.whiledlings.badpotatoes.Game;

public class MenuLoader {


    private final Picture[] menuMovement;

    public MenuLoader(Picture[] menuImages) {
        this.menuMovement = menuImages;
    }


    public void exitGame() {

        System.exit(0);
    }

    public void startGame() {
        for (int i = 0; i < menuMovement.length; i++) {
            menuMovement[0].delete();
            menuMovement[1].delete();
            menuMovement[2].delete();

        }
        Game.menuDrawn = false;
    }
}

