package org.academiadecodigo.whiledlings.badpotatoes;

public class Utility {
    public static int getRandomInt(int maxRange, int minRange) {
        return (int) (Math.random() * Math.floor((maxRange) + 1));
        // return [0, 10] = 11 different outputs.
    }

    public static boolean isOdd(int num) {

        return num % 2 == 0;

    }
}
