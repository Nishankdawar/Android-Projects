package com.ultron.weatherapp;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {

    EditText cityName;
    TextView weatherInfo;


    public void findWeather(View view){

        weatherInfo.setText("");


        InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(cityName.getWindowToken(), 0);

        Button findweather = (Button)findViewById(R.id.findweatherbutton);
        cityName = (EditText)findViewById(R.id.cityName);

        Log.i("Info", "Button was tapped");

        try {
            String encodedCityName = URLEncoder.encode(cityName.getText().toString(), "UTF-8");
            Log.i("Info", encodedCityName);
            Log.i("Cityname", cityName.getText().toString());
            DownloadTask task = new DownloadTask();
            task.execute("http://api.openweathermap.org/data/2.5/forecast?id=524901&APPID={d9b5c2488dd67c5275197406c2ff5a70}");
        } catch (UnsupportedEncodingException e) {

            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "Could not find weather", Toast.LENGTH_LONG).show();
        }


    }


    public class DownloadTask extends AsyncTask<String, Void, String> {

        URL url;
        HttpURLConnection urlConnection = null;
        String result = "";
        @Override
        protected String doInBackground(String... urls) {
            try {
                url = new URL(urls[0]);
                urlConnection = (HttpURLConnection)url.openConnection();
                InputStream in = urlConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);
                int data = reader.read();
                while(data != -1) {
                    char current = (char) data;
                    result += current;
                    data = reader.read();
                }
                return result;

            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "Could not find weather", Toast.LENGTH_LONG);
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {

            try {
                JSONObject jsonObject = new JSONObject(result);
                String weatherContent = jsonObject.getString("weather");
                JSONArray arr = new JSONArray(weatherContent);
                String message = "";
                String main;
                String description;
                for(int i = 0 ; i < arr.length() ; i++) {
                    JSONObject jsonPart = arr.getJSONObject(i);
                    main = jsonPart.getString("main");
                    description = jsonPart.getString("description");
                    if(main != "" && description != "") {
                        message += main + ":" + description + "\r\n";
                    }

                }
                if(message != "") {
                    weatherInfo.setText(message);
                } else {
                    Toast.makeText(getApplicationContext(), "Could not find weather", Toast.LENGTH_LONG).show();
                }



            } catch (JSONException e) {

                Toast.makeText(getApplicationContext(), "Could not find weather", Toast.LENGTH_LONG).show();
            }


            Log.i("URL content", result);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        weatherInfo = (TextView)findViewById(R.id.weatherInfo);




    }
}
