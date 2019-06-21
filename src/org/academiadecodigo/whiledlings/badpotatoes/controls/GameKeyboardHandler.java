package org.academiadecodigo.whiledlings.badpotatoes.controls;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.whiledlings.badpotatoes.Game;
import org.academiadecodigo.whiledlings.badpotatoes.entities.Player;
import org.academiadecodigo.whiledlings.badpotatoes.sound.Sound;

public class GameKeyboardHandler implements KeyboardHandler {

    private Player player1;
    private Game game;
    private boolean flagAtack;
    private boolean flagShield;

    public GameKeyboardHandler(Game game, Player player) {
        this.player1 = player;
        this.game = game;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        Sound attack = new Sound("~./resources/sound/game_soundFX/batata.wav");
        Sound shield = new Sound("~./resources/sound/game_soundFX/shield.wav");
        int key = keyboardEvent.getKey();

        switch (key) {
            case KeyboardEvent.KEY_A:
                player1.setDirection(DirectionType.RIGHT);
                break;
            case KeyboardEvent.KEY_E:
                player1.setDirection(DirectionType.ATTACKRIGHT);
                if (flagAtack == false) {
                attack.play(false);
                flagAtack = true;
        }
                break;
            case KeyboardEvent.KEY_D:
                player1.setDirection(DirectionType.LEFT);
                break;
            case KeyboardEvent.KEY_SPACE:
                player1.setDirection(DirectionType.SHIELD);
                player1.getShield().shieldUP();
                if(flagShield == false) {
                    shield.play(false);
                    flagShield = true;
                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        int key = keyboardEvent.getKey();

        switch (key) {
            case KeyboardEvent.KEY_E:
                player1.setDirection(DirectionType.IDLERIGHT);
                flagAtack = false;
                break;
            case KeyboardEvent.KEY_A:
                player1.setDirection(DirectionType.IDLELEFT);
                break;
            case KeyboardEvent.KEY_SPACE:
                player1.setDirection(DirectionType.IDLERIGHT);
                player1.getShield().shieldDown();
                flagShield = false;
            default:
                player1.setDirection(DirectionType.IDLERIGHT);
                break;
        }
    }
}
