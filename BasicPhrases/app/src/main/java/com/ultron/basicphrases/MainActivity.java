package com.ultron.basicphrases;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;

public class MainActivity extends AppCompatActivity {

    public void buttonTapped(View view) {
        int id = view.getId();
        Log.i("id", Integer.toString(id));
        String ourId = "";

        ourId = view.getResources().getResourceEntryName(id); // To get the id of the buttton which we pressed(Through this we are getting the name in string of the id which we set of the button for eg for the button "hello" we inintialize it with the id hello)
        //Above line says to bring all the resources and then get the resource name whose id is equal to view id
        Log.i("ourId", ourId);
        int resourceId = getResources().getIdentifier(ourId, "raw", "com.ultron.basicphrases"); //(Identifier, Location, PackageName)
        Log.i("resourceID", Integer.toString(resourceId));
        MediaPlayer mediaPlayer = MediaPlayer.create(this,resourceId);
        mediaPlayer.start();

        Log.i("ButtonTapped", ourId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
