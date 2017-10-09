package com.ultron.checknumber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    class Number {
        int tnumber;

        public boolean isTriangular() {
            int x = 1;
            int triangularnumber = 1;

            while(triangularnumber < tnumber) {

                x++;
                triangularnumber = triangularnumber + x;
            }
            if(triangularnumber == tnumber) {
                return true;
            } else {
                return false;
            }
        }
        public boolean isSquare() {

            double squareRoot = Math.sqrt(tnumber);
            if(squareRoot == Math.floor(squareRoot)) {
                return true;
            } else {
                return false;
            }

        }
    }


    public void checkNumberfunc(View view) {
        EditText getNumber = (EditText) findViewById(R.id.checkNumber);
        String message = "";


        if(getNumber.getText().toString().isEmpty()) {
            message = "Please enter a number";
            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
        } else {
            Number num = new Number();
            num.tnumber = Integer.parseInt(getNumber.getText().toString());
            if (num.isSquare() && num.isTriangular()) {
                message = num.tnumber + " is triangular as well as square number";
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
            } else if (num.isTriangular()) {
                message = num.tnumber + " is triangular number but not square";
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
            } else if (num.isSquare()) {
                message = num.tnumber + " is square number but not traingular";
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
            } else {
                message = num.tnumber + " is neither a square nor a triangular number";
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
            }
        }



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
