package com.vogella.android.nggandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;


public class MainActivity extends AppCompatActivity {

    Animation fadinAnimation;
    Animation flyinAnimation;
    Button exitButton;
    Button playButton;
    private TextToSpeech tts;
    private MediaPlayer mediaPlayer;
    private ImageButton soundButton;
    private boolean isPlaying = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playButton = findViewById(R.id.playButton);

        mediaPlayer = MediaPlayer.create(this, R.raw.aeris_theme);
        mediaPlayer.setLooping(true);

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

        Button optionsButton = findViewById(R.id.optionsButton);
        optionsButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, OptionsActivity.class));
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

        soundButton = findViewById(R.id.soundButton);
        soundButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                if(isPlaying)
                {
                    soundButton.setImageResource(R.drawable.ic_sound_off);
                 //   tts.speak("The sound is off", TextToSpeech.QUEUE_FLUSH, null); //
                    mediaPlayer.pause();
                } else {
                    soundButton.setImageResource(R.drawable.ic_sound_on);

                 //   tts.speak("The sound is on!", TextToSpeech.QUEUE_FLUSH, null); //
                }
                isPlaying = !isPlaying;
            }
        });

    }
    @Override
    protected void onStart(){
        super.onStart();
        exitButton.startAnimation(fadinAnimation);
        playButton.startAnimation(flyinAnimation);
        mediaPlayer.start();
    }
}
