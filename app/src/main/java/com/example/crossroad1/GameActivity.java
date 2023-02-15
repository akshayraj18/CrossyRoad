package com.example.crossroad1;

import android.content.Context;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Toast;

public class GameActivity  extends AppCompatActivity {

    GridView androidGridView;
    int mj = R.drawable.mj;
    int lbj = R.drawable.lebron;
    int shaq = R.drawable.shaq;
    Integer[] imageIDs = {
            mj, lbj, shaq, mj, lbj, shaq, mj, lbj,
            mj, lbj, shaq, mj, lbj, shaq, mj, lbj,
            mj, lbj, shaq, mj, lbj, shaq, mj, lbj,
            mj, lbj, shaq, mj, lbj, shaq, mj, lbj,
            mj, lbj, shaq, mj, lbj, shaq, mj, lbj,
            mj, lbj, shaq, mj, lbj, shaq, mj, lbj,
            mj, lbj, shaq, mj, lbj, shaq, mj, lbj,
            mj, lbj, shaq, mj, lbj, shaq, mj, lbj,
            mj, lbj, shaq, mj, lbj, shaq, mj, lbj,
            mj, lbj, shaq, mj, lbj, shaq, mj, lbj,
            mj, lbj, shaq, mj, lbj, shaq, mj, lbj,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_screen);
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


    }
    public class ImageAdapterGridView extends BaseAdapter {
        private Context mContext;

        public ImageAdapterGridView(Context c) {
            mContext = c;
        }

        public int getCount() {
            return imageIDs.length;
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
            mImageView.setImageResource(imageIDs[position]);
            return mImageView;
        }
    }
}
