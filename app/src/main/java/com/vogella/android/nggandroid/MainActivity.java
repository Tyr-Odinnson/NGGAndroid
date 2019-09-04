package com.vogella.android.nggandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import static android.graphics.Color.BLACK;


public class MainActivity extends AppCompatActivity {

    Animation fadinAnimation;
    Animation flyinAnimation;
    Button exitButton;
    Button playButton;
    private TextToSpeech tts;
    private MediaPlayer mediaPlayer;
    private ImageButton soundButton;
    private SharedPreferences preferences;
    private boolean isPlaying = true;
    private boolean soundOn = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playButton = findViewById(R.id.playButton);
        preferences = PreferenceManager.getDefaultSharedPreferences(this);



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
                 //   tts.speak("The sound is off", TextToSpeech.QUEUE_FLUSH, null);
                    mediaPlayer.pause();
                } else {
                    soundButton.setImageResource(R.drawable.ic_sound_on);
                    mediaPlayer.start();
                 //   tts.speak("The sound is on!", TextToSpeech.QUEUE_FLUSH, null);
                }
                isPlaying = !isPlaying;
            }
        });

    }
    @Override
    protected void onStart(){
        super.onStart();

        String username = preferences.getString("Username", "Anonymous");

        Toast toast = Toast.makeText(this, "Hello " + username, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
        TextView v = toast.getView().findViewById(android.R.id.message);
        View view = toast.getView();
        view.getBackground().setColorFilter(BLACK, PorterDuff.Mode.SRC_IN);
        v.setTextColor(Color.CYAN);
        toast.show();
        exitButton.startAnimation(fadinAnimation);
        playButton.startAnimation(flyinAnimation);
        soundOn = preferences.getBoolean("sound", true);
        if(soundOn)
        {
            mediaPlayer.start();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(isPlaying){
            mediaPlayer.pause();

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mediaPlayer != null){
            mediaPlayer.stop();
            mediaPlayer = null;
        }
    }
}
