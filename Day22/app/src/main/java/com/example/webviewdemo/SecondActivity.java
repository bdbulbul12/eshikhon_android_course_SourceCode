package com.example.webviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tv= findViewById(R.id.tvId);

        Bundle bundle = getIntent().getExtras();

        if(bundle!=null){

            String value = bundle.getString("Tamim");
            tv.setText(value);
        }



    }
}
