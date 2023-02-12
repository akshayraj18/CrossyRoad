package com.example.crossroad1;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.ImageView;

public class GameActivity  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_screen);
        // Setting player name, remaining lives, and difficulty level labels
        Player goat = ConfigActivity.getPlayer();
        TextView remainingLives = findViewById(R.id.displayLives);
        remainingLives.setText("Remaining Lives: " + goat.getLives());
        TextView difficultyLevel = findViewById(R.id.difficultyLevel);
        difficultyLevel.setText("Difficulty Level: " + goat.getDifficulty());
        TextView playerName = findViewById(R.id.displayName);
        playerName.setText("Player Name: " + goat.getName());
        ImageView imageView = findViewById(R.id.playerAvatar);
        if (goat.getSprite() == Sprite.MJ) {
            imageView.setImageDrawable(getResources().getDrawable((R.drawable.mj)));
        } else if (goat.getSprite() == Sprite.LBJ) {
            imageView.setImageDrawable(getResources().getDrawable((R.drawable.lebron)));
        } else {
            imageView.setImageDrawable(getResources().getDrawable((R.drawable.shaq)));
        }


    }
}
