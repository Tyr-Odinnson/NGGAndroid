package com.vogella.android.nggandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button exitButton = findViewById(R.id.exitButton);
        exitButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();
                System.exit(0);
            }
        });
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        Button instructionsButton = findViewById(R.id.instructionsButton);
        instructionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, InstructionsActivity.class));
            }
        });

        Button playButton = findViewById(R.id.playButton);
        instructionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, PlayActivity.class));
=======
=======
>>>>>>> parent of 33e59de... ..
=======
>>>>>>> parent of 33e59de... ..
        Button optionsButton = findViewById(R.id.optionsButton);
        optionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> parent of 33e59de... ..
=======
>>>>>>> parent of 33e59de... ..
=======
>>>>>>> parent of 33e59de... ..
            }
        });
    }
}