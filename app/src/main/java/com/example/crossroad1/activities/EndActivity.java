package com.example.crossroad1.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.crossroad1.Player;
import com.example.crossroad1.R;

public class EndActivity extends AppCompatActivity {
    private Button restart;
    private Button exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.end_screen);

        TextView points = (TextView) findViewById(R.id.points);
        points.setText("Points: " + ConfigActivity.getPlayer().getPoints());

        restart = findViewById(R.id.restart);
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EndActivity.this, ConfigActivity.class));
            }
        });

        exit = findViewById(R.id.exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EndActivity.this, WelcomeActivity.class));
            }
        });
    }

}
