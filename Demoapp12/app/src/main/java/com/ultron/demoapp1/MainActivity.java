package com.ultron.demoapp1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    public void dollarConvert(View view) {
        EditText myNumber = (EditText) findViewById(R.id.myNumber);

        Double numberDouble = Double.parseDouble(myNumber.getText().toString());
        Double dollarDouble = numberDouble / 65.0;
        Toast.makeText(this, dollarDouble.toString(), Toast.LENGTH_LONG).show();


        Log.i("Amount", myNumber.getText().toString());
    }
    public void euroConvert(View view) {
        EditText myNumber = (EditText) findViewById(R.id.myNumber);
        Double numberDouble = Double.parseDouble(myNumber.getText().toString());
        Double euroDouble = numberDouble / 80.0;
        Toast.makeText(this, euroDouble.toString(), Toast.LENGTH_LONG).show();


        Log.i("Amount", myNumber.getText().toString());
    }
    public void bitcoinConvert(View view) {
        EditText myNumber = (EditText) findViewById(R.id.myNumber);
        Double numberDouble = Double.parseDouble(myNumber.getText().toString());

        Double bitcoinDouble = numberDouble / 300000.0;
        Toast.makeText(this, bitcoinDouble.toString(), Toast.LENGTH_LONG).show();


        Log.i("Amount", myNumber.getText().toString());
    }
    public void yenConvert(View view) {
        EditText myNumber = (EditText) findViewById(R.id.myNumber);

        Double numberDouble = Double.parseDouble(myNumber.getText().toString());

        Double yenDouble = numberDouble / 20.0;

        Toast.makeText(this, yenDouble.toString(), Toast.LENGTH_LONG).show();


        Log.i("Amount", myNumber.getText().toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
