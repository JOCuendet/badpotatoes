package org.academiadecodigo.whiledlings.badpotatoes.entities;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.whiledlings.badpotatoes.Utility;

public class EnemyFactory {

    public Batata[] createLevel1(int numberOfEnemyToSpawn, Rectangle newBg, Player player) {
        int spaceSize = 169;
        int maxFloorY = 305;
        int bgWidth = newBg.getWidth();

        Batata[] level1 = new Batata[numberOfEnemyToSpawn];

        for (int i = 0; i < level1.length; i++) {
            int multiplier = Utility.getRandomInt(numberOfEnemyToSpawn, 0);
            int xValue = bgWidth + (spaceSize * multiplier);
            int movementSpeed = Utility.getRandomInt(6, 2);

            level1[i] = new Batata(xValue, maxFloorY, newBg, movementSpeed, player);
        }
        return level1;
    }
}
