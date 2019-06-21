package org.academiadecodigo.whiledlings.badpotatoes.controls;

import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

public class GameMouseHandler implements MouseHandler {

    private ControlMouseScheme mouse;


    public void setMouse(ControlMouseScheme mouse) {
        this.mouse = mouse;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        mouse.mouseCliked(mouseEvent.getX(), mouseEvent.getY());
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }

}
