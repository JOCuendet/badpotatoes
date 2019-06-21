package org.academiadecodigo.whiledlings.badpotatoes.controls;


public class MenuMouseHandler implements ControlMouseScheme {

    private MenuLoader menuLoader;

    public MenuMouseHandler(MenuLoader menuLoader) {
        this.menuLoader = menuLoader;
    }

    @Override
    public void mouseCliked(double x, double y) {
        if ((x > 500 && x < 600) && (y > 300 && y < 400)) {
            menuLoader.startGame();
            return;
        }
        if ((x > 620 && x < 720) && (y > 300 && y < 400)) {
            menuLoader.exitGame();
            return;
        }

    }

    @Override
    public void mouseMoved() {
    }
}
