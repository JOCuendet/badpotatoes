package org.academiadecodigo.whiledlings.badpotatoes.worldelements;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.whiledlings.badpotatoes.Utility;

public class BlockFactory {

    private final int MAXBLOCKS;
    private final int FLOOR_LINE = 445;

    public BlockFactory(int MAXBLOCKS) {
        this.MAXBLOCKS = MAXBLOCKS;
    }

    public Block[][] createFloor(Rectangle bg) {

        int bgWidth = (int) Math.nextUp((bg.getWidth() / 32));
        int bgHeight = (int) Math.nextUp((bg.getHeight() - FLOOR_LINE) / 32) + 1;
        Block[][] floor = new Block[bgHeight][bgWidth];

        int x = 10;
        int y = FLOOR_LINE;
        int xx = x;

        String bgImagePath = "";


        for (int row = 0; row < floor.length; row++) {
            for (int col = 0; col < floor[row].length; col++) {
                if (y == FLOOR_LINE) {
                    bgImagePath = "./resources/blocks/2.png";
                } else {
                    bgImagePath = "./resources/blocks/5.png";
                }
                floor[row][col] = new Block(xx, y, bgImagePath);
                xx += 32;
            }
            xx = x;
            y += 32;
        }

        return floor;
    }

    public Block[] createLevel1(Rectangle bg) {
        int spaceSize = 32;
        int maxCellingY = 100;
        int maxFloorY = 410 - spaceSize;
        int bgWidth = bg.getWidth();

        Block[] level1 = new Block[20];

        for (int i = 0; i < level1.length; i++) {
            int multiplier = Utility.getRandomInt(1, 0);
            int xValue = bgWidth + (spaceSize * multiplier);
            int verticalPosition = Utility.getRandomInt(maxFloorY, maxCellingY);
            level1[i] = new Block(xValue, verticalPosition, "./resources/blocks/fillerImage.jpg");
        }
        return level1;
    }
}
