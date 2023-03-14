package com.example.crossroad1;

import android.content.Context;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class GameActivity  extends AppCompatActivity {
    private Tile[] tiles;
    private Grid grid;
    public static ImageAdapterGridView adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_screen);
        grid = new Grid();
        tiles = grid.getTiles();
        GridView androidGridView = findViewById(R.id.gridview);
        adapter = new ImageAdapterGridView(this);
        androidGridView.setAdapter(adapter);
        Player goat = ConfigActivity.getPlayer();
        TextView remainingLives = findViewById(R.id.displayLives);
        remainingLives.setText("Remaining Lives: " + goat.getLives());
        TextView difficultyLevel = findViewById(R.id.difficultyLevel);
        difficultyLevel.setText("Difficulty Level: " + goat.getDifficulty());
        TextView playerName = findViewById(R.id.displayName);
        playerName.setText("Player Name: " + goat.getName());
        TextView playerPoints = findViewById(R.id.points);
        playerPoints.setText("Points: " + goat.getPoints());
        Grid.resetYMax();

        Handler handler = new Handler();
        handler.postDelayed(grid.carMove, 1000);
        handler.postDelayed(grid.ufoMove, 1000);
        handler.postDelayed(grid.jetMove, 1000);

        FloatingActionButton left = findViewById(R.id.left);
        FloatingActionButton right = findViewById(R.id.right);
        FloatingActionButton up = findViewById(R.id.up);
        FloatingActionButton down = findViewById(R.id.down);

        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                grid.moveLeft();
                adapter.notifyDataSetChanged();
            }
        });

        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                grid.moveRight();
                adapter.notifyDataSetChanged();
            }
        });

        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                grid.moveUp();
                TextView playerPoints = findViewById(R.id.points);
                playerPoints.setText("Points: " + goat.getPoints());
                adapter.notifyDataSetChanged();
            }
        });

        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                grid.moveDown();
                adapter.notifyDataSetChanged();
            }
        });
    }


    public class ImageAdapterGridView extends BaseAdapter {
        private final Context mContext;

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



