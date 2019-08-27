package com.example.emailsmscall;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView call;
    EditText callET;

    EditText editTextTo;
    EditText editTextSubject;
    EditText editTextMessage;
    Button sendEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        editTextTo=findViewById(R.id.email);
        editTextSubject=findViewById(R.id.subject);
        editTextMessage=findViewById(R.id.message);
        sendEmail=findViewById(R.id.sendEmail);

        callET=findViewById(R.id.callId);

        // Intent Email=====================================

        sendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMail();
            }
        });







        //Intent Call========================================

        call = findViewById(R.id.call);

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                String number = callET.getText().toString();
                callIntent.setData(Uri.parse("tel:"+number));

                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                    return;

                }

                startActivity(callIntent);
            }
        });

    }

    // Send Email Method======================

    private void sendMail() {

        String recioientList = editTextTo.getText().toString();
        String []  recipient = recioientList.split(",");

        String subject = editTextSubject.getText().toString();
        String messege = editTextMessage.getText().toString();


        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL,recipient);
        intent.putExtra(Intent.EXTRA_SUBJECT,subject);
        intent.putExtra(Intent.EXTRA_TEXT,messege);

        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent,"Chosse an email"));

    }
}
