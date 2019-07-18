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
    String [] flowerNames;
    private int[] flowers = {R.drawable.rose,R.drawable.sun,R.drawable.tuilip};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listViewId);
        flowerNames = getResources().getStringArray(R.array.flowers);

//        final String [] myFrnds = getResources().getStringArray(R.array.myFriends);
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this,R.layout.sample_view,R.id.textViewId,myFrnds);
//        listView.setAdapter(adapter);


//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//
//                String ItemValue = myFrnds[position];
//
//                Toast.makeText(MainActivity.this, ""+ItemValue, Toast.LENGTH_SHORT).show();
//            }
//        });

        CustomAdapter adapter = new CustomAdapter(this,flowerNames,flowers);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = flowerNames[i];
                Toast.makeText(MainActivity.this, ""+item, Toast.LENGTH_SHORT).show();
            }
        });






    }
}
