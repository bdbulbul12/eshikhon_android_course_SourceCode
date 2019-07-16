package com.example.listviewapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listViewId);

        final String [] myFrnds = getResources().getStringArray(R.array.myFriends);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this,R.layout.sample_view,R.id.textViewId,myFrnds);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                String ItemValue = myFrnds[position];

                Toast.makeText(MainActivity.this, ""+ItemValue, Toast.LENGTH_SHORT).show();
            }
        });






    }
}
