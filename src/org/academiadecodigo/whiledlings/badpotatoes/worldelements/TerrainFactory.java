package org.academiadecodigo.whiledlings.badpotatoes.worldelements;

public class TerrainFactory {

    public Terrain createTerrain(TerrainType type) {

        Terrain terrain;

        int floorLine = 445;
        switch (type) {
            case DARK_TREE:
                terrain = new Terrain(500, floorLine - 301, TerrainType.DARK_TREE, "./resources/blocks/treeDL.png");
                break;
            case LIGHT_TREE:
                terrain = new Terrain(100, floorLine - 275, TerrainType.LIGHT_TREE, "./resources/blocks/treeL.png");
                break;
            case ROCK:
                terrain = new Terrain(350, floorLine - 54, TerrainType.ROCK, "./resources/blocks/stone.png");
                break;
            case DARK_BUSH:
                terrain = new Terrain(700, floorLine - 47, TerrainType.DARK_BUSH, "./resources/blocks/bushDL.png");
                break;
            default:
                terrain = new Terrain(1000, floorLine - 47, TerrainType.LIGHT_BUSH, "./resources/blocks/bushLB.png");
                break;
        }
        return terrain;
    }
}
