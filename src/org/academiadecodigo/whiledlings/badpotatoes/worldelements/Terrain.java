package org.academiadecodigo.whiledlings.badpotatoes.worldelements;

public class Terrain extends Block {

    private TerrainType terrainType;

    public Terrain(int x, int y, TerrainType terrainType, String backgroundPath) {
        super(x, y, backgroundPath);
        this.terrainType = terrainType;
    }

    public void playerToRight(int x) {
        delete();
        moveTo(x);
        getBackground().translate(x, 0);
        setX(x);
        drawBlock();
    }

    public void playerToLeft(int x) {
        delete();
        moveTo(-x);
        getBackground().translate(-x, 0);
        setX(-x);
        drawBlock();
    }
}
