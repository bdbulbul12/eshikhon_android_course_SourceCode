package com.example.playwithrandomnumber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    int randomNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random rand = new Random();
        randomNumber=rand.nextInt(20)+1;


    }

    public void clickMe(View view) {
        EditText storageEditext = findViewById(R.id.userNumber);
        int guessInt = Integer.parseInt(storageEditext.getText().toString());

        if(guessInt>randomNumber){
            Toast.makeText(this, "Input Lower", Toast.LENGTH_SHORT).show();
        }else if(guessInt<randomNumber){
            Toast.makeText(this, "Input Higher", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Cograts !! you are win", Toast.LENGTH_SHORT).show();
        }


    }
}
