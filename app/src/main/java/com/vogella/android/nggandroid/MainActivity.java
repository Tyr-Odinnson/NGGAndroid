package com.vogella.android.nggandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    Animation fadinAnimation;
    Animation flyinAnimation;
    Button exitButton;
    Button playButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playButton = findViewById(R.id.playButton);

        playButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, PlayActivity.class));
            }
        });
        Button instructionsButton = findViewById(R.id.instructionsButton);
        instructionsButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, InstructionsActivity.class));
            }
        });
        exitButton = findViewById(R.id.exitButton);
        exitButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();
                System.exit(0);
            }
        });

        //Todo set animation to button
        fadinAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        flyinAnimation = AnimationUtils.loadAnimation(this, R.anim.flyin);

    }
    protected void onStart(){
        super.onStart();
        exitButton.startAnimation(fadinAnimation);
        playButton.startAnimation(flyinAnimation);
    }
}
