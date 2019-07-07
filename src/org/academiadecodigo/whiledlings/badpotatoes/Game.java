package org.academiadecodigo.whiledlings.badpotatoes;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.whiledlings.badpotatoes.controls.*;
import org.academiadecodigo.whiledlings.badpotatoes.entities.EnemyFactory;
import org.academiadecodigo.whiledlings.badpotatoes.entities.Player;
import org.academiadecodigo.whiledlings.badpotatoes.entities.Potato;
import org.academiadecodigo.whiledlings.badpotatoes.sound.Sound;
import org.academiadecodigo.whiledlings.badpotatoes.worldelements.Terrain;
import org.academiadecodigo.whiledlings.badpotatoes.worldelements.TerrainFactory;
import org.academiadecodigo.whiledlings.badpotatoes.worldelements.TerrainType;


public class Game {


    private static final int PADDING = 10;
    public static boolean menuDrawn; // DO NOT TOUCH - JO
    private static KeyboardHandler keyBoardHandler;
    private final String bgpath = "./resources/ui&background/backgrounds/backgroundLarger.png";
    private Rectangle newBg;
    private Picture newBgPictureLevel1;
    private Picture floor;
    private Potato[] level1;
    private int killCount = 0;
    private Text enemiesKilled;
    private Text victoryText;
    private Mouse mouse;
    private GameMouseHandler gkMouse;
    private MenuLoader menuLoader;
    private Picture[] menuMovement = new Picture[3];
    private String path = "./resources/Menu/";

    private Picture menuBg;

    private Sound mainSong;
    private TerrainFactory terrainFactory = new TerrainFactory();

    private Terrain lbush;
    private Terrain dbush;
    private Terrain rock;
    private Terrain dtree;
    private Terrain ltree;


    private Player player;

    public Game(Player player) {
        this.player = player;
        menuDrawn = true;
    }

    private void loadMenu() {
        menuMovement[0] = new Picture(10, 10, path + "LogoBADPotatoes.png");
        menuMovement[1] = new Picture(500, 300, path + "play-1.png");
        menuMovement[2] = new Picture(620, 300, path + "cancel-1.png");

        menuMovement[0].draw();
        menuMovement[1].draw();
        menuMovement[2].draw();


    }

    void init() {

        String bgpath = "./resources/ui&background/backgrounds/backgroundLarger.png";
        this.newBgPictureLevel1 = new Picture(PADDING, PADDING, bgpath);
        this.newBg = new Rectangle(PADDING, PADDING, 1184, 496);
        newBg.setColor(Color.BLACK);
        newBg.draw();
        newBgPictureLevel1.draw();

        this.floor = new Picture(PADDING, 442, "./resources/ui&background/backgrounds/floor.png");
        floor.draw();


        mainSong = new Sound("~./resources/sound/game_songs/mainsong1.wav");
        mainSong.play(true);

        EnemyFactory enemyFactory = new EnemyFactory();

        this.level1 = enemyFactory.createLevel1(10, newBg, player);


        keyBoardHandler = new GameKeyboardHandler(this, player);
        Keyboard keyboard = new Keyboard(keyBoardHandler);

        KeyboardEvent d_press = new KeyboardEvent();
        d_press.setKey(KeyboardEvent.KEY_D);
        d_press.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(d_press);

        KeyboardEvent d_release = new KeyboardEvent();
        d_release.setKey(KeyboardEvent.KEY_D);
        d_release.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(d_release);

        KeyboardEvent a_press = new KeyboardEvent();
        a_press.setKey(KeyboardEvent.KEY_A);
        a_press.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(a_press);

        KeyboardEvent a_release = new KeyboardEvent();
        a_release.setKey(KeyboardEvent.KEY_A);
        a_release.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(a_release);

        KeyboardEvent SPACE_press = new KeyboardEvent();
        SPACE_press.setKey(KeyboardEvent.KEY_SPACE);
        SPACE_press.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(SPACE_press);

        KeyboardEvent SPACE_release = new KeyboardEvent();
        SPACE_release.setKey(KeyboardEvent.KEY_SPACE);
        SPACE_release.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(SPACE_release);

        KeyboardEvent e_press = new KeyboardEvent();
        e_press.setKey(KeyboardEvent.KEY_E);
        e_press.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(e_press);

        KeyboardEvent e_release = new KeyboardEvent();
        e_release.setKey(KeyboardEvent.KEY_E);
        e_release.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(e_release);

        int enemiesCount = level1.length;
        Text maxEnemies = new Text(1100, 30, "/" + enemiesCount);
        maxEnemies.setColor(Color.BLACK);
        maxEnemies.grow(30, 30);
        maxEnemies.draw();


        lbush = terrainFactory.createTerrain(TerrainType.LIGHT_BUSH);
        dbush = terrainFactory.createTerrain(TerrainType.DARK_BUSH);
        rock = terrainFactory.createTerrain(TerrainType.ROCK);
        dtree = terrainFactory.createTerrain(TerrainType.DARK_TREE);
        ltree = terrainFactory.createTerrain(TerrainType.LIGHT_TREE);


        enemiesKilled = new Text(1030, 30, "" + killCount);
        enemiesKilled.setColor(Color.BLACK);
        enemiesKilled.grow(15, 15);
        enemiesKilled.draw();

        gkMouse = new GameMouseHandler();
        mouse = new Mouse(gkMouse);
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
        mouse.addEventListener(MouseEventType.MOUSE_MOVED);

        MenuLoader menuLoader = new MenuLoader(menuMovement);
        MenuMouseHandler menuMouseHandler = new MenuMouseHandler(menuLoader);
        gkMouse.setMouse(menuMouseHandler);
        loadMenu();
    }

    void start() throws InterruptedException {



        Sound gameOverMusic = new Sound(".resources/sound/game_songs/gameover.mp3");
        Sound potatoAttack = new Sound(".resources/sound/game_soundFX/potatoattack.wav");


        while (player.getHealth() > 0) {

            if (menuDrawn) {
                System.out.flush();
                continue;
            }


            lbush.drawBlock();
            dbush.drawBlock();
            rock.drawBlock();
            dtree.drawBlock();
            ltree.drawBlock();


            if (player.getDirection() == DirectionType.LEFT) {
                lbush.move(DirectionType.LEFT, newBg);
                dbush.move(DirectionType.LEFT, newBg);
                rock.move(DirectionType.LEFT, newBg);
                dtree.move(DirectionType.LEFT, newBg);
                ltree.move(DirectionType.LEFT, newBg);
            }

            if (player.getDirection() == DirectionType.RIGHT) {
                lbush.move(DirectionType.RIGHT, newBg);
                dbush.move(DirectionType.RIGHT, newBg);
                rock.move(DirectionType.RIGHT, newBg);
                dtree.move(DirectionType.RIGHT, newBg);
                ltree.move(DirectionType.RIGHT, newBg);
            }

            // player moves right ---------------------------------------------
            if (lbush.getBackground().getX() < -200) {
                lbush.playerToRight(1300);
            }
            if (dbush.getBackground().getX() < -200) {
                dbush.playerToRight(1300);
            }
            if (rock.getBackground().getX() < -200) {
                rock.playerToRight(1300);
            }
            if (dtree.getBackground().getX() < -400) {
                dtree.playerToRight(1315);
            }
            if (ltree.getBackground().getX() < -400) {
                ltree.playerToRight(1315);
            }

            // player moves left --------------------------------------------
            if (lbush.getBackground().getX() > 1100) {
                lbush.playerToLeft(1300);
            }
            if (dbush.getBackground().getX() > 1100) {
                dbush.playerToLeft(1300);
            }
            if (rock.getBackground().getX() > 1100) {
                rock.playerToLeft(1300);
            }
            if (dtree.getBackground().getX() > 915) {
                dtree.playerToLeft(1315);
            }
            if (ltree.getBackground().getX() > 915) {
                ltree.playerToLeft(1315);
            }
            // --------------------------------------------------------------

            if (player.getOldDirection() != player.getDirection()) {
                player.getAnimation().stopAll(player.getOldDirection());
                player.setOldDirection(player.getDirection());
            }

            player.move(player.getDirection(), player.getMoveSpeed());

            if (player.getDirection() == DirectionType.ATTACKRIGHT) {
                player.attack(level1);

            }

            for (Potato potato : level1) {
                if (potato.hitPlayer()) {
                    potatoAttack.play(false);
                    player.getAnimation().hurtAnimation();
                    potato.recoil();
                }
                if (!potato.hitPlayer()) {
                    if (!potato.isDead()) {
                        potato.move(player.getDirection(), player.getMoveSpeed());// MOVEMENT!
                        potato.moveAuto();
                    }

                }

            }

            player.getAnimation().drawLifeBar();

            for (Potato potato : level1) { // GARBAGE COLLECTOR
                if (potato.isDead()) {

                    if (potato.getDeadTimer() > 20) {

                        potato.removeCorpse();
                    }
                    potato.incrementDeadTimer();
                }

            }

            //syringe.move(DirectionType.LEFT, newBg);

            for (Potato potato : level1) {
                if (potato.isDead()) {
                    if (!potato.isCounted()) {
                        killCount++;
                        potato.setCounted();
                        enemiesKilled.setText("" + killCount);
                    }
                }
            }

            if (killCount == level1.length) {
                Picture victoryPic = new Picture(PADDING, PADDING, "./resources/ui&background/gamestatus/GameWin.png");
                victoryPic.draw();
                break;
            }


            if (player.getDirection() == DirectionType.DYING) {
                player.getAnimation().stopAll(player.getOldDirection());
                player.getAnimation().dyeAnimation();
            }
            if (player.getHealth() <= 0) {
                mainSong.stop();
                player.getAnimation().dyeAnimation();
                gameOverMusic.play(true);
                Thread.sleep(2000);
                player.getAnimation().gameOver();

            }

        }

    }
}