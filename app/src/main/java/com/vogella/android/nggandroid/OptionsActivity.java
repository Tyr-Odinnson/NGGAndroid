package com.vogella.android.nggandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class OptionsActivity extends AppCompatActivity {

    //Declare Image Button var (as a global var) and boolean var to control play/stop states
    private ImageButton soundButton;
    private boolean isPlaying = true;
    //


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        //Initialise the button onCreate() with findViewBy

        //Register a onClickListener to the button
        soundButton = findViewById(R.id.soundButton);
        soundButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                if(isPlaying)
                {
                    soundButton.setImageResource(R.drawable.ic_sound_off);
                } else {
                    soundButton.setImageResource(R.drawable.ic_sound_on);
                }
                isPlaying = !isPlaying;
            }
        });
    }
}
