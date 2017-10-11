package com.ultron.animate;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    public void fade(View view) {
        ImageView simp1 = (ImageView) findViewById(R.id.simp1);
        simp1.animate()
                .translationXBy(1200f)
                .translationYBy(1200f)
                .scaleX(0.5f)
                .scaleY(0.5f)
                .rotation(3600f)
                .setDuration(5000);




    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView simp1 = (ImageView) findViewById(R.id.simp1);
        simp1.setTranslationX(-1200f);
        simp1.setTranslationY(-1200f);
    }
}
