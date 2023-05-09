package com.example.contactus;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    Button send,whatsapp,dialer,website;
    EditText title,body;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        send=findViewById(R.id.button);
        title=findViewById(R.id.editTextTextMultiLine);
        body=findViewById(R.id.editTextTextMultiLine2);
        whatsapp=findViewById(R.id.button2);
        dialer=findViewById(R.id.button3);



        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String recipient = "anssraza41@gmail.com";
                String subject = title.getText().toString();
                String body1 = body.getText().toString();

                if (subject.isEmpty() || body1.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please fill in both fields.", Toast.LENGTH_SHORT).show();
                } else {
                    Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                    emailIntent.setData(Uri.parse("mailto:" + recipient));
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
                    emailIntent.putExtra(Intent.EXTRA_TEXT, body1);

                    startActivity(Intent.createChooser(emailIntent, "Send email using:"));
                }
            }

        });


        whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String url = "https://api.whatsapp.com/send?phone=+923029788441"; // replace with your phone number
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);


            }
        });


        dialer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNumber = "03029788441"; // replace with your phone number
                Intent dialIntent = new Intent(Intent.ACTION_DIAL);
                dialIntent.setData(Uri.parse("tel:" + phoneNumber));
                startActivity(dialIntent);
            }
        });


    }
}