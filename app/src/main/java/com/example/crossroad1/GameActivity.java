package com.example.crossroad1;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class GameActivity  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_screen);
        // Test player stuff, comment or delete later, cannot turn in with print statements
        Player goat = ConfigActivity.getPlayer();
        System.out.println(goat.getDifficulty());
        System.out.println(goat.getLives());
        System.out.println(goat.getName());
        System.out.println(goat.getSprite());
        System.out.println(goat.getPoints());
    }
}
