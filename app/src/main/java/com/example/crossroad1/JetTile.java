package com.example.crossroad1;

public class JetTile extends Tile {
    private Coordinate jetCoord;
    private int jetImage;
    private boolean hasJetSprite;

    public JetTile(Coordinate loc) {
        super();
        this.jetCoord = loc;
        this.jetImage = R.drawable.jet;
        super.setTileType(jetImage);
    }

    @Override
    public void setImage() {
        if (hasJetSprite) {
            this.jetImage = R.drawable.jet;
        }
    }

    @Override
    public int getImage() {
        return jetImage;
    }

    public void addSprite() {
        this.jetImage = R.drawable.jet;
    }

    public void removeSprite() {
        this.jetImage = R.drawable.road_tile;
    }
}
