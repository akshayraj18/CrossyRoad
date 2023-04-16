package com.example.crossroad1.activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.ImageView;

import com.example.crossroad1.Grid;
import com.example.crossroad1.Player;
import com.example.crossroad1.R;
import com.example.crossroad1.Tile;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class GameActivity  extends AppCompatActivity {
    private Tile[] tiles;
    private Grid grid = new Grid();
    private static ImageAdapterGridView adapter;

    public static ImageAdapterGridView getAdapter() {
        return adapter;
    }
    private Player goat = ConfigActivity.getPlayer();


    private Handler handler1 = new Handler();
    private Runnable carMove = new Runnable() {
        @Override
        public void run() {
            grid.carRun();
            if ((grid.hasCollision() || grid.inWater()) && grid.getPlayerCoord().getY() != 11) {
                grid = new Grid();
                if (goat.getLives() == 1) {
                    startActivity(new Intent(GameActivity.this, EndActivity.class));
                } else {
                    goat.decLives();
                    Player.setPoints(0);
                    startActivity(new Intent(GameActivity.this, GameActivity.class));
                }
            }
            handler1.postDelayed(this, 1000); // Call the clock again
        }
    };
    private Runnable ufoMove = new Runnable() {
        @Override
        public void run() {
            grid.ufoRun();
            if ((grid.hasCollision() || grid.inWater()) && grid.getPlayerCoord().getY() != 11) {
                grid = new Grid();
                if (goat.getLives() == 1) {
                    startActivity(new Intent(GameActivity.this, EndActivity.class));
                } else {
                    goat.decLives();
                    Player.setPoints(0);
                    startActivity(new Intent(GameActivity.this, GameActivity.class));
                }
                if (grid.reachedGoal()) {
                    startActivity(new Intent(GameActivity.this, WinActivity.class));
                    return;
                }
            }
            handler1.postDelayed(this, 750); // Call the clock again
        }
    };
    private Runnable jetMove = new Runnable() {
        @Override
        public void run() {
            grid.jetRun();
            if ((grid.hasCollision() || grid.inWater()) && grid.getPlayerCoord().getY() != 11) {
                grid = new Grid();
                if (goat.getLives() == 1) {
                    startActivity(new Intent(GameActivity.this, EndActivity.class));
                } else {
                    goat.decLives();
                    Player.setPoints(0);
                    startActivity(new Intent(GameActivity.this, GameActivity.class));
                }
            }
            if (grid.reachedGoal()) {
                startActivity(new Intent(GameActivity.this, WinActivity.class));
                return;
            }
            handler1.postDelayed(this, 500); // Call the clock again
        }
    };
    private Runnable log1Move = new Runnable() {
        @Override
        public void run() { // process log moving player off screen soon
            grid.log1Run();
            handler1.postDelayed(this, 750); // Call the clock again
        }
    };
    private Runnable log23Move = new Runnable() {
        @Override
        public void run() { // process log moving player off screen soon
            grid.log2Run();
            grid.log3Run();
            handler1.postDelayed(this, 1000); // Call the clock again
        }
    };

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_screen);
        grid.resetYMax();
        tiles = grid.getTiles();
        GridView androidGridView = findViewById(R.id.gridview);
        adapter = new ImageAdapterGridView(this);
        androidGridView.setAdapter(adapter);
        TextView remainingLives = findViewById(R.id.displayLives);
        remainingLives.setText("Remaining Lives: " + goat.getLives());
        TextView difficultyLevel = findViewById(R.id.difficultyLevel);
        difficultyLevel.setText("Difficulty Level: " + goat.getDifficulty());
        TextView playerName = findViewById(R.id.displayName);
        playerName.setText("Player Name: " + goat.getName());
        TextView playerPoints = findViewById(R.id.points);
        playerPoints.setText("Points: " + goat.getPoints());


        Handler handler = new Handler();
        handler.postDelayed(carMove, 1000);
        handler.postDelayed(ufoMove, 1000);
        handler.postDelayed(jetMove, 1000);
        handler.postDelayed(log1Move, 1000);
        handler.postDelayed(log23Move, 1000);

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