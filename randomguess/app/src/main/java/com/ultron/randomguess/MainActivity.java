package com.ultron.randomguess;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int randomNumber;
    public void guessNumber(View view) {
        EditText number = (EditText) findViewById(R.id.numberguess);
        int integernumber = Integer.parseInt(number.getText().toString());

        if(randomNumber < integernumber) {
            Toast.makeText(this, "Guessed integer is greater than the original number", Toast.LENGTH_SHORT).show();
        }
        else if(randomNumber > integernumber) {
            Toast.makeText(this, "Guessed integer is smaller than the original number", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Guessed number is equal to the original number", Toast.LENGTH_SHORT).show();
            Random rand = new Random();
            randomNumber = rand.nextInt(20) + 1;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Random rand = new Random();
        randomNumber = rand.nextInt(20) + 1;
    }
}
