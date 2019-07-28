package com.example.gridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int [] cricketerImg = {R.drawable.mash,R.drawable.riad,R.drawable.shakib,R.drawable.tamim};
    String [] cricketerName;
    GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView=findViewById(R.id.gridViewId);

        cricketerName = getResources().getStringArray(R.array.cricketer);

        CustomAdapter adapter = new CustomAdapter(this,cricketerName,cricketerImg);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = cricketerName[i];
                Toast.makeText(MainActivity.this, ""+item, Toast.LENGTH_SHORT).show();
            }
        });


    }
}
