package org.academiadecodigo.whiledlings.badpotatoes;

import org.academiadecodigo.whiledlings.badpotatoes.entities.Player;

public class Main {
    public static void main(String[] args) {

        Player player = new Player();
        Game g = new Game(player);

        try {
            g.init();
            g.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
