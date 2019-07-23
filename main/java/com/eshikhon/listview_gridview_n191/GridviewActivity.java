package com.eshikhon.listview_gridview_n191;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

public class GridviewActivity extends AppCompatActivity {
    GridView gridView;
    GridAdapter adapter;
    ArrayList<Cricketer> cricketers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview);

        gridView = findViewById(R.id.gv);

        cricketers =new ArrayList<>();
        setDataOfCricketers();
        adapter = new GridAdapter(cricketers,GridviewActivity.this);
        gridView.setAdapter(adapter);
    }

    private void setDataOfCricketers() {
        Cricketer shakib = new Cricketer(R.drawable.shakib,"Shakib");
        Cricketer mash = new Cricketer(R.drawable.mash,"Mashrafe");
        Cricketer tamim = new Cricketer(R.drawable.tamim,"Tamim");
        Cricketer riad = new Cricketer(R.drawable.riad,"Riad");

        cricketers.add(shakib);
        cricketers.add(mash);
        cricketers.add(tamim);
        cricketers.add(riad);

        cricketers.add(shakib);
        cricketers.add(mash);
        cricketers.add(tamim);

        cricketers.add(shakib);
        cricketers.add(mash);
        cricketers.add(tamim);

        cricketers.add(shakib);
        cricketers.add(mash);
        cricketers.add(tamim);
    }
}
