package com.example.crossroad1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ConfigActivity extends AppCompatActivity {
    private ImageView imageView;
    private Difficulty diff = Difficulty.EASY;
    private TextView alertTextView;
    private static Player player;
    private Sprite goat = Sprite.MJ;

    @SuppressLint({"NonConstantResourceId", "UseCompatLoadingForDrawables"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.config_screen);
        imageView = findViewById(R.id.playerImage);
        RadioGroup sprite = findViewById(R.id.radioGroup);
        RadioGroup mode = findViewById(R.id.mode);
        Button save = findViewById(R.id.save);
        alertTextView = (TextView) findViewById(R.id.AlertTextView);
        TextView read = (TextView) findViewById(R.id.userName);
        TextView displayText = (TextView) findViewById(R.id.textView4);
        save.setOnClickListener(v -> {
            String name = read.getText().toString().trim();
            if (name == null || name.length() == 0) { //trim checks for empty strings
                AlertDialog.Builder builder = new AlertDialog.Builder(ConfigActivity.this);
                builder.setTitle("Invalid Name");
                builder.setMessage("Empty names are not allowed");
                builder.setPositiveButton("OK", (dialog, which) -> {
                    alertTextView.setVisibility(View.VISIBLE);
                });
                builder.show();
            } else {
                displayText.setText(name);
            }
        });
        sprite.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId){
                case R.id.mj:
                    goat = Sprite.MJ;
                    imageView.setImageDrawable(getResources().getDrawable((R.drawable.mj)));
                    break;
                case R.id.lbj:
                    goat = Sprite.LBJ;
                    imageView.setImageDrawable(getResources().getDrawable((R.drawable.lebron)));
                    break;
                case R.id.shaq:
                    goat = Sprite.SHAQ;
                    imageView.setImageDrawable(getResources().getDrawable((R.drawable.shaq)));
                    break;
            }
        });
        mode.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId){
                case R.id.easy:
                    diff = Difficulty.EASY;
                    break;
                case R.id.med:
                    diff = Difficulty.MEDIUM;
                    break;
                case R.id.hard:
                    diff = Difficulty.HARD;
                    break;
            }
        });
        Button play = (Button) findViewById(R.id.Play);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player = new Player(displayText.getText().toString(), goat, diff);
                startActivity(new Intent(ConfigActivity.this, GameActivity.class));
            }
        });
    }

    public static Player getPlayer() {
        return player;
    }
}