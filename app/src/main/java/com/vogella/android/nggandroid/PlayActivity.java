package com.vogella.android.nggandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;
import java.util.Scanner;

public class PlayActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PlayActivity.this, MainActivity.class));
            }
        });

        int min = 1;

        int max = 20;

        int number = 0;


        public void guessButton (View view){

            EditText editText = findViewById(R.id.edtText);

            TextView textView = findViewById(R.id.textView3);


            int num = Integer.parseInt(editText.getText().toString());


            if (num > number) {


                textView.setText("Correct");

            } else if (num < number) {

                textView.setText("Wrong");


            } else {

                textView.setText("Try agian");

                Random r = new Random();

                number = r.nextInt(max - min + 1) + min;

            }

        }


        protected void onCreate (Bundle savedInstanceState){

            super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_main);


            Random r = new Random();

            number = r.nextInt(max - min + 1) + min;

        }
    }
}