package com.example.crossroad1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class GameActivity  extends AppCompatActivity {

    GridView androidGridView;
    Tile[] tiles;
    Grid grid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_screen);
        grid = new Grid();
        tiles = grid.getTiles();
        androidGridView = (GridView) findViewById(R.id.gridview);
        androidGridView.setAdapter(new ImageAdapterGridView(this));

        Player goat = ConfigActivity.getPlayer();
        TextView remainingLives = findViewById(R.id.displayLives);
        remainingLives.setText("Remaining Lives: " + goat.getLives());
        TextView difficultyLevel = findViewById(R.id.difficultyLevel);
        difficultyLevel.setText("Difficulty Level: " + goat.getDifficulty());
        TextView playerName = findViewById(R.id.displayName);
        playerName.setText("Player Name: " + goat.getName());
        TextView playerPoints = findViewById(R.id.points);
        playerPoints.setText("Points: " + goat.getPoints());

        FloatingActionButton left = (FloatingActionButton) findViewById(R.id.left);
        //Button right = (Button) findViewById(R.id.right);
        //Button up = (Button) findViewById(R.id.up);
        //Button down = (Button) findViewById(R.id.down);

        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                grid.moveLeft();
                System.out.println(Grid.getTile());
                System.out.println(Coordinate.getX());
                System.out.println(Coordinate.getY());
            }
        });
    }
    public class ImageAdapterGridView extends BaseAdapter {
        private Context mContext;

        public ImageAdapterGridView(Context c) {
            mContext = c;
        }

        public int getCount() {
            return tiles.length;
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView mImageView;

            if (convertView == null) {
                mImageView = new ImageView(mContext);
                mImageView.setLayoutParams(new GridView.LayoutParams(140, 140));
                mImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                mImageView.setPadding(0, 0, 0, 0);
            } else {
                mImageView = (ImageView) convertView;
            }
            mImageView.setImageResource(tiles[position].getImage());
            return mImageView;
        }
    }
}
