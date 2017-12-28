package com.ultron.timestables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ListView timestablelistview;


    public void generatetimesTable(int timesTable) {

        ArrayList<String> timesTableContent = new ArrayList<String>();
        for(int i = 1  ; i <= 10; i++) {
            timesTableContent.add(Integer.toString(i * timesTable));
        }
        ArrayAdapter<String> timestableadapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, timesTableContent);
        timestablelistview.setAdapter(timestableadapter);
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
                if(progress < 1) {
                    timesTable = min;
                    timestableseekbar.setProgress(min);
                } else {
                    timesTable = progress;
                }
                generatetimesTable(timesTable);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        generatetimesTable(0); // Since initially there should be a value which needs to be displayed on the screen therefore we have set the value inside the generatetimesTable function to 10(because initially it will be in the middle and we have set maximum to 20 tereforeits middle would be 10... We can call the function with other values also but in middle the table of that number would be displayed...)

    }
}
