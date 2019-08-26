package com.vogella.android.nggandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

import static android.view.Gravity.CENTER_HORIZONTAL;
import static android.view.Gravity.TOP;


public class PlayActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int MAX_NUMBER = 100;
    public static final Random RANDOM = new Random();
    private TextView msgTv;
    private EditText input;
    private Button guess;
    private int numberToGuess, numberOfTries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        Button backButton2 = findViewById(R.id.backButton2);
        backButton2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                startActivity(new Intent(PlayActivity.this, MainActivity.class));
            }
        });

        msgTv = findViewById(R.id.msg);
        input = findViewById(R.id.input);
        guess = findViewById(R.id.guess);
        guess.setOnClickListener(this);

        newGame();
    }
    @Override
    public void onClick(View view){
        if (view == guess) {
            guess();
        }

    }
    private void guess(){
        int n = Integer.parseInt(input.getText().toString());
        numberOfTries++;

        if (n == numberToGuess) {
            Toast.makeText(this, "Yuss!!! You got it right, congratulations!", Toast.LENGTH_LONG).show();
            newGame();
        } else if (n > numberToGuess){
            msgTv.setText(R.string.too_high);
        } else if (n < numberToGuess) msgTv.setText(R.string.too_low);
    }
    private void newGame(){
        numberToGuess = RANDOM.nextInt(MAX_NUMBER) + 1;
        msgTv.setText(R.string.start_msg);
        input.setText("");
        numberOfTries = 0;
    }
}