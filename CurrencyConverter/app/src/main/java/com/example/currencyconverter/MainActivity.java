package com.example.currencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText amount;
    Button convert;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            amount=findViewById(R.id.amountId);
            convert=findViewById(R.id.converter);


                convert.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Double tk = Double.valueOf(amount.getText().toString());
                        Double dollar =   tk*0.012;

                        Toast.makeText(MainActivity.this, "$ "+dollar, Toast.LENGTH_SHORT).show();

                    }
                });
            }


            }





