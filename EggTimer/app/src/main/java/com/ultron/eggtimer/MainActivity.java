package com.ultron.eggtimer;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SeekBar timerseekBar;
    TextView timertextView;
    Boolean counterIsActive = false;
    Button controllerbutton;
    CountDownTimer countDownTimer;
    public void resetTimer(){
        timertextView.setText("0:30");
        timerseekBar.setProgress(30);
        controllerbutton.setText("Go!");
        timerseekBar.setEnabled(true);
        counterIsActive = false;
        countDownTimer.cancel();

    }
    public void updatetimer(int secondsLeft) {
        int minutes = (int)secondsLeft/60;
        int seconds = secondsLeft - minutes * 60; //Left over seconds

        String secondsString = Integer.toString(seconds);
        if(seconds <= 9) {
            secondsString = "0" + secondsString;
        }


        timertextView.setText(Integer.toString(minutes) + ":" + secondsString);
    }

    public void controlTimer(View view) {
        if(counterIsActive == false) {
            counterIsActive = true;
            controllerbutton = (Button)findViewById(R.id.controllerbutton);
            controllerbutton.setText("Stop!");

            timerseekBar.setEnabled(false);
             countDownTimer = new CountDownTimer(timerseekBar.getProgress() * 1000 + 100, 1000) {

                @Override
                public void onTick(long millisUntilFinished) {
                    updatetimer((int) millisUntilFinished / 1000);
                }

                @Override
                public void onFinish() {
                    timertextView.setText("0:00");
                    MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.sound);
                    mediaPlayer.start();
                    resetTimer();
                }
            }.start();
        }  else {

                resetTimer();

        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerseekBar = (SeekBar)findViewById(R.id.timerseekBar);
        timertextView = (TextView)findViewById(R.id.timertextView);

        timerseekBar.setMax(600);
        timerseekBar.setProgress(30);

        timerseekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                updatetimer(progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
