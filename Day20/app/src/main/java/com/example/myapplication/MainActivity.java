package com.example.myapplication;


import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner mySpinner;
    Button spinnerBtn,ratingBtn;
    RatingBar ratingBar;

    String myFriends [] = {"Sakib","Tamim","Riad","Mash"};


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==R.id.settingId){
            Toast.makeText(this, "Setting Clicked", Toast.LENGTH_SHORT).show();
            return true;
        }

        if(item.getItemId()==R.id.ratting){
            Toast.makeText(this, "Ratting Clicked", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mySpinner=findViewById(R.id.spinnerId);
        spinnerBtn = findViewById(R.id.spinnerBtnId);

        ratingBar = findViewById(R.id.ratingBarId);
        ratingBtn=findViewById(R.id.rattingBtnId);






        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,myFriends);
        mySpinner.setAdapter(adapter);



        ratingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = String.valueOf((ratingBar.getRating()));

                Toast.makeText(MainActivity.this, ""+value, Toast.LENGTH_SHORT).show();

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Alert Demo");
                builder.setMessage(value);
                builder.setCancelable(true);

                builder.setPositiveButton(
                        "Yes",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        }
                );

                builder.setNegativeButton(
                        "No",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                            }
                        }
                );

                builder.show();

            }
        });




        spinnerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String value =  mySpinner.getSelectedItem().toString();
                Toast.makeText(MainActivity.this, ""+value, Toast.LENGTH_SHORT).show();
            }
        });



    }
}
