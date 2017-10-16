package com.ultron.listviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView mylistView = (ListView) findViewById(R.id.mylistView);

        final ArrayList<String> myFriends = new ArrayList<String>();
        myFriends.add("Rob");
        myFriends.add("Kristen");
        myFriends.add("Steve");
        myFriends.add("Bill");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myFriends);
        mylistView.setAdapter(arrayAdapter);
        mylistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, myFriends.get(position) + " was tapped", Toast.LENGTH_LONG).show();
            }
        });
    }
}
