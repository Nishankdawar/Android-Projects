package com.ultron.timestable2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView timestablelistview;
    public void generatetimestable(int timesTable) {
        ArrayList<String> timesTableList = new ArrayList<String>();
        for(int i = 1 ; i <= 10 ; i++ ) {
            timesTableList.add(Integer.toString(i * timesTable));
        }
        ArrayAdapter<String> timesTableadapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, timesTableList);
        timestablelistview.setAdapter(timesTableadapter);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar timestableseekbar = (SeekBar)findViewById(R.id.timestableseekBar);
        timestablelistview = (ListView)findViewById(R.id.timestablelistview);

        timestableseekbar.setMax(20);
        timestableseekbar.setProgress(10);

        timestableseekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;
                int timesTable;
                if(progress < min) {
                    timesTable = min;
                    timestableseekbar.setProgress(min);

                } else {
                    timesTable = progress;
                }
                generatetimestable(timesTable);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        generatetimestable(10);


    }
}
