package com.example.radiobuttonandcheckbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CheckBox pCB,bCB,sCB;
    TextView showOrder,showRadio;

    RadioGroup radioGroup;
    RadioButton radioButton;
    Button showButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pCB = findViewById(R.id.pizzaId);
        bCB=findViewById(R.id.burgerId);
        sCB = findViewById(R.id.sandwichId);
        showOrder = findViewById(R.id.showOrder);


        radioGroup = findViewById(R.id.radioGroupId);
        showButton = findViewById(R.id.radio);
        showRadio = findViewById(R.id.showRadio);

        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int select = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(select);

                 String item  = radioButton.getText().toString();
                showRadio.setText("You selected : "+item);
            }
        });

    }

    public void order(View view) {

        int totalAmount =0;

        StringBuilder result = new StringBuilder();
        result.append("Selected Items\n-------------------------");

        if(pCB.isChecked()){
            result.append("\n Pizza is 100 Tk");
            totalAmount+=100;

        }
        if (bCB.isChecked()){
            result.append("\n Burger is 80 Tk");
            totalAmount+=80;
        }
        if(sCB.isChecked()){
            result.append("\n Sandwitch  is 40 Tk");
            totalAmount+=40;
        }

        result.append("\n----------------------------------\nTotal :"+totalAmount);
        showOrder.setText(result);

    }
}
