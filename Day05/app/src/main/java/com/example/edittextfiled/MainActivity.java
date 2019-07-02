package com.example.edittextfiled;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText numberOne,numberTwo;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        numberOne = findViewById(R.id.numberOne);
        numberTwo=findViewById(R.id.numberTwo);

        btn = findViewById(R.id.btnId);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              int n = Integer.parseInt(numberOne.getText().toString());
              int n2 = Integer.parseInt(numberTwo.getText().toString());

              int sum = n+n2;

                Toast.makeText(MainActivity.this, "Your Result is : "+sum, Toast.LENGTH_SHORT).show();

            }
        });


    }
}
