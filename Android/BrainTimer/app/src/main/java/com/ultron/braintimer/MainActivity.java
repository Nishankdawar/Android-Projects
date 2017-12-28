package com.ultron.braintimer;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int no_of_questions;
    int no_of_correct_answers;
    CountDownTimer timer;
    String operator;
    Button startButton;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button stopbutton;
    TextView timertextView;
    TextView expressiontextView;
    TextView scoretextView;
    Button scorebutton;
    GridLayout optionsContainer;
    TextView resulttextView;
    int correctAnswer;
    ArrayList<String>operatorList = new ArrayList<String>();
    int num1;
    int num2;
    int num3;


    public void makeVisible() {

        timertextView.setVisibility(View.VISIBLE);


        scoretextView.setVisibility(View.VISIBLE);


        optionsContainer.setVisibility(View.VISIBLE);


        expressiontextView.setVisibility(View.VISIBLE);

        stopbutton.setVisibility(View.VISIBLE);


    }

    public void makeinVisible() {


        timertextView.setVisibility(View.INVISIBLE);


        scoretextView.setVisibility(View.INVISIBLE);


        expressiontextView.setVisibility(View.INVISIBLE);


        optionsContainer.setVisibility(View.INVISIBLE);

        scorebutton.setVisibility(View.INVISIBLE);

        stopbutton.setVisibility(View.INVISIBLE);


    }

    public void setButtons() {

        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        button4 = (Button)findViewById(R.id.button4);
    }


    public int getRandomint() {
        Random rand = new Random();
        int random = rand.nextInt(151);
        return random;
    }

    public void setTextonButtons(int correctAnswer) {
        Random rand = new Random();
        int num = rand.nextInt(4);
        ArrayList<Button> buttonslist = new ArrayList<Button>();
        buttonslist.addAll(Arrays.asList(button1, button2, button3, button4));
        buttonslist.get(num).setText(Integer.toString(correctAnswer));

        // SET WRONG TEXT ON THE REMAINING BUTTONS
        for(int i = 0 ; i < buttonslist.size(); i++) {
            int random = rand.nextInt(51);
            if(random == correctAnswer) {
                random = getRandomint();
            }
            if(i != num) {
                buttonslist.get(i).setText(Integer.toString(random));
            }
        }

    }


    public int getAnswer(int num1, int num2, String operator) {
        switch(operator) {
            case "+": return (num1 + num2);
            case "-": return (num1 - num2);
            case "*": return (num1 * num2);
            case "/": return (num1 / num2);
        }
        return 0;
    }

    public void setnextQuestion(){
        Random rand = new Random();
        num1 = rand.nextInt(31);
        num2 = rand.nextInt(31);
        num3 = rand.nextInt(4);
        operator = operatorList.get(num3);
        expressiontextView.setText(Integer.toString(num1) + operator + Integer.toString(num2));
        correctAnswer = getAnswer(num1, num2, operator);
        setButtons();
        setTextonButtons(correctAnswer);
        no_of_questions++;
    }
    public void updateScore(){
        scoretextView.setText(Integer.toString(no_of_correct_answers) + "/" + Integer.toString(no_of_questions));
        setnextQuestion();
    }

    public void checkAnswer(View view) {
        int intId = view.getId();
        Button button = (Button) findViewById(intId);
        int ans = Integer.parseInt(button.getText().toString());


        if (ans == correctAnswer) {
            resulttextView.setText("CORRECT");
            no_of_correct_answers++;

        }
        else {

            resulttextView.setText("INCORRECT");
        }
        updateScore();
    }

    public void stop(View view) {
        timer.cancel();
        startButton.setVisibility(View.VISIBLE);
        makeinVisible();
        resulttextView.setText("");
        startButton.setText("Play");
        MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.sound);
        mediaPlayer.start();
        scorebutton.setVisibility(View.VISIBLE);
        scorebutton.setText(Integer.toString(no_of_correct_answers) + "/" + Integer.toString(no_of_questions));

    }

    public void start(View view) {
        no_of_questions = 0;
        no_of_correct_answers = 0;
        startButton.setVisibility(View.INVISIBLE);
        scorebutton.setVisibility(View.INVISIBLE);

        scoretextView.setText(Integer.toString(no_of_correct_answers) + "/" + Integer.toString(no_of_questions));
        makeVisible();
        setnextQuestion();

         timer = new CountDownTimer(30300, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                timertextView.setText(millisUntilFinished/1000 + "s" );

            }

            @Override
            public void onFinish() {

                timertextView.setText(0 + "s");
                startButton.setVisibility(View.VISIBLE);
                makeinVisible();
                resulttextView.setText("");
                startButton.setText("Play");
                MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.sound);
                mediaPlayer.start();
                scorebutton.setVisibility(View.VISIBLE);
                scorebutton.setText(Integer.toString(no_of_correct_answers) + "/" + Integer.toString(no_of_questions));

            }

        }.start();


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = (Button)findViewById(R.id.startButton);
        timertextView = (TextView)findViewById(R.id.timertextView);
        scoretextView = (TextView)findViewById(R.id.scoretextView);
        expressiontextView = (TextView)findViewById(R.id.expressiontextView);
        optionsContainer = (GridLayout)findViewById(R.id.optionsContainer);
        resulttextView = (TextView)findViewById(R.id.resulttextView);
        scorebutton = (Button)findViewById(R.id.scorebutton);
        operatorList.addAll(Arrays.asList("+","-","*","/"));
        stopbutton = (Button)findViewById(R.id.stopButton);

        makeinVisible();



    }
}
