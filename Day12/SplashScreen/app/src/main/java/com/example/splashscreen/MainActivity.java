package com.example.splashscreen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void fade(View view) {
        ImageView catOne = findViewById(R.id.cat);
       // catOne.animate().alpha(0).setDuration(2000);
        //catOne.animate().translationX(1000f).setDuration(4000);
        //catOne.animate().translationY(1000f).setDuration(4000);
        //catOne.animate().scaleX(.2f).scaleY(.2f).setDuration(4000);
        //catOne.animate().rotation(-360).setDuration(2000);
        catOne.animate()
                .translationY(1000f)
                .translationX(1000f)
                .rotation(360)
                .setDuration(2000);


    }
}
