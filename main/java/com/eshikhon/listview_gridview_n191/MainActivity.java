package com.eshikhon.listview_gridview_n191;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView myListView;

    String[] fruits = {"Mango","Banana","Jackfruit","Apple","Litchi"};
    Integer[] image ={R.drawable.m,R.drawable.b,R.drawable.j,R.drawable.a,R.drawable.l};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myListView=findViewById(R.id.lv);

       // ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,fruits);

        CustomListAdapter adapter=new CustomListAdapter(this,fruits,image);

        myListView.setAdapter(adapter);


    }
}
